import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
            maxFreq = Math.max(freq, maxFreq);
        }

        // buckets till highest frequency
        // array of lists
        List<Integer>[] buckets = new ArrayList[maxFreq + 1];

        for (int key : map.keySet()) {
            int val = map.get(key);

            if (buckets[val] == null) {
                buckets[val] = new ArrayList<>();
            }

            buckets[val].add(key);
        }

        int[] ans = new int[k];
        int ind = 0;
        for(int i=maxFreq;i>=0 && ind<k ;i--){
            if(buckets[i]!=null){
                for(int num : buckets[i]){
                    ans[ind] = num;
                    ind++;
                    if(ind==k) break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value of k");
        int k = sc.nextInt();

        int[] ans = topKFrequent(arr,k);

        for(int num : ans){
            System.out.println(num+ " ");
        }
    }
}
