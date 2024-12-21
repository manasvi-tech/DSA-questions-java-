import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



// two pointer could have been used if only there was supposed to be a pair

public class App {
    public void helper(int i, int n, int target, List<List<Integer>> ans, List<Integer> set, int[] nums){
        // the target has been met
        if(target==0){
            ans.add(new ArrayList<>(set));
            return;
        }

        if(i==n || target<0){
            return;
        }

        set.add(nums[i]);
        helper(i,n,target-nums[i],ans,set,nums);


        set.remove(set.size()-1);
        helper(i+1,n,target,ans,set,nums);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        helper(0,n,target,ans, new ArrayList<>(),nums);

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the target sum:");
        int target = scanner.nextInt();
        
        App app = new App();
        List<List<Integer>> result = app.combinationSum(nums, target);
        
        System.out.println("Combinations are:");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
        
        scanner.close();
    }
}
