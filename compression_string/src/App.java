import java.util.Scanner;
import java.util.Stack;
public class App {
    
    public static String compression(String s){
        Stack<Character> stack = new Stack<Character>();
        String str = "";
        for(int i=0;i<s.length();i++){
        
            while(!stack.isEmpty() && i<s.length() && stack.peek()==s.charAt(i) ){
                stack.pop();
                i++;
                
            }
            if(i<s.length()){
                stack.push(s.charAt(i));
            }
            
            
        }
        while(!stack.isEmpty()){
            str = str+stack.pop();
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        System.out.println(compression(s));

    }
}
