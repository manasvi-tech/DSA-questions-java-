import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static TreeNode levelOrder(Integer[] arr){

        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null; // Handle edge case of empty or null input
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int ind = 1;
        while (!q.isEmpty() && ind < arr.length) {
            TreeNode curr = q.poll();

            // Process left child
            if (ind < arr.length && arr[ind] != null) {
                curr.left = new TreeNode(arr[ind]);
                q.add(curr.left);
            }
            ind++;

            // Process right child
            if (ind < arr.length && arr[ind] != null) {
                curr.right = new TreeNode(arr[ind]);
                q.add(curr.right);
            }
            ind++;
        }
        
        return root;

    }
    
}
