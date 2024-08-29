import java.util.Scanner;

public class App {
    public static int dfs(int i, int j, int n, int m, int visited[][], int[][] grid){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0 || visited[i][j]==1){
            return 0;
        }

        visited[i][j]=1;

        int left = dfs(i+1,j,n,m,visited,grid);
        int down = dfs(i,j+1,n,m,visited,grid);
        int right = dfs(i-1,j,n,m,visited,grid);
        int up = dfs(i,j-1,n,m,visited,grid);

        return 1 + left + right + up + down;
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int maxArea = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea,dfs(i,j,n,m,visited,grid));
                }              
            }
        }
        return maxArea;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows in the grid");
        int n = sc.nextInt();

        System.out.println("Enter the number of rows in the grid");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("1 is for island");
        System.out.println("0 is for water");

        System.out.println("Enter the elements of the grid");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxAreaOfIsland(grid));
    }
}
