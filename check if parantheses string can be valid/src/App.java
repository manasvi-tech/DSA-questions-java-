// Left-to-right: A valid string must not have more ) than ( at any point.
// Right-to-left: A valid string must not have more ( than ) at any point.

import java.util.Scanner;

public class App {
    public boolean canBeValid(String s, String locked){
        if(s.length()%2!=0){
            return false;
        }

        int unlock = 0;
        int balance = 0;

        // left to right
        for(int i=0;i<s.length();i++){

            char num = locked.charAt(i);
            char ch = s.charAt(i);
            
            if(num=='0'){
                unlock++;
            } else if(ch == '('){
                balance++;
            } else if(ch == ')'){
                balance--;
            }

            if(balance<0){
                if (unlock > 0) {
                    balance++;
                    unlock--;
                } else {
                    return false; // Not enough unlocked parentheses to fix imbalance
                }
            }

        }
        
        unlock = 0;
        balance = 0;

        // right to left
        for(int i=s.length()-1;i>=0;i--){

            char num = locked.charAt(i);
            char ch = s.charAt(i);
            
            if(num=='0'){
                unlock++;
            } else if(ch == ')'){
                balance++;
            } else if(ch == '('){
                balance--;
            }

            if(balance<0){
                if (unlock > 0) {
                    balance++;
                    unlock--;
                } else {
                    return false; // Not enough unlocked parentheses to fix imbalance
                }
            }

        }

        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the parentheses string:");
        String s = scanner.nextLine();
        System.out.println("Enter the locked string:");
        String locked = scanner.nextLine();
        scanner.close();

        App app = new App();
        boolean result = app.canBeValid(s, locked);
        System.out.println("The Parantheses string is valid : " + result);
    }
}
