import java.util.ArrayList;
import java.util.List;

// import javax.swing.tree.TreeNode;

public class App {
    public void dfs(TreeNode root, List<Integer> ans, int level){
        if(root == null){
            return;
        }

        if(ans.size()<level){
            ans.add(root.val);
        }

        dfs(root.right,ans,level+1);
        dfs(root.left,ans,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans,1);
        return ans;
    }
    public static void main(String[] args) throws Exception {
        // Example usage of the rightSideView function
        App app = new App();

        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Getting the right side view of the binary tree
        List<Integer> result = app.rightSideView(root);

        // Printing the result
        System.out.println("Right side view of the binary tree: " + result);
    }
}
