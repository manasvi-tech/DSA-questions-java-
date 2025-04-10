public class App {
    public int dfs(TreeNode root, int[] ans){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left,ans);
        int right = dfs(root.right,ans);
        ans[0] = Math.max(ans[0], left+right);

        return 1+Math.max(dfs(root.left,ans),dfs(root.right,ans));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        dfs(root,ans);
        return ans[0];
    }
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        App app = new App();
        System.out.println("Diameter of the binary tree: " + app.diameterOfBinaryTree(root));
    }
}
