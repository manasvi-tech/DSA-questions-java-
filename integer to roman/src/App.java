public class App {

    public static String intToRoman(int num) {
        String roman = "";
        int[] storeInt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] storeRoman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < storeInt.length; i++) {
            while (num >= storeInt[i]) {
                roman += storeRoman[i];
                num -= storeInt[i];
            }
        }
        
        return roman;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        String roman = intToRoman(num);
        System.out.println("Roman numeral: " + roman);
        scanner.close();
    }
}
