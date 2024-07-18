import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }


    public TreeNode constructTree(int[] values) {
        if (values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int index = 1;

        while (index < values.length) {
            TreeNode curr = q.poll();

            // inserting the left child
            if (index < values.length) {
                curr.left = new TreeNode(values[index]);
                q.add(curr.left);
                index++;
            }

            // inserting the right child
            if (index < values.length) {
                curr.right = new TreeNode(values[index]);
                q.add(curr.right);
                index++;
            }
        }
        return root;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

}
