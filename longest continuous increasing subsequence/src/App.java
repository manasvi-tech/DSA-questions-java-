import java.util.Scanner;

public class App {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int n = nums.length;
        int max = 1;
        int count = 1;
        int last = nums[0];

        for(int i=1;i<n;i++){
            if(last<nums[i]){
                count++;
            }
            else{
                count = 1;
            }

            last = nums[i];
            max = Math.max(count,max);
        }

        return max;
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
        int result = app.findLengthOfLCIS(nums);
        System.out.println("The length of the longest continuous increasing subsequence is: " + result);
    }
}