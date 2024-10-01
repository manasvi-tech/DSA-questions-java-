import java.util.Scanner;

public class App {
    public static boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for(int i=0;i<arr.length;i++){

            int rem = ((arr[i]%k)+k)%k;
            count[rem]++;
        }

        
        if(count[0]%2!=0) return false;

        for(int i=1;i<k/2+1;i++){
            if(count[i]!=count[k-i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of k");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value of k");
        int k = sc.nextInt();

        System.out.println(canArrange(arr, k));
    }
}
