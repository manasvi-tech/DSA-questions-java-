import java.util.Scanner;

public class App {
    private static boolean canJump(int[] nums){
        if(nums.length==1){
            return true;
        }

        int n = nums.length;
        
        int maxDistance = 0;
        for(int i=0;i<n;i++){
            if(i>maxDistance) return false;
            maxDistance = Math.max(i+nums[i],maxDistance);
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the size of the array");
        int n = sc.nextInt();
        
        int[] arr = new int[n];

        System.out.println("Enter the number of steps further from each step");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(canJump(arr));

    }
}
