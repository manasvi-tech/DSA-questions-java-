import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    static int N;
    static int[] ans, count;

    static List<List<Integer>> gr;


    // this will give us the answer of the uppermost node
    public static void dfs(int node, int par){
        for(int child : gr.get(node)){
            if(child!=par){
                dfs(child,node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    // this is for the children rather
    static void dfs2(int node, int par){
        for(int child : gr.get(node)){
            if(child!=par){
                ans[child] = ans[node] - count[child] + (N-count[child]);
                dfs2(child,node);
            }
        }
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        N=n;
        gr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            gr.get(u).add(v);
            gr.get(v).add(u);
        }

        // will store the answer    
        ans = new int[n];
        
        // in count we will store number of children of every node including itself
        count = new int[n];

        // every node for itself
        Arrays.fill(count,1);

        // this logic will work for the root and will prepare the ans and count array
        dfs(0,-1);

        // this logic will work for rest of all the nodes
        dfs2(0,-1);

        return ans;
    }
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n");
        int n = sc.nextInt();

        System.out.println("Enter the number of edges that are correlated to each other");
        int s = sc.nextInt();

        int[][] edges = new int[n][2];

        System.out.println("Enter the elements");
        for(int i=0;i<s;i++){
            for(int j=0;j<2;j++){
                edges[i][j] = sc.nextInt();
            }
        }

        int[] ans = sumOfDistancesInTree(n, edges);

        
    }   
}
