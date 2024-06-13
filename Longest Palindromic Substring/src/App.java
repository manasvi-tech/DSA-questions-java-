import java.util.Scanner;

public class App {
    public static String palindrome(String s){
        int n= s.length();
        int maxLength = 0;
        String ans = "";
        
        for(int i=0;i<n;i++){
            //odd length
            int left = i;
            int right = i;

            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                if(right-left+1 > maxLength){
                    ans = s.substring(left, right + 1);
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }

            //even length
            left = i;
            right = i+1;

            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                if(right-left+1 > maxLength){
                    ans = s.substring(left, right + 1);
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();

        System.out.println("Longest Palindromic Substring of "+s+" is "+ palindrome(s));

    }
}
