import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MedianFinder mf = new MedianFinder();
        System.out.println("1. Add Number");
        System.out.println("2. Find Median");
        System.out.println("3. Exit");

        boolean flag = true;

        while(flag){
            System.out.println("Enter your choice");
            int n = sc.nextInt();

            switch(n){
                case 1 :
                    System.out.println("Please enter the number you want to add");
                    int num = sc.nextInt();
                    mf.addNum(num);
                    break;
                
                case 2 : 
                    System.out.println(mf.findMedian());
                    break;

                case 3 : 
                    flag = false;

            }
        }

    }
}
