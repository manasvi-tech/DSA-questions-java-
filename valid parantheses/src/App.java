import java.util.Scanner;
import java.util.Stack;
public class App {
    public static boolean validParan(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(stack.peek()=='(' && !stack.isEmpty()){
                    stack.pop();
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
            
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.println(validParan(s));
    }
}
