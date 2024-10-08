import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    public static List<Integer> partitionLables(String s){
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int size = 0;
        int end = 0;
        int i=0;

        while(i<s.length()){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            size++;

            if(end==i){
                ans.add(size);
                size=0;
            }

            i++;
        }
        return ans;
    }
   
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.next();

        System.out.println(partitionLables(s));
    }
}
