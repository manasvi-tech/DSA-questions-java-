import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<Integer> generateRow(int r){
        int ans = 1;
        List<Integer> row = new ArrayList<>();
        row.add(ans);
        for(int i=1;i<r;i++){
            ans = ans*(r-i);
            ans = ans/i;
            row.add(ans);
        }
        return row;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            list.add(generateRow(i));
        }
        return list;
    }
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int n = sc.nextInt();

        System.out.println(generate(n));
    }
}
