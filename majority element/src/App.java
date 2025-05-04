public class App {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int counter = 0;

        for(int num : nums){
            if(counter == 0){
                element = num;
                counter = 1;
            }

            else if(num == element){
                counter++;
            }

            else if(num!=element){
                counter--;
            }
        }
        return element;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] nums = {3, 3, 4, 2, 3, 3, 3};
        int result = app.majorityElement(nums);
        System.out.println("The majority element is: " + result);
    }
}
