import java.util.HashSet;
import java.util.Scanner;

public class App {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int max = 0;
        for(int num : set){
            int count = 0;
            
            if(!set.contains(num-1)){ // makes sure this is the first element of the subsequence
                while(set.contains(num)){
                    count++;
                    num++;
                }
            }
            max = Math.max(count,max);
        }
        return max;
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        int result = longestConsecutive(nums);
        System.out.println("The length of the longest consecutive subsequence is: " + result);
    }
}
