// Kadane's algorithm
import java.util.Scanner;
public class App {
    public static int maximumSum(int[] arr){
        // maximum sum
        int max = Integer.MIN_VALUE;

        // running sum
        int sum = 0;

        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            
            max = Math.max(max,sum);

            // if at any point sum goes lower than 0 disregard the whole thing.
            // we already have the max value stored in arr
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {

        int[] arr = {2,5,7,24,72,-10};
        
        System.out.println(maximumSum(arr));
    }
}
