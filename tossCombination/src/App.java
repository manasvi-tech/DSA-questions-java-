import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void tossCombinations(List<List<String>> ans , List<String> comb, int i, int n){
        if(i==n){
          
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(i>n) return;
        comb.add("H");
        tossCombinations(ans, comb, i+1, n);
        comb.remove(comb.size()-1);
        comb.add("T");
        tossCombinations(ans, comb, i+1, n);
        comb.remove(comb.size()-1);

    }
   
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       List<List<String>> ans = new ArrayList<>();
       List<String> comb = new ArrayList<>(); 
       tossCombinations(ans,comb,0,n);
       for(List<String> s : ans ){
            for(String str: s){
                System.out.println(s);
                break;
            }
       }
    }
}
