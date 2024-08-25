import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//we will store decreasing order because at any moment
// any ele<= a[i] has to be removed so we will always have the maximums

// first we will remove all out of bounds index from dequeue
// and then remove the ones that are smaller

public class App {

    // brute force
    public int[] maxWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n-k+1];
        int ind = 0;
        for(int i=0;i<n-k+1;i++){
            int max = arr[i];
            for(int j=i;j<i+k;j++){
                max = Math.max(max,arr[j]);
            }
            ans[ind]=max;
            ind++;
        }
        return ans;
    }

    // optimal approach
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int rightIndex = 0;

        // doubly queue
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // removing out of bounds
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }

            // we need to keep it strictly decreasing so remove smaller numbers
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                ans[rightIndex] = nums[q.peek()];
                rightIndex++;
            }
        }

        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the size of the window");
        int k = sc.nextInt();

        int[] ans = maxSlidingWindow(arr, k);

        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
