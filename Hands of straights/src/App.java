import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;


public class App {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : hand)
            count.put(n, 1 + count.getOrDefault(n, 0));

        PriorityQueue<Integer> minH = new PriorityQueue<>(count.keySet());
        while (!minH.isEmpty()) {
            int first = minH.peek();
            for (int i = first; i < first + groupSize; i++) {
                if (!count.containsKey(i))
                    return false;
                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
                    if (i != minH.peek())
                        return false;
                    minH.poll();
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        int[] arr = new int[n];


        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter group size");
        int size = sc.nextInt();

        System.out.println(isNStraightHand(arr, size));
    }
}
