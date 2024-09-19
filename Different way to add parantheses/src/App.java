import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<Integer> split(String expression, int start, int end, List<Integer>[][] dp){
        List<Integer> res = new ArrayList<>();

        if(dp[start][end]!=null){
            return dp[start][end];
        }

        // Base case for a single digit
        if (start == end && Character.isDigit(expression.charAt(start))) {
            int num = expression.charAt(start) - '0';
            res.add(num);
            return res;
        }

        // Base case for multi-digit number (check if the substring is entirely numeric)
        boolean isNumber = true;
        for (int i = start; i <= end; i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                isNumber = false;
                break;
            }
        }
        if (isNumber) {
            // Parse the substring only if it is a valid number
            String numStr = expression.substring(start, end + 1);
            if (!numStr.isEmpty()) {
                res.add(Integer.parseInt(numStr));
                return res;
            }
        }

        // Recursively split the expression based on operators
        for (int i = start; i <= end; i++) {
            char c = expression.charAt(i);
            // Only split when we encounter an operator
            if (!Character.isDigit(c)) {
                char op = expression.charAt(i);
                List<Integer> left = split(expression, start, i - 1,dp);
                List<Integer> right = split(expression, i + 1, end,dp);

                for (int l : left) {
                    for (int r : right) {
                        if (op == '*') {
                            res.add(l * r);
                        } else if (op == '-') {
                            res.add(l - r);
                        } else if (op == '+') {
                            res.add(l + r);
                        }
                    }
                }
            }
        }

        return dp[start][end]=res;
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();

        // 2d array of lists damnnnn
        List<Integer>[][] dp = new ArrayList[n][n];

        return split(expression, 0, n - 1,dp);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the equation");
        String s = sc.nextLine();

        System.out.println(diffWaysToCompute(s));
        
    }
}
