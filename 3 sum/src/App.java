import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // for sorting the duplicates quickly
        int n = arr.length;

        for(int i=0;i<n-2;i++){
            if(i>0 && arr[i]==arr[i-1]) continue; //making sure to go avoid duplicates for i
            int left = i+1;
            int right = n-1;

            while(left<right){
                int sum = arr[left]+arr[right]+arr[i];
                if(sum < 0){
                    left++;
                }

                else if(sum>0){
                    right--;
                }

                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    ans.add(new ArrayList<>(list));
                    right--;
                    left++;

                    while(left<right && arr[right]==arr[right+1]) right--;
                    while(left<right && arr[left]==arr[left-1]) left++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(threeSum(arr));
    }
}

