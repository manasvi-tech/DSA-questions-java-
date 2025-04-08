import java.util.Scanner;

public class App {

    public int helper(int i, int j, int[] nums, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        dp[i][j]=0;
        for(int ind=i;ind<=j;ind++){
            int coins = nums[i-1] * nums[ind] * nums[j+1];
                        
            coins+= helper(i,ind-1,nums,dp) + helper(ind+1,j,nums,dp);
            
            dp[i][j] = Math.max(dp[i][j], coins);
        }
        return dp[i][j];
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;
        for(int i=0;i<n;i++){
            newNums[i+1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(1,n,newNums,dp);
    
}

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of balloons:");
        int n = scanner.nextInt();
        int[] balloons = new int[n];
        System.out.println("Enter the values of the balloons:");
        for (int i = 0; i < n; i++) {
            balloons[i] = scanner.nextInt();
        }
        scanner.close();
        App app = new App();
        int result = app.maxCoins(balloons);
        System.out.println("Maximum coins that can be burst: " + result);
    }
}
