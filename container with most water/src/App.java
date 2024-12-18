import java.util.Scanner;

public class App {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int maxWater = Integer.MIN_VALUE;
        int water = 0;

        int heightInBetween = 0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                // if(j!=i+1){
                //     heightInBetween = Math.min(Math.min(heights[i],heights[j]),heights[j-1]);
                // }

                water = (Math.min(heights[i],heights[j])*(j-i));
                // System.out.println(water);

                maxWater = Math.max(water,maxWater);
            }

            heightInBetween = 0;
        }

        return maxWater;
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] heights = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        scanner.close();

        App app = new App();
        int result = app.maxArea(heights);
        System.out.println("The maximum area of water the container can hold is: " + result);
    }
}
