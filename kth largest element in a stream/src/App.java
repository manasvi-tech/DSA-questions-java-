import java.util.PriorityQueue;
// import java.util.Scanner;

public class App {
    class KthLargest {
        int k;
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // minHeap

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                queue.add(num);

                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        public int add(int val) {
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
