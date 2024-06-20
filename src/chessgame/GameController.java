package chessgame;

import java.util.Scanner;
import chessgame.pieces.Piece;

public class GameController {
	private Board board;
	private Player players[];
	private int currentPlayer;
	private Scanner scanner = new Scanner(System.in);

	public GameController(String player1, String player2, boolean player1IsWhite) {
		board = new Board();
		players = new Player[2];
		if (player1IsWhite) {
			players[0] = new Player(player1, Colour.WHITE);
			players[1] = new Player(player2, Colour.BLACK);
		} else {
			players[0] = new Player(player1, Colour.BLACK);
			players[1] = new Player(player2, Colour.WHITE);
		}
		currentPlayer = 0;
	}

	public void startGame() {
		while (!isGameOver()) {
			Player player = players[currentPlayer];

			// Notify if the player's king is in check before making a move
			if (board.isKingInCheck(player.getColour())) {
				System.out.println("Warning: " + player.getName() + ", your king is in check!");
			}

			System.out.println(player.getName() + " (" + player.getColour() + ")" + "'s turn");
			Move move = getPlayerMove(player);

			try {
				player.canMove(board, move);
				if (board.isCheckmate(players[currentPlayer].getColour())) {
					System.out.println(player.getName() + " (" + player.getColour() + ") wins by checkmate!");
					displayGameResult();
					return; // End the game
				}
			} catch (InvalidMoveException e) {
				System.out.println(e.getMessage());
				System.out.println("Try again...!");
				continue;
			}

			currentPlayer = (currentPlayer + 1) % 2;
			board.displayBoard();
		}

		// Display the result of the game
		displayGameResult();
	}

	private Move getPlayerMove(Player player) {
		System.out.print("Enter source row: ");
		int sourceRow = scanner.nextInt();
		System.out.print("Enter source column: ");
		int sourceCol = scanner.nextInt();
		System.out.print("Enter destination row: ");
		int destRow = scanner.nextInt();
		System.out.print("Enter destination column: ");
		int destCol = scanner.nextInt();

		Piece piece = board.getPiece(sourceRow, sourceCol);
		try {
			if (piece == null || piece.getColour() != player.getColour()) {
				throw new IllegalArgumentException("Invalid piece selection");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new Move(piece, destRow, destCol);
	}

	private boolean isGameOver() {
		return board.isCheckmate(players[0].getColour()) || board.isCheckmate(players[1].getColour())
				|| board.isStalemate(players[0].getColour()) || board.isStalemate(players[1].getColour());
	}

	private void displayGameResult() {
		if (isGameOver()) {
			if (board.isCheckmate(players[0].getColour())) {
				System.out.println(players[0].getName() + " (" + players[0].getColour() + ") is checkmated.");
				System.out.println(players[1].getName() + " (" + players[1].getColour() + ") wins!");
			} else if (board.isCheckmate(players[1].getColour())) {
				System.out.println(players[1].getName() + " (" + players[1].getColour() + ") is checkmated.");
				System.out.println(players[0].getName() + " (" + players[0].getColour() + ") wins!");
			} else if (board.isStalemate(players[0].getColour()) || board.isStalemate(players[1].getColour())) {
				System.out.println("The game is a stalemate.");
			}
		}
	}
}
