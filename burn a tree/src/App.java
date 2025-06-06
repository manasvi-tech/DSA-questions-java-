// Java Program to find the minimum time 
// required to burn the complete binary tree
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class App {
    
    // Function to find the depth 
    // from the root.
    static int findDepth(Node root) {
        if (root == null) return 0;
    
        int left = findDepth(root.left);
        int right = findDepth(root.right);
    
        return Math.max(left, right) + 1;
    }
    
    // This function returns the distance of current 
    // node from the target node. Returns -1 if 
    // target node is not found.
    static int findTarNode(Node root, int target, int[] ans) {
        
        // base case
        if (root == null) return -1;
    
        // if current node is the target, find the
        // depth of root, compare it with ans and
        // return 1.
        if (root.data == target) {
            int depth = findDepth(root) - 1;
            ans[0] = Math.max(ans[0], depth);
            return 1;
        }
    
        int left = findTarNode(root.left, target, ans);
    
        // If target node is found in the left subtree
        // ,then compare the depth of right subtree and dis
        // of target node with ans.
        if (left != -1) {
            int depth = findDepth(root.right);
            ans[0] = Math.max(ans[0], left + depth);
            return left + 1;
        }
    
        // If target node is found in the right subtree
        // ,then compare the depth of left subtree and dis
        // of target node with ans.  
        int right = findTarNode(root.right, target, ans);
        if (right != -1) {
            int depth = findDepth(root.left);
            ans[0] = Math.max(ans[0], right + depth);
            return right + 1;
        }
    
        // if target node is not found,
        // return -1.
        return -1;
    }
    
    static int minTime(Node root, int target) {
        
        // Answer variable is represented
        // as array to pass it by reference
        int[] ans = {0};
        findTarNode(root, target, ans);
        return ans[0];
    }
    
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        int target = 2;
        System.out.println(minTime(root, target));
    }
}