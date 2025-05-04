import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for(int num : nums){
            if(count1==0 && element2!=num){
                count1++;
                element1 = num;
            }

            else if(count2==0 && element1!=num){
                count2++;
                element2 = num;
            }

            else if(element1 == num){
                count1++;
            }

            else if(element2 == num){
                count2++;
            }

            else{
                count1--;
                count2--;
            }
        }
        // manual checking because there is not a necessity that majority elements exist
        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(num == element1) count1++;
            if(num == element2) count2++;
        }

        int min = nums.length/3;
        List<Integer> ans = new ArrayList<>();

        if(count1>min) ans.add(element1);
        if(count2>min) ans.add(element2);

        return ans;
    }
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the size of the array:");
    int n = scanner.nextInt();
    int[] nums = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
        nums[i] = scanner.nextInt();
    }
    scanner.close();

    App app = new App();
    List<Integer> result = app.majorityElement(nums);
    System.out.println("Majority elements are: " + result);
    }
}
