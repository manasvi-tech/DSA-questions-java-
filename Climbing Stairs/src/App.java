import java.util.Arrays;
import java.util.Scanner;

public class App {
    //tabulation
    public static int climbingStairs(int n){
        int[] dp = new int[n+1];

        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(i>1) dp[i] = dp[i-1]+dp[i-2];
            else dp[i] = dp[i-1];
        }
        return dp[n];
    }

    // memoization

    public int helper(int i,int[] dp){
        if(i==0){
            return dp[i]=1;
        }

        if(i<0){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        
        return dp[i] = helper(i-1,dp)+helper(i-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        helper(n,dp);
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(climbingStairs(n));
    }
}
