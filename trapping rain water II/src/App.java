import java.util.PriorityQueue;
import java.util.Scanner;

public class App {
   
    
        public int trapRainWater(int[][] height) {
            int n = height.length;
            int m = height[0].length;
    
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
            boolean[][] vis = new boolean[n][m];
    
            // add boundary cells (adding first and last row)
            for(int i=0;i<n;i++){
                vis[i][0] = true;
                pq.offer(new int[]{height[i][0],i,0});
    
    
                vis[i][m-1] = true;
                pq.offer(new int[]{height[i][m-1],i,m-1});
            }
    
            // first and last row
    
            for(int i=0;i<m;i++){
                vis[0][i] = true;
                pq.offer(new int[]{height[0][i],0,i});
    
                vis[n-1][i] = true;
                pq.offer(new int[]{height[n-1][i],n-1,i});
            }
    
            int ans = 0;
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, -1, 0, 1};
    
            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int h = curr[0];
                int r = curr[1];
                int c = curr[2];
    
                for(int i=0;i<4;i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
    
                    if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc]){
                        ans += Math.max(0,h - height[nr][nc]);
                        pq.offer(new int[]{Math.max(h, height[nr][nc]), nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
            return ans;
        }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimensions of the height map (n m):");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] height = new int[n][m];
        System.out.println("Enter the height map values row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            height[i][j] = scanner.nextInt();
            }
        }

        App app = new App();
        int result = app.trapRainWater(height);
        System.out.println("The amount of trapped rainwater is: " + result);
        scanner.close();
    }
}
