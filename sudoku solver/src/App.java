public class App {
    public static void solveSudoku(char[][] board) {
        solve(board);
    }
    public static boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c ='1'; c<='9'; c++){
                        if(isValid(board, i, j, c) == true){
                            board[i][j]=c;
                            
                            //backtracking
                            if(solve(board)==true) return true;
                            
                            else 
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row,int col,char c){
        for(int i=0;i<9;i++){
            // checks column
            if(board[i][col]==c) return false;

            //checks row
            if(board[row][i]==c) return false;

            //checks for the box
             if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
            }
            return true;
        }
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        
        solveSudoku(board);
        
        // Print the solved Sudoku board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    
    }
}
