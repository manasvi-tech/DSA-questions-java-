import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void helper(List<List<Integer>> ans, List<Integer> set, int[] nums, int n, List<Integer> consumed){
        if(set.size() == n ){
            ans.add(new ArrayList<>(set));  // Found a valid permutation
            return;
        }

        // Iterate through all numbers
        for(int i=0;i<n;i++){
            // Only use the number if it's still available in the map
            if(!consumed.contains(i)){
                set.add(nums[i]);
                  // add index to the consumed array
                  consumed.add(i);

                // Recursively build the permutation
                helper(ans, set, nums, n, consumed);

                // Backtrack
                set.remove(set.size() - 1);
                // remove the index from consumed list
                consumed.remove(consumed.size()-1);


                // skip duplicates
                while(i<n-1 && nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> set = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // we are gonna keep track of consumed elements by their index rather than their value
        List<Integer> consumed = new ArrayList<>();
        Arrays.sort(nums);

        // Populate the map with counts of each number

        // Start the helper function
        helper(ans, set, nums, nums.length, consumed);

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(permuteUnique(arr));
    }
}
