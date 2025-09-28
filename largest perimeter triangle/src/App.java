import java.util.Arrays;

public class App {

    private int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length - 1; i >=2 ; i--){
            if(nums[i-1] + nums[i-2] > nums[i]){
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }  
        return 0; 
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] nums = {2, 1, 2};
        System.out.println(app.largestPerimeter(nums));
    }
}
