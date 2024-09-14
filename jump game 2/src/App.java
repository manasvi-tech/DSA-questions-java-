import java.util.Scanner;

// l and r represent the range during that particular step
public class App {
    public static int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int jumps = 0;
        while(r<nums.length-1){
            int farthest = 0;
            for(int ind = l;ind<=r;ind++){
                farthest = Math.max(farthest,ind+nums[ind]);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
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
        System.out.println(jump(arr));
    }
}
