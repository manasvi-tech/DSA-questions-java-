import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static boolean dfs(ListNode head, TreeNode root){
        if(head == null) return true;
        if(root == null) return false;

        if(root.val != head.val){
            return false;
        }

        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
    public static boolean isSubPath(ListNode head, TreeNode root) {
        // pre-order traversal
        if(root==null) return false;
        if(head == null) return true;
        if(root.val == head.val){
            if(dfs(head,root)){
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static TreeNode buildTree(Integer[] nodes){
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

    public static Integer[] parseInput(String input) {
        input = input.replaceAll("\\[|\\]", ""); // Remove square brackets
        String[] parts = input.split(",");      // Split by comma

        Integer[] nodes = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();      // Remove extra spaces
            nodes[i] = part.equals("null") ? null : Integer.parseInt(part);
        }
        return nodes;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of linked list");
        int n = sc.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            ListNode curr = new ListNode(val);
            temp.next = curr;
            temp = curr;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the tree nodes as an array (e.g., [1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3]): ");
        String input = scanner.nextLine();

        // Convert input to Integer array
        Integer[] nodes = parseInput(input);

        // Build the tree
        TreeNode root = buildTree(nodes);
        
        System.out.println(isSubPath(temp, root));
    }
}
