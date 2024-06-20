package chessgame.pieces;

import chessgame.Board;
import chessgame.Colour;

public class Queen extends Piece {

	public Queen(Colour colour, int row, int col) {
		super(colour, row, col);
	}

	@Override
	public boolean canMove(Board board, int desRow, int desCol) {
		int rowDiff = Math.abs(desRow - row);
		int colDiff = Math.abs(desCol - col);
		
		return (rowDiff==colDiff)||(row==desRow)||(col==desCol);
		
	}
	public String toString() {
		return colour == Colour.WHITE ? "WQ" : "BQ";
	}

}
