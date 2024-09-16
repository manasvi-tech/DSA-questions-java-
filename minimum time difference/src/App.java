import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static int findMinDiff(String[] times){
        int min = Integer.MAX_VALUE;
        int n = times.length;

        int[] minutes = new int[n];

        for(int i=0;i<n;i++){
            int h = Integer.parseInt(times[i].substring(0,2));
            int m = Integer.parseInt(times[i].substring(3));

            minutes[i] = h*60+m;
        }

        Arrays.sort(minutes);

        for(int i=0;i<n-1;i++){
            min = Math.min(min, minutes[i+1]-minutes[i]);
        }

        // becuase the clock is round we are going to reach the next day eventually.
        return Math.min(min, 24*60 - (minutes[n-1]-minutes[0]));
    }
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array");
        int n = sc.nextInt();
        
        String[] arr = new String[n];

        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }
        
        System.out.println(findMinDiff(arr));
    }
}
