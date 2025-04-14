import java.util.Scanner;

public class App {

    public boolean bfs(char[][] board, String word, int ind, char c, int row, int col, int n, int m, boolean[][] visited){

        if(ind == word.length()) return true;

        if(row<0 || row>=n || col<0 || col>=m || visited[row][col]==true || board[row][col] != word.charAt(ind)){
            return false;
        }

        visited[row][col] = true;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(bfs(board, word, ind+1, c, nr, nc, n, m, visited)){
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c = word.charAt(0);
                if(board[i][j] == c){
                    if(bfs(board, word, 0, board[i][j], i, j, n, m, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int n = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int m = scanner.nextInt();

        char[][] board = new char[n][m];
        System.out.println("Enter the board characters row by row:");
        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < m; j++) {
            board[i][j] = row.charAt(j);
            }
        }

        System.out.println("Enter the word to search:");
        String word = scanner.next();

        App app = new App();
        boolean result = app.exist(board, word);

        if (result) {
            System.out.println("Word exists in the board.");
        } else {
            System.out.println("Word does not exist in the board.");
        }

        scanner.close();
    }
}
