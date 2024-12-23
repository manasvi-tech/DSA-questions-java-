import java.util.Scanner;

// space optimization code
public class App {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // from 0 to n-1
        int prev1 = nums[0];
        int curr1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            int next = Math.max(nums[i] + prev1, curr1);
            prev1 = curr1;
            curr1 = next;
        }

        // from 1 to n
        int prev2 = nums[1];
        int curr2 = Math.max(nums[1], nums[2]);

        for (int i = 2; i < n - 1; i++) {
            int next = Math.max(nums[i + 1] + prev2, curr2);
            prev2 = curr2;
            curr2 = next;
        }

        return Math.max(curr1, curr2);
    }

    public static void main(String[] args) throws Exception {
        
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
