import java.util.Arrays;

public class App {

    final static long mod = 1000000007;

    public static int numTilings(int n) {
        int[][] dp = new int[n + 1][2];  // dp[i][0]: possible=false, dp[i][1]: possible=true
        for (int[] row : dp) Arrays.fill(row, -1);
        return (int) dominoes(0, n, false, dp);
    }

    private static long dominoes(int i, int n, boolean possible, int[][] dp) {
        if (i == n) return possible ? 0 : 1;
        if (i > n) return 0;

        int state = possible ? 1 : 0;
        if (dp[i][state] != -1) return dp[i][state];

        long res;
        if (possible) {
            res = (dominoes(i + 1, n, false, dp) + dominoes(i + 1, n, true, dp)) % mod;
        } else {
            res = (
                dominoes(i + 1, n, false, dp)
                + dominoes(i + 2, n, false, dp)
                + 2 * dominoes(i + 2, n, true, dp)
            ) % mod;
        }

        dp[i][state] = (int) res;
        return res;
    }
    public static void main(String[] args) throws Exception {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        int result = numTilings(n);
        System.out.println("Number of ways to tile: " + result);
        scanner.close();
    }
}
