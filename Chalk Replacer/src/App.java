import java.util.Scanner;

public class App {
    public static int ceil(long[] arr, int chalks){
        int start = 0;
        int end = arr.length-1;
        int ans = 0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==chalks) return mid+1; // nextt chlid will replace the chalk;
            else if (arr[mid]<chalks){
                start = mid + 1;
            } else{
                ans = mid;
                end = mid -1 ;
            }
        }
        return ans;
    }

    public static int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] preSum = new long[n];
        preSum[0] = chalk[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + chalk[i];
        }

        long sum = preSum[n-1];
        int remainder = (int)(k%sum);
        return ceil(preSum, remainder);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of students");
        int n = sc.nextInt();
        int[] chalks = new int[n];

        System.out.println("Enter chalks required by each student");
        for(int i=0;i<n;i++){
            chalks[i] = sc.nextInt();
        }

        System.out.println("Enter the number of total chalks");
        int k = sc.nextInt();

        System.out.println(chalkReplacer(chalks, k));
    }
}
