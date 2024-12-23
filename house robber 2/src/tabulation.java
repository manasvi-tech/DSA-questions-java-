import java.util.Scanner;

class tabulation {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        // when the first element is taken
        int[] arr1 = new int[n];

        // when the last element is taken. 
        // both first and last can not be taken simeltaneously.
        int[] arr2 = new int[n];
        arr1[0]=0;
        arr1[1]=nums[0];

        for(int i=1;i<n-1;i++){
            int pick = arr1[i-1]+nums[i];
            int not_pick=arr1[i];
            arr1[i+1] = Math.max(pick,not_pick);
        }

        arr2[0]=0;
        arr2[1]=nums[1];

        for(int i=2;i<n;i++){
            int pick = arr2[i-2]+nums[i];
            int not_pick = arr2[i-1];
            arr2[i]=Math.max(pick,not_pick);
        }

        return Math.max(arr1[n-1],arr2[n-1]);
        
    }

    public static void main (String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of houses:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the amount of money in each house:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        App app = new App();
        int maxRobbedAmount = app.rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxRobbedAmount);
    }
}
