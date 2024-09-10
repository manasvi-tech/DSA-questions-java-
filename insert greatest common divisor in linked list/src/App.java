import java.util.Scanner;

public class App {
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        // If the list contains only one node, return the head as no insertion is needed
        if (head.next == null) return head;

        // Initialize pointers to traverse the list
        ListNode node1 = head;
        ListNode node2 = head.next;

        // Traverse the linked list
        while (node2 != null) {
            int gcdValue = calculateGCD(node1.val, node2.val);
            ListNode gcdNode = new ListNode(gcdValue);

            // Insert the GCD node between node1 and node2
            node1.next = gcdNode;
            gcdNode.next = node2;

            // Move to the next pair of nodes
            node1 = node2;
            node2 = node2.next;
        }

        return head;
    }

    // Helper method to calculate the greatest common divisor using the Euclidean algorithm
    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the linked list");
        int n = sc.nextInt();

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        System.out.println("Enter the elements of the linked list");
        for(int i=0;i<n;i++){
            int val = sc.nextInt();

            ListNode newNode = new ListNode(val);

            temp.next = newNode;
            temp = newNode;
        }
        
        ListNode head = insertGreatestCommonDivisors(dummy.next);

        ListNode curr = head;

        while(curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
