# Chess Game

A console-based Chess game implemented in Java, featuring all standard rules including check, checkmate, and stalemate detection. This game supports two players with basic input validation and move verification.

## Features

- Full implementation of Chess rules.
- Detection of check, checkmate, and stalemate conditions.
- Basic input validation to ensure valid moves.
- Display of the chess board after each move.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/chessgame.git
    ```
2. Navigate to the project directory:
    ```bash
    cd chessgame
    ```
3. Compile the Java files:
    ```bash
    javac -d bin src/chessgame/*.java src/chessgame/pieces/*.java
    ```
4. Run the game:
    ```bash
    java -cp bin chessgame.GameController
    ```

## How to Play

1. Start the game and enter the names of the two players.
2. Players will be prompted to enter their moves in turn. A move consists of the source row and column, and the destination row and column.
3. The game will validate each move, check for check, checkmate, or stalemate conditions, and update the board accordingly.
4. The game ends when one player checkmates the other or a stalemate is reached.

## Game Controls

- Input moves by specifying the source and destination coordinates.
- Coordinates are in the range of 0-7, corresponding to the rows and columns of the chess board.

## Example Gameplay

```plaintext
Alice (WHITE)'s turn
Enter source row: 6
Enter source column: 4
Enter destination row: 4
Enter destination column: 4

    0  1  2  3  4  5  6  7 
0  BR BN BB BQ BK BB BN BR 
1  BP BP BP BP -- BP BP BP 
2  -- -- -- -- -- -- -- -- 
3  -- -- -- -- -- -- -- -- 
4  -- -- -- -- WP -- -- -- 
5  -- -- -- -- -- -- -- -- 
6  WP WP WP WP -- WP WP WP 
7  WR WN WB WQ WK WB WN WR 

Bob (BLACK)'s turn
Enter source row: 1
Enter source column: 4
Enter destination row: 3
Enter destination column: 4

    0  1  2  3  4  5  6  7 
0  BR BN BB BQ BK BB BN BR 
1  BP BP BP BP -- BP BP BP 
2  -- -- -- -- -- -- -- -- 
3  -- -- -- -- BP -- -- -- 
4  -- -- -- -- WP -- -- -- 
5  -- -- -- -- -- -- -- -- 
6  WP WP WP WP -- WP WP WP 
7  WR WN WB WQ WK WB WN WR 

Alice (WHITE)'s turn
Enter source row: ...
