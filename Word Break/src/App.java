import java.util.ArrayList;
import java.util.List;

public class App {
    private static boolean helper(int i, String s, List<String> wordDict, Boolean[] dp){
        if (i == s.length()) {
            return true;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        for (String word : wordDict) {
            if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                if (helper(i + word.length(), s, wordDict, dp)) {
                    return dp[i] = true;
                }
            }
        }
        return dp[i] = false;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() + 1]; // Use Boolean to handle null checks
        return helper(0, s, wordDict, dp);
    }
        
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("car");
        list.add("ca");
        list.add("rs");
        // String s = "leetcode";
        // System.out.println(s.substring(0,5));

        System.out.println(wordBreak("cars", list));
    }       
}
