import java.util.Scanner;

public class App {
    // leftMin and leftMax are the minimum and maximum number of right open
    // paranthesis respectively
    // "*" means it could be anything if it were "(" we increase the number of
    // leftMax
    // "*" if it were ")" we reduce the number of leftMin
    // we are keeping the track of minimum and maximum after all
    public static boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }

        }
        return leftMin == 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String st = sc.next();

        System.out.println(checkValidString(st));
    }
}
