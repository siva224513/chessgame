package chessgame;

import chessgame.pieces.Piece;
import chessgame.pieces.King;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {

	private Board board;
	private static int kingRow = -1, kingCol = -1;

	public GameStatus(Board board) {
		this.board = board;
	}

	public boolean isKingInCheck(Colour colour) {

		// Find the king's position
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Piece piece = board.getPiece(row, col);
				if (piece != null && piece instanceof King && piece.getColour() == colour) {
					kingRow = row;
					kingCol = col;
					break;
				}
			}
		}

		// Check if any opponent piece can move to the king's position
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Piece piece = board.getPiece(row, col);
				if (piece != null && piece.getColour() != colour) {
					if (piece.canMove(board, kingRow, kingCol) || (row == kingRow && col == kingCol)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public List<int[]> getAllPossibleMoves(Colour colour) {
		List<int[]> possibleMoves = new ArrayList<>();

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Piece piece = board.getPiece(row, col);
				if (piece != null && piece.getColour() == colour) {
					for (int destRow = 0; destRow < 8; destRow++) {
						for (int destCol = 0; destCol < 8; destCol++) {
							if (board.isValidMove(piece, destRow, destCol)) {
								possibleMoves.add(new int[] { row, col, destRow, destCol });
							}
						}
					}
				}
			}
		}

		return possibleMoves;
	}

	public boolean isCheckmate(Colour colour) {
		if (!isKingInCheck(colour)) {
			return false;
		}

		List<int[]> possibleMoves = getAllPossibleMoves(colour);
		for (int[] move : possibleMoves) {
			int srcRow = move[0];
			int srcCol = move[1];
			int destRow = move[2];
			int destCol = move[3];

			Piece piece = board.getPiece(srcRow, srcCol);
			Piece destPiece = board.getPiece(destRow, destCol);

			// Make the move temporarily
			board.setPiece(destRow, destCol, piece);
			board.setPiece(srcRow, srcCol, null);

			// Check if the king is still in check
			boolean isStillInCheck = isKingInCheck(colour);

			// Undo the move
			board.setPiece(srcRow, srcCol, piece);
			board.setPiece(destRow, destCol, destPiece);

			if (!isStillInCheck) {
				return false;
			}
		}

		return true;
	}

	public boolean isStalemate(Colour colour) {
		if (isKingInCheck(colour)) {
			return false;
		}

		List<int[]> possibleMoves = getAllPossibleMoves(colour);
		for (int[] move : possibleMoves) {
			int srcRow = move[0];
			int srcCol = move[1];
			int destRow = move[2];
			int destCol = move[3];

			Piece piece = board.getPiece(srcRow, srcCol);
			Piece destPiece = board.getPiece(destRow, destCol);

			// Make the move temporarily
			board.setPiece(destRow, destCol, piece);
			board.setPiece(srcRow, srcCol, null);

			// Check if the king is in check
			boolean isInCheck = isKingInCheck(colour);

			// Undo the move
			board.setPiece(srcRow, srcCol, piece);
			board.setPiece(destRow, destCol, destPiece);

			if (!isInCheck) {
				return false;
			}
		}

		return true;
	}
}
