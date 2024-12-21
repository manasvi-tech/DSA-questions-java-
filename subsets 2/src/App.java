import java.util.*;


// naive approach.. set bnado array ka

public class App {
    private void helper(int i, int n, int[] nums, List<List<Integer>> ans, List<Integer> set){

        if(i==n){
            ans.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[i]);
        helper(i+1,n,nums,ans,set);

        set.remove(set.size()-1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }

        helper(i+1,n,nums,ans,set);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();        

        helper(0,nums.length,nums, ans, new ArrayList<>());

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
        scanner.close();

        App app = new App();
        List<List<Integer>> subsets = app.subsetsWithDup(nums);
        System.out.println("Subsets with duplicates:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
