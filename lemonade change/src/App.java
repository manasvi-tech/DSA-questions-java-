import java.util.Scanner;

public class App {
    public static boolean change(int[] bills){
        int five = 0;
        int ten = 0;
        for(int bill : bills){
            if(bill==5){
                five++;
            }
            else if(bill == 10){
                if(five>0){
                    five--;
                    ten++;
                } else{
                    return false;
                }
            }
            else{
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }
                else if(five>2){
                    five = five - 3;
                }
                else{
                    return false;
                }
            }      
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of customers");
        int n = sc.nextInt();

        int[] bills = new int[n];

        System.out.println("Please enter bill paid by each customer");
        for(int i=0;i<n;i++){
            bills[i] = sc.nextInt();
        }

        System.out.println(change(bills));
    }
}
