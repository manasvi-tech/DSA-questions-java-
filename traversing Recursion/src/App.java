import java.util.Scanner;

public class App {
    public static int ways(int[][] matrix, int i, int j, int m, int n){
        if(i>=m || i<0 || j>=n || j<0){
            return 0;
        }
        if(i==n-1 && j==m-1){
            return 1;
        }
        int left = ways(matrix,i+1,j,m,n);
        int down = ways(matrix,i,j+1,m,n);
        return left+down;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];

        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println(ways(matrix,0,0,3,3));
    }
}
