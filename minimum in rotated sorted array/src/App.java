public class App {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            //left half is sorted
            //we know that it will be the first element itself
            //the left half has been checked so time to move on to right half
            if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            //vice-versa for every situation
            else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
         return ans;
     }
    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = app.findMin(nums);
        System.out.println("The minimum element in the rotated sorted array is: " + result);
    }
}
