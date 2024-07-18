import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class App {

    public static int[][] kClosest(int[][] points, int k){

        // Comparator.comparing makes sure that the priority is 
        // compared using the first element of each array.

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a->a[0]));

        for(int[] point:points){
            int d = point[0]*point[0] + point[1]*point[1];
            minHeap.add(new int[] {d,point[0],point[1]});
        }

        int[][] ans = new int[k][2];

        for(int i=0;i<k;i++){
            int[] arr = minHeap.poll();
            ans[i] = new int[]{arr[1],arr[2]};
        }

        return ans;

    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of points");
        int n = sc.nextInt();

        int[][] points = new int[n][2];
        
        System.out.println("Enter the x and y co-ordinates of "+n+" elements");
        for(int i=0;i<n;i++){
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        System.out.println("Enter the value of k");
        int k = sc.nextInt();

        int[][] ans = kClosest(points,k);

        System.out.println("k closest points are");
        for(int i=0;i<k;i++){
            for(int j=0;j<2;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
