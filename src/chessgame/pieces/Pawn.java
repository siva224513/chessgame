package chessgame.pieces;

import chessgame.Board;
import chessgame.Colour;

public class Pawn extends Piece {

	public Pawn(Colour colour, int row, int col) {
		super(colour, row, col);

	}

	@Override
	public boolean canMove(Board board, int desRow, int desCol) {
		int rowDiff = desRow - row;
		int colDiff = Math.abs(desCol - col);
		
		if (colour == Colour.BLACK) {
			// Regular move
			if (rowDiff == 1 && colDiff == 0) {
				return board.getPiece(desRow, desCol) == null;
			}
			// two-step move
			if (row == 1 && rowDiff == 2 && colDiff == 0) {
				return board.getPiece(desRow, desCol) == null && board.getPiece(row + 1, col) == null;
			}
			// Diagonal
			if (rowDiff == 1 && colDiff == 1) {
				Piece targetPiece = board.getPiece(desRow, desCol);
				return targetPiece != null && targetPiece.getColour() == Colour.WHITE;

			}
		} else {
			// Regular move
			if (rowDiff == -1 && colDiff == 0) {
				return board.getPiece(desRow, desCol) == null;
			}
			// two-step move
			if (row == 6 && rowDiff == -2 && colDiff == 0) {
				return board.getPiece(desRow, desCol) == null && board.getPiece(row - 1, col) == null;
			}
			// Diagonal
			if (rowDiff == -1 && colDiff == 1) {
				Piece targetPiece = board.getPiece(desRow, desCol);
				return targetPiece != null && targetPiece.getColour() == Colour.BLACK;

			}
		}
		return false;
	}

	public String toString() {
		return colour == Colour.WHITE ? "WP" : "BP";
	}

}
