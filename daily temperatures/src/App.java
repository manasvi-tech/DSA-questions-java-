import java.util.Scanner;
import java.util.Stack;

public class App {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                ans[st.peek()] = i - st.pop();
            } 
            st.push(i);
        }
        st.clear();
        return ans;  
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of days:");
        int n = scanner.nextInt();
        int[] temperatures = new int[n];
        
        System.out.println("Enter the temperatures:");
        for (int i = 0; i < n; i++) {
            temperatures[i] = scanner.nextInt();
        }
        
        App app = new App();
        int[] result = app.dailyTemperatures(temperatures);
        
        System.out.println("Days to wait for a warmer temperature:");
        for (int days : result) {
            System.out.print(days + " ");
        }
        scanner.close();
    }
}
