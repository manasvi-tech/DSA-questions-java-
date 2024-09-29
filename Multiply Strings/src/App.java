import java.util.Scanner;

public class App {
    private static char[] reverse(String s){
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return arr;
    }
    public static String multiply(String num1, String num2) {
        char[] s1 = reverse(num1);
        char[] s2 = reverse(num2);

        int[] res = new int[s1.length+s2.length];

        for(int i=0;i<s1.length;i++){

            int carry = 0;
            int start = i;

            for(int j=0;j<s2.length;j++){
                int n1 = s1[i] - '0';
                int n2 = s2[j] - '0';
                int sum = (n1*n2) + res[start]+carry;
                int base = sum%10;
                carry = sum/10;
                res[start++] = base;
            }
            if(carry!=0) res[start] = carry;
        }

        int i = res.length-1;
        while(i>0 && res[i]==0) i--;

        String ans = "";
        while(i>=0){
            ans+=res[i--];
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number");
        String num1 = sc.next();

        System.out.println("Enter second number");
        String num2 = sc.next();

        System.out.println(multiply(num1, num2));
    }
}
