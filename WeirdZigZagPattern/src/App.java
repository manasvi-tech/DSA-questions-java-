/*
    *
      *
        *
      *      Here n = 9
    *
      * 
        *
      *
    *

*/
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l=0, j =0;
        for(l=0;l<=n;l++){
            for(j=0;j<=2;j++){
                if(l<3){
                    if(l==j){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if(j%4==0 && j==0){
                    System.out.print("*");
                }
                else if(l%2==0 && j==0){
                    System.out.print(" ");
                }
                else if ((l+j)%2==0){
                    System.out.print(" ");2
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }    
    }
}
