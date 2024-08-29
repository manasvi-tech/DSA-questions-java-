// stones covered = total stones - total number of connected components

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // one dfs call will mark all the connected components
    public static void dfs(int ind, List<List<Integer>> list, boolean[] visited){
        visited[ind] = true;
        for(int neighbor : list.get(ind)){
            if(!visited[neighbor]){
                dfs(neighbor, list, visited);
            }
        }
    }
    public static int removeStones(int[][] stones) {
        int n = stones.length;
        // making adjency list we will store what index is connected to what index
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){

            int row = stones[i][0];
            int col = stones[i][1];

            for(int j = i+1;j<n;j++){
                if(stones[j][0] == row || stones[j][1]==col){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int connectedComponent=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,list,visited);
                connectedComponent++;
            }
        }

        return n-connectedComponent; // total stones - connected components
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total number of stones");
        int n = sc.nextInt();

        int[][] stones = new int[n][2];
        System.out.println("Enter the co-ordinates for each stone");
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                stones[i][j] = sc.nextInt();
            }
        }

        System.out.println(removeStones(stones));
    }
}
