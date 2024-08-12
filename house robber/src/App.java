import java.util.Arrays;
import java.util.Scanner;

public class App {

    //memoization
    private int helper(int[] nums, int[] dp, int i){
        if(i==0){
            return nums[i];
        }
        if(i<0) return 0;

        if(dp[i]!=-1) return dp[i];

        int take = nums[i]+helper(nums,dp,i-2);
        int n_take = helper(nums,dp,i-1);

        return dp[i]=Math.max(take,n_take);
    }
    private int houseRob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        return helper(nums,dp,nums.length-1);
    }

    //tabulation
    public static  int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        if(nums.length!=1){
            dp[1] = Math.max(nums[0],nums[1]);
        }

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[n-1];
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of houses");
        int n = sc.nextInt();

        int[] cost = new int[n];
        System.out.println("Please enter the cost in each house");
        for(int i=0;i<n;i++){
            cost[i] = sc.nextInt();
        }

        System.out.println(rob(cost));

        
    }
}
