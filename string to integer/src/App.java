public class App {
    public int myAtoi(String s) {
        s = s.trim(); // remove leading whitespaces
        int sign = 1;
        int i=0;

        long ans = 0;

        if(s.length() == 0) return 0;

        if(s.charAt(0) == '-'){
            sign = -1;
            i++;
        }

        else if(s.charAt(0) == '+'){
            i++;
        }

        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch<'0' || ch> '9') break;

            ans = ans * 10 + (ch - '0') ;

            if (sign * ans > Integer.MAX_VALUE) return Integer.MAX_VALUE; // Handle overflow
            if (sign * ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int) (sign*ans);      
    }
    public static void main(String[] args) throws Exception {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a string to convert to integer:");
        String input = scanner.nextLine();
        App app = new App();
        int result = app.myAtoi(input);
        System.out.println("Converted integer: " + result);
        scanner.close();
    }
}
