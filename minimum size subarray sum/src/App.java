import java.util.Scanner;

public class App {

    public int minSubArrayLen(int target, int[] nums) {

        int j = 0;
        int i = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        while(j<nums.length){
            sum += nums[j];

            while(sum>= target){
                minLength = Math.min(minLength,j-i+1);
                sum -= nums[i];
                i++;

            }
            j++;
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the target sum:");
        int target = scanner.nextInt();

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        App app = new App();
        int result = app.minSubArrayLen(target, nums);

        System.out.println("The minimum length of a subarray with sum >= " + target + " is: " + result);

        scanner.close();
    }
}
