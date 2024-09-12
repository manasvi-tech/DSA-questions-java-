import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<allowed.length();i++){
            map.put(allowed.charAt(i),map.getOrDefault(allowed.charAt(i),0)+1);
        }

        int count = 0;

        for(String str : words){
            boolean flag = true;
            for(int i=0;i<str.length();i++){
                if(!map.containsKey(str.charAt(i))){
                    flag = false;
                }
            }
            if(flag) count++;
        }
        return count;
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
        
        System.out.println("Enter the element");
        String allowed = sc.next();

        System.out.println(countConsistentStrings(allowed, arr));
    }
}
