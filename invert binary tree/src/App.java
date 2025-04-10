public class App {

        public TreeNode swap(TreeNode root){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
    
            return root;
        } 
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }
    
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
    
            root = swap(root);
    
            return root;
        }
    
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        App app = new App();
        TreeNode invertedRoot = app.invertTree(root);

        System.out.println("Inverted tree root: " + invertedRoot.val);
    }
}
