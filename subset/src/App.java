import java.util.ArrayList;
import java.util.List;


public class App {
    void helper(int[] nums, int i, int n, List<List<Integer>> ans, List<Integer> set){

        // the whole array has been iterated
        if(i==n){ 
            ans.add(new ArrayList<>(set));
            return;
        }

        // picking the current element
        set.add(nums[i]);
        helper(nums,i+1,n,ans,set);

        //skipping the current element
        set.remove(set.size()-1);
        helper(nums,i+1,n,ans,set);

    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // helper function
        helper(nums,0,n,ans, new ArrayList<>() );

        return ans;
    }

    public static void main(String[] args) {
        App app = new App();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = app.subsets(nums);
        System.out.println(result);
    }
}
