package chessgame;

import java.util.Scanner;

import chessgame.GameController;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to our chess game");

		System.out.println("Enter player 1 name:");
		String player1 = scanner.nextLine();

		System.out.println("Enter player 2 name:");
		String player2 = scanner.nextLine();

		System.out.println(player1 + ", do you want to play as white? (yes/no):");
		String colorChoice = scanner.nextLine();

		boolean player1IsWhite = colorChoice.equalsIgnoreCase("yes");

		GameController game = new GameController(player1, player2, player1IsWhite);
		game.startGame();

	}
}
