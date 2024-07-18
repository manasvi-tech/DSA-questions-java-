import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class App {

    public static int lastStoneWeight(int[] stones) {
        if(stones.length==1){
            return stones[0];
        }
        if(stones.length==2 && stones[0]==stones[1]){
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //maxHeap
        for(int num : stones){
            maxHeap.add(num);
        }

        while(maxHeap.size()!=1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x==y){
                if(maxHeap.size()==0){
                    return 0;
                }
                else{
                    continue;
                }

            }
            else{
                maxHeap.add(x-y);
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the total number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(lastStoneWeight(arr));
    }
}
