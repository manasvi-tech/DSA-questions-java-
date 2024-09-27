import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    public static List<List<Integer>> verticalTraversal(TreeNode root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> list = new ArrayList<>();

        // level order traversing

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, root));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.val);

            if(node.left!=null){
                q.offer(new Tuple(x-1,y+1,node.left));
            }

            if(node.right!=null){
                q.offer(new Tuple(x+1,y+1,node.right));
            }
        
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> values : ys.values()) {
                while (!values.isEmpty()) { // Poll all values from the priority queue
                    list.get(list.size() - 1).add(values.poll());
                }
            }
        }

        return list;
    }
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];


        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            String input = sc.next(); // Read input as a string

            if (input.equals("null")) {
                arr[i] = null; // Assign null if the input is "null"
            } else {
                arr[i] = Integer.parseInt(input); // Parse and store integer value
            }
        }  
        
        TreeNode root = TreeNode.levelOrder(arr);

        System.out.println(verticalTraversal(root));

    }
}
