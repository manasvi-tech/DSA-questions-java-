import java.util.Scanner;

public class App {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix = 1;
            if(suffix==0) suffix = 1;

            prefix = prefix*nums[i];
            suffix = suffix*nums[n-i-1];

            max = Math.max(max,Math.max(prefix,suffix));
        }  
        return max; 
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(maxProduct(arr));
        

    }
}
