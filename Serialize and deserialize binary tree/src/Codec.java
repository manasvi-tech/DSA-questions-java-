import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    public static class TreeNode {
        int val;
        App.TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Queue<Codec.TreeNode> q = new LinkedList<>();

    public String serialize(Codec.TreeNode root) {
        if (root == null) {
            return "";
        }

        
        StringBuilder res = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("null,");
                continue;
            }
            res.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }
        q.clear();
        // System.out.println(res);
        return res.toString();
    }

    public TreeNode deserialize(String data) {

        if (data == "") {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        // for(int i=0;i<values.length;i++){
        //     System.out.print(values[i]+" ");
        // }
        int i=1;
        
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (!values[i].equals("null")) {
                current.left = new Codec.TreeNode(Integer.parseInt(values[i]));
                q.add(current.left);
            }
            i++;
            if (i >= values.length) break;
            if (!values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(current.right);
            }
            i++;
        }
        return root;
    }
}
