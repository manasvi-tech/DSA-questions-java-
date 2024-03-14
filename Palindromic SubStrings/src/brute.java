
// brute force

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class brute {
    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static List<String> subStrings(String s){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s.substring(i,j+1))){
                    ans.add(s.substring(i,j+1));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        List<String> ans = subStrings(s);
        for(String str : ans){
            System.out.print(str+" ");
        }
    }   
}
