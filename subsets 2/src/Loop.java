import java.util.*;


// other way to solve using iteration
public class Loop {
    public void helper(int ind, int n, int[] nums, List<List<Integer>> ans, List<Integer> set){
        ans.add(new ArrayList<>(set));

        for(int i=ind; i<n; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;

            set.add(nums[i]);
            helper(i+1,n,nums,ans,set);

            set.remove(set.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        helper(0,n,nums,ans,new ArrayList<>());

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

        Loop loop = new Loop();
        List<List<Integer>> subsets = loop.subsetsWithDup(nums);
        System.out.println("The subsets are:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}