import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<String> uncommonFromSentences(String s1, String s2) {

        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        String[] word1 = s1.split(" ");
        String[] word2 = s2.split(" ");

        for(String word : word1){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        for(String word : word2){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        // uncommon words will be the one that appear exactly once in the hashmap

        for(String word : map.keySet()){
            if(map.get(word)==1){
                list.add(word);
            }
        }

        return list;
    }
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first sentence");
        String s1 = sc.nextLine();

        System.out.println("Enter second sentence");
        String s2 = sc.nextLine();

        System.out.println(uncommonFromSentences(s1, s2));
    }
}
