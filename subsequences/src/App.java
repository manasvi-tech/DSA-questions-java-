import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void subsequences(String str, int i, int n,List<List<String>> ans, List<String> comb){
        if(i>=n){
            ans.add(new ArrayList<>(comb));
            return;
        }
        comb.add(str.charAt(i)+"");
        subsequences(str, i+1, n, ans, comb);

        comb.remove(comb.size()-1);
        subsequences(str,i+1,n,ans,comb);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<List<String>> ans = new ArrayList<>();
        List<String> comb = new ArrayList<>();
        String str = sc.nextLine().trim();
        subsequences(str, 0, str.length(), ans, comb);
        for(List<String> s : ans){
            for(String st : s){
                System.out.println(s);
                break;
            }
        }
    }
}
