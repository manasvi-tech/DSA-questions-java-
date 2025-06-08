import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// import javax.swing.tree.TreeNode;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
        val = x; 
    }
}

public class App {
    public static int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode target = new TreeNode(-1);

        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr.val == start){
                target = curr;
            }

            if(curr.left!=null){
                map.put(curr.left, curr);
                q.add(curr.left);
            }

            if(curr.right!=null){
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        int totalTime = findTotalTime(map, target);

        return totalTime;
    }

    public static int findTotalTime(HashMap<TreeNode,TreeNode> map, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        Map<TreeNode,Integer> visited = new HashMap<>();
        visited.put(target,1);

        int time = 0;

        while(!q.isEmpty()){
            int n = q.size();
            int flag = 0;

            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();

                if(temp.left!=null && visited.get(temp.left) == null){
                    flag = 1;
                    visited.put(temp.left,1);
                    q.add(temp.left);
                }

                if(temp.right!=null && visited.get(temp.right) == null){
                    flag = 1;
                    visited.put(temp.right,1);
                    q.add(temp.right);
                }

                if(map.get(temp) != null && visited.get(map.get(temp)) == null ){
                    flag = 1;
                    visited.put(map.get(temp),1);
                    q.add(map.get(temp));
                }
            }

            if(flag == 1) time++;
        }
        return time;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // Example: Build a simple tree manually for demonstration
        // You can modify this to build from user input if needed

        // Sample tree:
        //      1
        //     / \
        //    2   3
        //   /
        //  4

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.print("Enter the start node value: ");
        int start = sc.nextInt();

        int result = amountOfTime(root, start);
        System.out.println("Minimum time to burn the tree: " + result);

        sc.close();
    }
}
