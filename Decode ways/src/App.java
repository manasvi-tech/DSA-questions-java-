import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static int helper(String s, int i, int[] dp){
        if(i >= s.length()-1){
            if(i==s.length()-1 && s.charAt(i)=='0') return 0;
            return 1;
        }

        if(s.charAt(i)=='0'){ // 0 represents nothing and anything like '04' or '03' is also not valid
            return 0;
        }

        if(dp[i]!=-1) return dp[i];


        if(s.charAt(i)=='0'){
            return helper(s,i+1,dp);
        }

        int one_digit = helper(s,i+1,dp);
        int two_digits = 0;
        if((s.charAt(i) - '0')*10 +(s.charAt(i+1) - '0')<=26){
            two_digits = helper(s,i+2,dp);
        }

        return dp[i] = one_digit+two_digits;
    }

    public static int numDecodings(String s){
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return helper(s,0,dp);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your string");
        String s = sc.nextLine();

        System.out.println(numDecodings(s));
    }
}
