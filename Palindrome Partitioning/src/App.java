import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void helper(String s, int ind, List<List<String>> ans, List<String> set){

        if(ind == s.length()){
            ans.add(new ArrayList<>(set));
            return;
        }

        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s, i, ind)){
                set.add(s.substring(ind, i+1));
                helper(s,i+1,ans,set);

                set.remove(set.size()-1);
            }
        }

    }

    public List<List<String>> palindromePartitioning(String s){

        List<List<String>> ans = new ArrayList<>();

        helper(s,0,ans,new ArrayList<>());

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to partition into palindromes:");
        String input = scanner.nextLine();
        scanner.close();

        App app = new App();
        List<List<String>> result = app.palindromePartitioning(input);

        System.out.println("Palindrome partitions:");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
