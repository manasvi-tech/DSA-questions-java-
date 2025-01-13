
public class App {
    public int minimumLength(String s) {
        int[] cnt = new int[26];
        int len = 0;
        
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        
        for (int num : cnt) {
            if (num == 0) continue;
            len += (num % 2 == 0) ? 2 : 1;
        }        
        return len;
    }

    public static void main(String[] args) {
        App app = new App();
        String s = "abccba";
        int result = app.minimumLength(s);
        System.out.println("Minimum length of string after operations: " + result);
    }
}