// memoization

import java.util.Scanner;
import java.util.Arrays;

class App {
    public int helper(int n, int[] dp){
        if(n<=1) return 1;

        int ans = 0;

        if(dp[n]!=-1) return dp[n];
        // is the current root node right now
        for(int i=1;i<=n;i++){
            ans += helper(n-i, dp) * helper(i-1, dp); 
        }

        return dp[n] = ans;
    }
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);

    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        App app = new App();
        int result = app.numTrees(n);
        System.out.println("Number of unique BSTs: " + result);
        scanner.close();
    }
}