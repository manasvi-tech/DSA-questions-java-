import java.util.Scanner;

public class App {
    public static int getLucky(String s, int k) {
        // Convert each character in the string to its corresponding numeric value
        StringBuilder number = new StringBuilder();
        for (char x : s.toCharArray()) {
            number.append(x - 'a' + 1);
        }
        
        // Perform the transformation `k` times
        while (k > 0) {
            int temp = 0;
            for (char x : number.toString().toCharArray()) {
                temp += x - '0';  // Sum the digits of the current number
            }
            number = new StringBuilder(String.valueOf(temp));  // Convert the sum back to a string
            k--;
        }
        return Integer.parseInt(number.toString());  // Return the final result as an integer
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.next();

        System.out.println("Enter the value of k");
        int k = sc.nextInt();

        System.out.println(getLucky(s, k));
    }
}
