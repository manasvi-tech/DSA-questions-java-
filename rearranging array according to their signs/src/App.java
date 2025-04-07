public class App {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int posIndex = 0;
        int negIndex = 1;
        
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[posIndex] = nums[i];
                posIndex+=2;
            }
            else{
                ans[negIndex] = nums[i];
                negIndex+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = app.rearrangeArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
