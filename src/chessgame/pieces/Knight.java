package chessgame.pieces;

import chessgame.Board;
import chessgame.Colour;

public class Knight extends Piece {

	public Knight(Colour colour, int row, int col) {
		super(colour, row, col);
	}

	@Override
	public boolean canMove(Board board, int desRow, int desCol) {
		int rowDiff = Math.abs(desRow - row);
		int colDiff = Math.abs(desCol - col);
		return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);

	}
	public String toString() {
		return colour == Colour.WHITE ? "WN" : "BN";
	}

}
