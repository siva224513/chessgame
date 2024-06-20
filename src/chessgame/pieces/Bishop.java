package chessgame.pieces;

import chessgame.Board;
import chessgame.Colour;

public class Bishop extends Piece {

	public Bishop(Colour colour, int row, int col) {
		super(colour, row, col);
	}

	@Override
	public boolean canMove(Board board, int desRow, int desCol) {
		int rowDiff = Math.abs(row - desRow);
		int colDiff = Math.abs(col - desCol);
		return (rowDiff == colDiff);
	}

	public String toString() {
		return colour == Colour.WHITE ? "WB" : "BB";
	}

}
