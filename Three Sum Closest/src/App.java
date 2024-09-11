import java.util.Arrays;
import java.util.Scanner;

public class App {
    
    public static int threeSumClosest(int[] arr, int target){

        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(arr);

        for(int i=0;i<n-2;i++){

            int left = i+1;
            int right = n-1;

            int sum = arr[i]+arr[left]+arr[right];
            
            if(sum==target){
                return sum;
            }

            else if(sum<0){
                left++;
            }

            else{
                right--;
            }

            int diff = Math.abs(sum-target);
                if(diff<minDiff){
                    result = sum;
                    diff = minDiff;
                }
            
        }

        return result;

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value of target");
        int target = sc.nextInt();

        System.out.println(threeSumClosest(arr, target));
    }
}
