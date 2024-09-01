import java.util.Scanner;

public class App {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length) return new int[0][0];
        int total = 0;
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = original[total];
                total++; 
            }
        }
        return matrix;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int num = sc.nextInt();
        int[] arr = new int[num];

        System.out.println("Enter elements of the array");
        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter num of rows in matrix");
        int m = sc.nextInt();
        
        System.out.println("Enter num of cols in matrix");
        int n = sc.nextInt();
        
        int[][] mat = construct2DArray(arr, m, n);

        System.out.println("Matrix is: ");
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
