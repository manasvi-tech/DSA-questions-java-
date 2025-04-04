import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public String treeToString(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = treeToString(root.left);
        String right = treeToString(root.right);
        return root.val + "," + left + "," + right;
    }

    // more like binary search where we divide into two parts based on the root we have in the current situation
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> ans = new ArrayList<>();

        if(start>end){
            ans.add(null);
            return ans;
        }

        for(int i= start; i<=end; i++){

            List<TreeNode> left = helper(start,i-1);
            List<TreeNode> right = helper(i+1,end);

            for(TreeNode l : left ){
                for(TreeNode r : right){
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;

                    ans.add(current_tree);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n>0){
            return helper(1,n); // count all subtrees one by one
        }
        else{
            return new ArrayList<>();
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        App app = new App();
        List<TreeNode> result = app.generateTrees(n);

        System.out.println("Generated Trees:");
        for (TreeNode root : result) {
            System.out.println(app.treeToString(root));
        }
        scanner.close();
    }
}
