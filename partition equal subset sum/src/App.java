import java.util.Scanner;

public class App {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2!=0) return false;

        boolean[][] dp = new boolean[n][sum/2+1];
        sum=sum/2;
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if (nums[0] <= sum) {
                dp[0][nums[0]] = true;
            }

        for(int i=1;i<n;i++){
            for(int j=1;j<sum+1;j++){
                boolean not_taken = dp[i-1][sum];
                boolean taken=false;
                if(nums[i]<=sum){
                    taken=dp[i-1][sum-nums[i]];
                }
                dp[i][sum]= taken || not_taken;
            }
        }
        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        App app = new App();
        boolean result = app.canPartition(nums);
        System.out.println("Can partition: " + result);
    }
}
