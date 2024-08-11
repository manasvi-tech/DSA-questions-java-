import java.util.Arrays;
import java.util.Scanner;

public class App {

    // memoization
    public int helper(int i, int n, int[] dp, int[] arr){
        if(i==-1){
            return 0;
        }

        if(i<-1){
            return Integer.MAX_VALUE;
        }
        if(dp[i]!=-1) return dp[i];

        return dp[i]=arr[i]+Math.min(helper(i-1,n,dp, arr), helper(i-2,n,dp, arr));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return Math.min(helper(n-1, n, dp,cost), helper(n-2,n,dp,cost));
    }
    

    // tabulation
    public static int minCost(int[] cost){
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i=2;i<n;i++){
            dp[i] = cost[i]+ Math.min(dp[i-2],dp[i-1]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the number of steps");
        int n = sc.nextInt();

        int[] cost = new int[n];

        System.out.println("Please enter cost of stepping on each stair");
        for(int i=0;i<n;i++){
            cost[i] = sc.nextInt();
        }
        System.out.println( minCost(cost) );
    }
}
