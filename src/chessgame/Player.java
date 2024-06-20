package chessgame;

import chessgame.pieces.Piece;

public class Player {
	private final String name;
	private final Colour colour;

	public Player(String name, Colour colour) {
		this.name = name;
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}

	public void canMove(Board board, Move move) throws InvalidMoveException {
		Piece piece = move.getPiece();
		int destRow = move.getDestRow();
		int destCol = move.getDestCol();
		
		if(board.isValidMove(piece,destRow,destCol)) {
			int sourceRow = piece.getRow();
			int sourceCol = piece.getCol();
			piece.setRow(destRow);
			piece.setCol(destCol);
			board.setPiece(sourceRow, sourceCol, null);
			board.setPiece(destRow, destCol, piece);
		}
		else {
			throw new InvalidMoveException("Invalid move");
		}

	}

}
