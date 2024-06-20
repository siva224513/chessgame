package chessgame.pieces;

import chessgame.Board;
import chessgame.Colour;

public class Rook extends Piece {

	public Rook(Colour colour, int row, int col) {
		super(colour, row, col);

	}

	@Override
	public boolean canMove(Board board, int desRow, int desCol) {

		return (row == desRow) || (col == desCol);
	}

	public String toString() {
		return colour == Colour.WHITE ? "WR" : "BR";
	}

}
