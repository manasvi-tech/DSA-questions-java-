import java.util.Scanner;

public class App {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m+n);

        for(int roll : rolls){
            sum = sum - roll;
        }

        if(sum < n || sum > 6*n ){
            return new int[0];
        }

        int avg = sum/n;
        int rem = sum%n;
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = avg;
            if(rem>0){
                ans[i]++;
                rem--;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the numer of missing elements");
        int x = sc.nextInt();

        System.out.println("Enter the value of mean");
        int mean = sc.nextInt();

        missingRolls(arr, mean, x);
    }
}
