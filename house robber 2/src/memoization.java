import java.util.Arrays;
import java.util.Scanner;

public class memoization  {

    public int helper(int start, int i, int[] nums, int[] dp){

        if(i == start){
            return nums[i];
        }

        if(dp[i] != -1) return dp[i];
        
        int take = nums[i] + helper(start, i-2, nums, dp);
        int n_take = helper(start, i-1, nums, dp);

        return Math.max(take,n_take);

    }

    public int rob(int[] nums){

        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return Math.max(helper(0, n-2, nums, dp), helper(1, n-1, nums, dp));
    }

    public static void main (String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of houses:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the amount of money in each house:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        App app = new App();
        int maxRobbedAmount = app.rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxRobbedAmount);
    }
}
