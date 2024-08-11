import java.util.Scanner;

public class App {

    private static void dfs(int i, int row, int j, int col, boolean[][] visited, int[][] grid){
        if(i<0 || i==row || j<0 || j==col || visited[i][j]==true || grid[i][j]==0){
            return;
        }
        visited[i][j]=true;

        int[] newRow = {-1,0,1,0};
        int[] newCol = {0,1,0,-1};

        for(int x=0;x<4;x++){
            dfs(i+newRow[x],row,j+newCol[x],col,visited,grid);
        }
    }
    private static int countIslands(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        int numOfIsland = 0;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    dfs(i,row,j,col,visited,grid);
                    numOfIsland++;
                }
            }
        }

        return numOfIsland;
    }
    private static int minDays(int[][] grid){
        if(countIslands(grid)!=1) return 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;

                    if(countIslands(grid)!=1) return 1;
                    
                    grid[i][j]=1;
                }
            }
        }

        return 2;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the dimensions of the grid");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]= sc.nextInt();
            }
        }

        System.out.println(minDays(grid));

    }
}
