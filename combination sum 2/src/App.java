import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    private static void helper(int[] arr, int target, int ind, List<List<Integer>> ans, List<Integer> set){
        if(target==0){
            ans.add(new ArrayList<>(set));
            return;
        }

        for(int i=ind;i<arr.length;i++){
            if(arr[i]>target) break;

            if(i>ind && arr[i]==arr[i-1]) continue; // checking for duplicates

            set.add(arr[i]);
            helper(arr, target-arr[i],i+1,ans,set);
            
            set.remove(set.size()-1);
        }
    }

    private static List<List<Integer>> combSum2(int[] arr, int target){
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(arr);

        helper(arr, target, 0, ans, set);

        return ans;
        
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Plaese enter number of elements");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Please enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Please enter target");
        int target = sc.nextInt();

        List<List<Integer>> ans= combSum2(arr,target);

        for(List<Integer> set : ans){
            System.out.print("[");
            for(int num : set){
                System.out.print(num+", ");
            }
            System.out.print("] , ");
        }

    }
}
