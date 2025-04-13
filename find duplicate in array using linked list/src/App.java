public class App {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // treating it as a circular linked list
        // whatever is stored at the index points to that index itself
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            // found the first intersection point it means the cycle exists
            if(slow == fast){
                break;
            }
        }

        // floyd's theorem to find the beginning of the cycle
        int slow2 = 0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];

            if(slow == slow2){
                return slow;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = app.findDuplicate(nums);
        System.out.println("The duplicate number is: " + duplicate);
    }
}
