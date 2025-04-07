public class App {
    
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
    
            if(m+n != s3.length()) return false;
    
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0]=true;
    
            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    if(i>0 && s1.charAt(i-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                    if(j>0 && s2.charAt(j-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i][j] || dp[i][j-1];
                    }
                }
            }
            return dp[m][n];
        }
    
    public static void main(String[] args) throws Exception {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Enter first string (s1):");
        String s1 = scanner.nextLine();

        System.out.println("Enter second string (s2):");
        String s2 = scanner.nextLine();

        System.out.println("Enter third string (s3):");
        String s3 = scanner.nextLine();

        App app = new App();
        boolean result = app.isInterleave(s1, s2, s3);

        System.out.println("Is s3 an interleaving of s1 and s2? " + result);

        scanner.close();
    }
}
