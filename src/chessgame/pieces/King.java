package chessgame.pieces;

import chessgame.Board;
import chessgame.Colour;

public class King extends Piece {

	public King(Colour colour, int row, int col) {
		super(colour, row, col);
	}

	@Override
	public boolean canMove(Board board, int desRow, int desCol) {
		int rowDiff = Math.abs(desRow - row);
		int colDiff = Math.abs(desCol - col);
		return (rowDiff<=1 && colDiff<=1);
	}
	public String toString() {
		return colour == Colour.WHITE ? "WK" : "BK";
	}

}
