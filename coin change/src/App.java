import java.util.Arrays;
import java.util.Scanner;

public class App {
    public int helper(int i, int amount, int[] coins, int[][] dp){
        if(i==0){
            if(amount%coins[0]!=0){
                return dp[i][amount] = (int) Math.pow(10,9);
            }
            return dp[i][amount] = amount/coins[i];
        }

        if(dp[i][amount]!=-1) return dp[i][amount];

        int n_pick = helper(i-1,amount, coins, dp);
        int pick = Integer.MAX_VALUE;

        if(coins[i]<=amount){
            pick = 1+helper(i,amount-coins[i],coins,dp);
        }

        return Math.min(pick,n_pick);
    }

    public int coinChange(int[] coins, int amount){

        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        int ans = helper(n-1,amount,coins,dp);

        if(ans>= (int) Math.pow(10,9)){
            return -1;
        }

        return ans;

    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of coin types:");
        int n = scanner.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the coin values:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println("Enter the amount:");
        int amount = scanner.nextInt();
        scanner.close();

        App app = new App();
        int result = app.coinChange(coins, amount);
        System.out.println("Minimum coins required: " + result);
    }
}
