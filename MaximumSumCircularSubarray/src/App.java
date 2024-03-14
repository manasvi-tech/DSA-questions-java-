// Kadane's extension

// Either the maximum subarray will be total - minSum linear subarray or regular linear max subarray
public class App {
    public static int maxSumCircular(int[] arr){
        int totSum = 0, maxSum = 0, minSum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : arr){
            // total Sum of array
            totSum += num;

            // running sum for minimum subarray
            minSum +=num;
            min = Math.min(min,minSum);
            if(minSum>0){
                minSum  = 0;
            }

            // running sum for maximum case
            maxSum +=num;
            max = Math.max(max,maxSum);
            if(maxSum<0){
                maxSum = 0;
            }
            
        }
        // edge case because if they are equal it would return 0 and 0 might not even be the part of the array
        if(totSum == minSum) return max;

        // normal case
        return Math.max(totSum - min, max);
    }
    public static void main(String[] args) throws Exception {
        int[] arr = {-3,-2,-2};
        System.out.println(maxSumCircular(arr));
        
    }
}
