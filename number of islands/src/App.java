import java.util.Scanner;

public class App {
    public static boolean helper(int row, int col, int n, int m, int[][] grid, int[][] visited){
        if( row>=n || col>=m || row<0 || col<0 || grid[row][col]==0 || visited[row][col] == 1){
            return true;
        }
        visited[row][col] = 1;
        
        if(helper(row+1,col,n,m,grid,visited) && helper(row,col+1,n,m,grid,visited) 
         && helper(row-1,col,n,m,grid,visited) && helper(row,col-1,n,m,grid,visited)){
            return true;
         }

        return false;
    }
    public static int numIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    if(helper(i,j,n,m,grid,visited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows in the grid");
        int n = sc.nextInt();
        System.out.println("Enter number of columns in the grid");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];


        System.out.println("Enter the elements");
        System.out.println("1 marks piece of land while 0 marks water");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(numIslands(grid));
    }
}
