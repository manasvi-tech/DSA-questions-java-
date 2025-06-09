import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x;
    int y;
    int steps;
    Pair(int x, int y, int steps){
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}
class App {
    public static int bfs(char[][] maze, int[] entrance, boolean[][] visited, int n, int m){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(entrance[0], entrance[1], 0));


        int[] dRow = {0,-1,0,1};
        int[] dCol = {1,0,-1,0};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            visited[entrance[0]][entrance[1]] = true;

            int steps = curr.steps;
            int r = curr.x;
            int c = curr.y;

            if ((r == 0 || r == n - 1 || c == 0 || c == m - 1) && (r != entrance[0] || c != entrance[1]))
                return steps;

            for(int i=0;i<4;i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && maze[nRow][nCol] == '.'){
                    visited[nRow][nCol] = true;
                    q.add(new Pair(nRow,nCol,steps+1));
                }
            }
        }
        return -1;
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        boolean[][] visited = new boolean[n][m];

        return bfs(maze, entrance, visited, n, m);
        
    }

    public static void main(String[] args) {
        char[][] maze = {
            {'+','+','.','+'},
            {'.','.','.','+'},
            {'+','+','+','.'}
        };
        int[] entrance = {1,2};

        System.out.println(nearestExit(maze, entrance));

        
    }
}