import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] max = new int[26];
        int[] temp = new int[26];

        // if one word of word2 already contains one letter, we dont have to increase the frequency in the second one
        for(String word : words2){
            Arrays.fill(temp,0);
            for(char ch : word.toCharArray()){
                temp[ch - 'a']++;
            }

            for(int i=0;i<26;i++){
                max[i] = Math.max(max[i],temp[i]);
            }
        }

        List<String> ans = new ArrayList<>();

        for(String word : words1){
            Arrays.fill(temp,0);

            for(char ch : word.toCharArray()){
                temp[ch - 'a']++;
            }

            boolean isUniversal = true;

            for(int i=0;i<26;i++){
                if(max[i]>temp[i]){
                    isUniversal = false;
                    break;
                }
            }

            if(isUniversal){
                ans.add(word);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of words in words1:");
        int n1 = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        String[] words1 = new String[n1];
        System.out.println("Enter the words for words1:");
        for (int i = 0; i < n1; i++) {
            words1[i] = scanner.nextLine();
        }

        System.out.println("Enter the number of words in words2:");
        int n2 = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        String[] words2 = new String[n2];
        System.out.println("Enter the words for words2:");
        for (int i = 0; i < n2; i++) {
            words2[i] = scanner.nextLine();
        }

        App app = new App();
        List<String> result = app.wordSubsets(words1, words2);

        System.out.println("The universal words are:");
        for (String word : result) {
            System.out.println(word);
        }

        scanner.close();
    }
}