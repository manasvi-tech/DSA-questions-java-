import java.util.HashSet;
import java.util.Scanner;

public class App {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high = 0;
        int max = 0;
        HashSet<Character> set = new HashSet();
        while(high<s.length()){
            if(!set.contains(s.charAt(high))){
                set.add(s.charAt(high));
                high++;
                max = Math.max(max,set.size());
            }
            else{
                set.remove(s.charAt(low));
                low++;
            }
        }
        return max;
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        App app = new App();
        int result = app.lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
        scanner.close();
    }
}
