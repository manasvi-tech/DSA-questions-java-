import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public int minimumTotal(List<List<Integer>> triangle) {
        //memoization
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d = dp[i+1][j];
                int dg=dp[i+1][j+1];
                dp[i][j]=Math.min(d,dg)+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows in triangle: ");
        int n = sc.nextInt();
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            System.out.print("Enter " + (i + 1) + " numbers for row " + (i + 1) + ": ");
            for (int j = 0; j <= i; j++) {
                row.add(sc.nextInt());
            }
            triangle.add(row);
        }
        App app = new App();
        int result = app.minimumTotal(triangle);
        System.out.println("Minimum path sum: " + result);
        sc.close();
    }
}
