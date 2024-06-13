// memoization techinque

import java.util.Arrays;


public class App {
    
    int[][] dp;

    public int isPalindrome(String s,int i,int j){
        if(i>=j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] = s.charAt(i)==s.charAt(j) ? isPalindrome(s,i+1,j-1) : 0;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                count+=isPalindrome(s,i,j);
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        String str = "aaa";
        App a = new App();
        System.out.println(a.countSubstrings(str));
    }

}




