import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        CircularDeque cd = new CircularDeque(3);

        System.out.println(cd.insertLast(1));
        System.out.println(cd.insertLast(2));

        System.out.println(cd.insertFront(3));
        System.out.println(cd.insertFront(4));
        
        System.out.println(cd.getRear());
        System.out.println(cd.isFull());

        System.out.println(cd.deleteLast());

        System.out.println(cd.insertFront(4));
        System.out.println(cd.getFront());
    }
}
