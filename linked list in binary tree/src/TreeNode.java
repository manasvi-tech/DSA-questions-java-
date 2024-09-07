import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode buildTree(Integer[] nodes){
        if(nodes[0] == null || nodes == null) return null;

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int i = 1;
        while(i<nodes.length){
            TreeNode curr = q.poll();

            // left child
            if(i<nodes.length && nodes[i]!= null){
                curr.left = new TreeNode(nodes[i]);
                q.add(curr.left);
            }
            i++;

            // right child
            if(i<nodes.length && nodes[i]!= null){
                curr.right = new TreeNode(nodes[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
