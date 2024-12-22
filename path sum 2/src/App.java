import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public void bfs(TreeNode root, int target, int currSum, List<List<Integer>> ans, List<Integer> set){

        set.add(root.val);
        currSum = currSum + root.val;

        if(target == currSum && root.right == null && root.left == null){
            ans.add(new ArrayList<>(set));
        } else{
            bfs(root.left, target, currSum, ans, set);
            bfs(root.right, target, currSum, ans, set);
        }

        set.remove(set.size()-1);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();

        bfs(root, targetSum, 0, ans, new ArrayList<>());

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

    }
}
