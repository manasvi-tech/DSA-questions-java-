import java.util.Scanner;

public class App {
    int rows;
    int cols;
    int[] dirRow = {-1, 0, 1, 0};
    int[] dirCol = {0, 1, 0, -1};

    public void dfs(int i, int j, int[][] matrix) {
        // Check for out-of-bounds, already visited, or not a boundary
        if (i < 0 || i == rows || j < 0 || j == cols || matrix[i][j] == 1) {
            return;
        }

        matrix[i][j] = 1;

        for (int x = 0; x < 4; x++) {
            dfs(i + dirRow[x], j + dirCol[x], matrix);
        }
    }

    public int regionsBySlashes(String[] grid) {
        int size = grid.length;
        rows = size * 3;
        cols = size * 3;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int row = i * 3;
                int col = j * 3;

                if (grid[i].charAt(j) == '/') {
                    // Fill up 3 boxes for a forward slash
                    matrix[row][col + 2] = 1;
                    matrix[row + 1][col + 1] = 1;
                    matrix[row + 2][col] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[row][col] = 1;
                    matrix[row + 1][col + 1] = 1;
                    matrix[row + 2][col + 2] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dfs(i, j, matrix);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String[] grid = {"/\\","\\/"};
        
        App a = new App();

        System.out.println(a.regionsBySlashes(grid));
        
    }
}
