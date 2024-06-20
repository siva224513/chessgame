package chessgame;

import chessgame.pieces.*;

public class Board {
	private Piece board[][];
	private GameStatus gameStatus;

	public Board() {
		board = new Piece[8][8];
		gameStatus = new GameStatus(this);
		intitializeBoard();
		displayBoard();
	}

	protected void displayBoard() {
		System.out.println();

		// Print column indices
		System.out.print("   ");
		for (int j = 0; j < 8; j++) {
			System.out.print(" " + j + " ");
		}
		System.out.println();

		for (int i = 0; i < 8; i++) {
			// Print row index
			System.out.print(i + "  ");

			for (int j = 0; j < 8; j++) {
				if (board[i][j] != null) {
					System.out.print(board[i][j] + " ");
				} else {
					System.out.print("-- ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private void intitializeBoard() {
		board[0][0] = new Rook(Colour.BLACK, 0, 0);
		board[0][1] = new Knight(Colour.BLACK, 0, 1);
		board[0][2] = new Bishop(Colour.BLACK, 0, 2);
		board[0][3] = new Queen(Colour.BLACK, 0, 3);
		board[0][4] = new King(Colour.BLACK, 0, 4);
		board[0][5] = new Bishop(Colour.BLACK, 0, 5);
		board[0][6] = new Knight(Colour.BLACK, 0, 6);
		board[0][7] = new Rook(Colour.BLACK, 0, 7);
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(Colour.BLACK, 1, i);
			board[6][i] = new Pawn(Colour.WHITE, 6, i);
		}
		board[7][0] = new Rook(Colour.WHITE, 7, 0);
		board[7][1] = new Knight(Colour.WHITE, 7, 1);
		board[7][2] = new Bishop(Colour.WHITE, 7, 2);
		board[7][3] = new Queen(Colour.WHITE, 7, 3);
		board[7][4] = new King(Colour.WHITE, 7, 4);
		board[7][5] = new Bishop(Colour.WHITE, 7, 5);
		board[7][6] = new Knight(Colour.WHITE, 7, 6);
		board[7][7] = new Rook(Colour.WHITE, 7, 7);

	}

	public Piece getPiece(int row, int col) {
		return board[row][col];
	}

	public void setPiece(int row, int col, Piece piece) {
		board[row][col] = piece;
	}

	public boolean isValidMove(Piece piece, int destRow, int destCol) {
		if (piece == null || destRow < 0 || destRow > 7 || destCol < 0 || destCol > 7) {
			return false;
		}
		Piece destPiece = board[destRow][destCol];

		if (destPiece != null && destPiece.getColour() == piece.getColour()) {
			return false;
		}

		return piece.canMove(this, destRow, destCol);

	}

	public boolean isKingInCheck(Colour colour) {
		return gameStatus.isKingInCheck(colour);
	}

	public boolean isCheckmate(Colour colour) {
		return gameStatus.isCheckmate(colour);
	}

	public boolean isStalemate(Colour colour) {
		return gameStatus.isStalemate(colour);
	}

}
