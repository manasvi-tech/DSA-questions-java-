import java.util.Scanner;
import java.util.Stack;


// one pass solution, this will make you cry

// time complexity : O(2n)
// space complexity : O(n)


public class App {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            // we will start popping as soon as we see the next smaller element
            // getting the previous smaller element on the run
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                // compute the max area for the top element now, because we
                // already had the previous smaller element and just discovered the next smaller element
                int element = heights[st.pop()];
                int nse = i;
                int pse = (st.isEmpty()) ? -1 : st.peek();
                maxArea = Math.max(element*(nse-pse-1),maxArea);
            }
            st.push(i);
        }   
        while(!st.isEmpty()){
            int element = heights[st.pop()];
            int nse = heights.length;
            int pse = (st.isEmpty()) ? -1 : st.peek();
            maxArea = Math.max(element*(nse-pse-1),maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the histogram:");
        int n = scanner.nextInt();
        int[] heights = new int[n];
        System.out.println("Enter the heights of the histogram:");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        scanner.close();

        App app = new App();
        int maxArea = app.largestRectangleArea(heights);
        System.out.println("The largest rectangle area is: " + maxArea);
    }
}
