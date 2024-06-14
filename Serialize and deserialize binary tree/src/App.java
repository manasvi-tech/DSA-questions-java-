

public class App {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) throws Exception {
        Codec codec = new Codec();
        Codec.TreeNode root = new Codec.TreeNode(1);
        root.left = new Codec.TreeNode(2);
        root.right = new Codec.TreeNode(3);
        root.right.left = new Codec.TreeNode(4);
        root.right.right = new Codec.TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        Codec.TreeNode deserializedRoot = codec.deserialize(serialized);
        
    }
}
