public class App {

    public static int height(BinaryTree.TreeNode root, int[] max){
        if(root ==null) return 0;

        int left = Math.max(0,height(root.left,max));
        int right = Math.max(0,height(root.right,max)); //to avoid the negatives
        max[0] = Math.max(left+right+root.val ,max[0]);

        return root.val+Math.max(left,right);
    }

    public static int maxPathSum(BinaryTree.TreeNode root){
        if(root.right == null && root.left == null) return root.val;

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        height(root,max);
        return max[0];
    }
    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        int[] arr = {1,2,3,4,5};

        BinaryTree.TreeNode root = tree.constructTree(arr);

        System.out.println(maxPathSum(root));
        
    }
}
