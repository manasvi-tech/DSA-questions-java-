import java.util.Scanner;

public class App {
    public static int islandPerimeter(int[][] grid) {
        int p = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    // left
                    if (j == 0 || grid[i][j - 1] == 0)
                        p++;

                    // top
                    if (i == 0 || grid[i - 1][j] == 0)
                        p++;

                    // right
                    if (j == col - 1 || grid[i][j + 1] == 0)
                        p++;

                    // bottom
                    if (i == row - 1 || grid[i + 1][j] == 0)
                        p++;
                }            
            }
        }            

        return p;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows");
        int n = sc.nextInt();

        System.out.println("Enter number of columns");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("1 represents land");
        System.out.println("0 represents water");

        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }
    }
}
