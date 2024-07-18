import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class App {
    class TreeNode {
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

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        App app = new App(); // Create an instance of App

        System.out.println("Please enter the number of elements in the complete binary tree");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Please enter the elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = app.constructTree(arr); // Use the instance to call constructTree
        System.out.print("Inorder of the tree is: ");
        app.inOrder(root); // Use the instance to call inOrder
    }
}
