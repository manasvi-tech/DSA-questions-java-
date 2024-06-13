import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void generatePermutations(ArrayList<ArrayList<String>> list,String str, int i, ArrayList<String> set){
        if(i==str.length()){
            list.add(new ArrayList<>(set));
            return;
        }
        for(int i=0;i<str.length();i++){
            if(set.contains(str.charAt(i))){
                continue;
            }
            set.add(str.charAt(i)+"");
            generatePermutations(list, str, i+1, set);

            set.remove(set.size()-1);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayList<ArrayList<String>> list = new ArrayList<>();

        ArrayList<String> comb = new ArrayList<>();

        generatePermutations(list, input, 0, comb);

        ArrayList<String> ans = new ArrayList<>();
        for(ArrayList<String> perm : list){
            ans.add(perm+"");
        }

        Collections.sort(ans);

        



    }
}
