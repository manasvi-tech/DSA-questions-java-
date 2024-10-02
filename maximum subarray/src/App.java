import java.util.Scanner;

public class App {

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(sum<0){
                sum = 0;
            }
            sum+=nums[i];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the element of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(maxSubArray(arr));
    }
}
