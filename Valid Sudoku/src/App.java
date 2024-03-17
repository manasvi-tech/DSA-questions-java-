public class App {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // checks column
            if (board[i][col] == c && i != row) return false;

            // checks row
            if (board[row][i] == c && i != col) return false;

            // checks for the box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c && 
            (3 * (row / 3) + i / 3 != row || 3 * (col / 3) + i % 3 != col)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };  
        System.out.println(isValidSudoku(board));      
    }
}
