import java.util.Scanner;

public class App {
    public static void helper(String str, int i, int n, StringBuilder ans){
		if(i>=n){
			System.out.print(ans.toString()+" ");
			return;
		}
		if(str.charAt(i)=='?'){
			ans.append('0');
			helper(str,i+1,n,ans);
            ans.setLength(ans.length()-1);

			
			ans.append('1');
			helper(str,i+1,n,ans);
            ans.setLength(ans.length()-1);
            
		}
		else{
			ans.append(str.charAt(i));
			helper(str,i+1,n,ans);
            ans.setLength(ans.length()-1);
		}
	}
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume newline after reading integer T // ye dikkat kr rha tha

        for (int t = 0; t < T; t++) {
            String s = scanner.nextLine().trim();
            helper(s, 0,s.length(), new StringBuilder());
            
            }
            System.out.println(); 

    }
    
}
