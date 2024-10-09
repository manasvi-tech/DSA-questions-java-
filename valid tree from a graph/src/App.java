import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App {
    private static HashMap<Integer, List<Integer>> map = new HashMap<>();

    private static boolean dfs( int node, int prev, Set<Integer> visited){
        if(visited.contains(node)) return false;
        visited.add(node);

        for(int neighbor : map.get(node)){
            if(neighbor == prev) continue;
            if(!dfs(neighbor,node,visited)) return false;
        }

        return true;
    }
    public static boolean validTree(int n, int[][] edges) {
        if(n==1 && edges.length == 0) return true;
        if(edges.length==0) return false;

        map.clear();

        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];

            map.putIfAbsent(node1, new ArrayList<>());
            map.putIfAbsent(node2, new ArrayList<>());

            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }

        Set<Integer> visited = new HashSet<>();

        if(!dfs(edges[0][0],-1,visited)) return false;

        return visited.size() == n;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter the number of edges: ");
        int edges = sc.nextInt();

        int[][] arr = new int[edges][2];
        System.out.println("Enter the edges: ");
        for(int i=0;i<edges;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        System.out.println(validTree(n, arr));
    }
}
