import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static int[] arrayRankTransform(int[] arr) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // first converts array into stream so that operations can be applied
        // then only keeps distinct elements. Then sorts
        // converts back to array

        int[] sortedNumber = Arrays.stream(arr).distinct().sorted().toArray();

        for(int i=0;i<sortedNumber.length;i++){
            map.put(sortedNumber[i],i+1);
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
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

        int[] ans = arrayRankTransform(arr);

        for(int num : ans){
            System.out.print(num+" ");
        }
    }
}
