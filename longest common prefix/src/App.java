import java.util.Scanner;

public class App {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return "";
        String ans = strs[0];
        int len = strs[0].length();

        for(int i=1;i<strs.length;i++){
            String s = strs[i];

            while(len > s.length() || !ans.equals(s.substring(0,len))){
                len--;
                if(len == 0){
                    return "";
                }

                ans = ans.substring(0,len);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }

        App app = new App();
        String result = app.longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result);
        scanner.close();
    }
}