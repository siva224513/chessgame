package chessgame.pieces;

import chessgame.Board;
import chessgame.Colour;

public abstract class Piece {
	protected final Colour colour;
	protected int row;
	protected int col;

	public Piece(Colour colour, int row, int col) {
		this.colour = colour;
		this.row = row;
		this.col = col;
	}

	public Colour getColour() {
		return colour;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public abstract boolean canMove(Board board, int desRow, int desCol);
	
	@Override
	public abstract String toString();
		

}
