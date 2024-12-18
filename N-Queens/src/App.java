import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n in n X n");
        int n = sc.nextInt();

        char[][] matrix = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(char[] arr : matrix){
            Arrays.fill(arr,'.');
        }

        NQueen(n,matrix,0,ans);
        for(List<String> comb : ans){ //Displaying results
            for(String str:comb){
                System.out.println(str+" ");
            }   
            System.out.println();
            System.out.println();
        }
    }
    public static void NQueen(int n, char[][] matrix, int row, List<List<String>> ans){
        if(row==n){  // reached the end meaning... The matrix is valid
            ans.add(construct(matrix,n));
            return;
        }
        for(int i=0;i<n;i++){
            if(matrix[row][i]=='.'){
                if(isValid(row,i,matrix)){
                    matrix[row][i]='Q';
                    NQueen(n,matrix,row+1, ans);
                    matrix[row][i]='.';
                }
            }
        }
    }
    public static boolean isValid(int row, int col, char[][] matrix){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]=='Q') return false;  //checking for the column
            if(matrix[row][i]=='Q') return false;  //checking for the row
        }
        int duprow=row;
        int dupcol=col;
        while(row>=0&& col>=0){  //checking left diagonal
            if(matrix[row][col]=='Q') return false;
            row--;
            col--;
        }
        row=duprow;
        col=dupcol;
        while(row>=0 && col<matrix.length){ //checking right diagonal
            if(matrix[row][col]=='Q') return false;
            row--;
            col++;
        }
        return true;
    }
    
    
    public static List<String> construct(char[][] matrix, int n){ //converting 2D character array into a List<String>
        List<String> row = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s = new String(matrix[i]);
            row.add(s);
        }
        return row;
    }
    
}
