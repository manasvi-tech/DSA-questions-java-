import java.util.Arrays;

class App {
    public int recursion(int n, int m, String s, String t, int i, int j, int[][] dp){
        if(j==m){
            return 1;
        }
        if(i==n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int match =0;
        int n_match = 0;
        if(s.charAt(i) == t.charAt(j)){
            // normal approach working by choosing the first matching index
            int ans1 = recursion(n,m,s,t,i+1,j+1,dp);

            // leaving the first matched index and still looking for the same
            int ans2 = recursion(n,m,s,t,i+1,j,dp);
            match = ans1+ans2;
        }

        else{
            n_match = recursion(n,m,s,t,i+1,j,dp);
        }

        return dp[i][j] = match+n_match;
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return recursion(n,m,s,t,0,0,dp);
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.nextLine();
        System.out.print("Enter string t: ");
        String t = sc.nextLine();
        App app = new App();
        int result = app.numDistinct(s, t);
        System.out.println("Number of distinct subsequences: " + result);
        sc.close();
    }
}
