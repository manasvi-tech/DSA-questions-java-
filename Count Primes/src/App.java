import java.util.Scanner;

public class App {
    public static int countPrime(int n) {
        if (n < 2)
            return 0;
        int[] arr = new int[n];

        for (int i = 2; i * i <= n; i++) {
            if (arr[i] == 0) {
                // only marks multiple after the square
                for (long j = (long) i * i; j < n; j = j + i) {
                    arr[(int) j] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value");
        int n = sc.nextInt();
        
        System.out.println(countPrime(n));
    }

}
