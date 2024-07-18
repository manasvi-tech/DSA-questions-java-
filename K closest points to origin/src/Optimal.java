import java.util.Arrays;
import java.util.Scanner;

public class Optimal {
    public static int[][] kClosest(int[][] points, int k) {
        // (a,b) is a lambda function that defines how two continuous elements are to be compared
        Arrays.sort(points,(a,b) -> getsquare(a) - getsquare(b));
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = points[i];
        }
        return ans;
    }
    public static int getsquare(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("this is optimal method");
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
