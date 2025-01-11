// work with frequencies because they characters can be rearranged
// split number of chars into k parts and double check with the frequency
// if number of oddFrequencies <= k. the answer is always true

import java.util.HashMap;
import java.util.Scanner;

public class App {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int oddFreq = 0;
        // count total number of odd frequencies
        for (char c : map.keySet()) {
            int val = map.get(c);
            if (val % 2 != 0) {
                oddFreq++;
            }
        }

        return oddFreq <= k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = scanner.nextLine();
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();
        scanner.close();

        App app = new App();
        boolean result = app.canConstruct(s, k);
        System.out.println("Can construct " + k + " palindrome strings: " + result);
    }
}