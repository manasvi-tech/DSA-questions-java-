import java.util.ArrayList;
import java.util.List;

public class App {
    private static final int SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];
    private static List<char[][]> solutions = new ArrayList<>();
    public static void main(String[] args) throws Exception {
         // Initialize board with empty cells '-'
         initializeBoard();

         board[0][0] = 'X'; 
         board[1][1] = 'O';
 
         // Start the backtracking with the next player 'X' or 'O'
         backtrack('X');
 
         // Print all possible solutions (end states of the board)
         printSolutions();
        
    }
    // Initialize the board with empty spaces
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Backtracking function to explore all possible game states
    private static void backtrack(char currentPlayer) {
        // Check if the board has a winner
        if (checkWinner('X')) {
            saveBoardState();
            return;
        } else if (checkWinner('O')) {
            saveBoardState();
            return;
        } else if (isBoardFull()) {
            saveBoardState(); // No winner, game ends in draw
            return;
        }

        private static void saveBoardState() {
            char[][] copy = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    copy[i][j] = board[i][j];
                }
            }
            solutions.add(copy);
        }
}
