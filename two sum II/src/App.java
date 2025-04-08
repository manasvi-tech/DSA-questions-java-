import java.util.Scanner;

public class App {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;

        while(start<=end){
            int sum = numbers[start]+numbers[end];
            if(sum==target){
                return new int[]{start+1,end+1};
            }
            else if(sum<target){
                start++;
            }
            else{
                end--;
            }
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the size of the array:");
    int n = scanner.nextInt();
    int[] numbers = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
        numbers[i] = scanner.nextInt();
    }

    System.out.println("Enter the target value:");
    int target = scanner.nextInt();

    App app = new App();
    int[] result = app.twoSum(numbers, target);

    if (result != null) {
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    } else {
        System.out.println("No solution found.");
    }

    scanner.close();
    }
}
