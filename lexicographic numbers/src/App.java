import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    
    // Recursion approach : SC:O(n)

    // works like depth-first search algorithm
    // first you explore the childs of a given number (multiply by 10 and +1 after for its sibling)
    // and if that is done you explore the next sibling (+1)
    // preorder traversal will work here

    public static List<Integer> recLexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;i++){
            if(i>n) break;
            dfs(i,n,res);
        }

        return res;
    }

    public static void dfs(int i, int n, List<Integer> res){
        if(i>n) return;

        res.add(i);

        for(int x=0;x<10;x++){
            if(i*10+x>n) break;
            dfs(i*10+x,n,res);
        }
    }


    
    // optimizing the space
    // iterate rather than recurse. *10 if possible. otherwise +1. if you dont reach the target or new most signifcant bit is not introduced
    
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int currNum = 1;

        for(int i=1;i<=n;i++){
            res.add(currNum);

            if(currNum*10<=n){
                currNum = currNum*10;
            }
            else{
                while(currNum%10 == 9 || currNum == n){
                    currNum = currNum/10;
                }
                currNum++;
            }
        }
        return res;
    }



    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the nummber");
        int n = sc.nextInt();

        System.out.println(recLexicalOrder(n));
    }
}
