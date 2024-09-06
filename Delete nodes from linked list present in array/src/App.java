import java.util.HashSet;
import java.util.Scanner;

public class App {

    public static ListNode modifiedList(int[] nums, ListNode head) {
        if(nums.length==0 || head==null){
            return head;
        }
        HashSet<Integer> set = new HashSet<>(); 
        ListNode prev = new ListNode(0);
        ListNode curr = head;
        prev.next = curr;

        for(int num : nums){
            set.add(num);
        }

        while(curr!=null){
            int val = curr.val;
            if(set.contains(val)){
                if(curr==head){
                    head = head.next;
                }
                prev.next = curr.next;
                curr=curr.next;
                // map.put(val,map.get(val)-1);
                continue;
            }
            prev = curr;
            curr = curr.next;
        }   

        return head;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the linked list");
        int n = sc.nextInt();

        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        System.out.println("Enter the elements of the linked list");
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            ListNode node = new ListNode(val);
            prev.next = node;
            prev = node;
        }

        System.out.println("Enter the length of the array");
        int na = sc.nextInt();
        int[] arr = new int[na];

        System.out.println("Enter the elements of the array");
        for(int i=0;i<na;i++){
            arr[i] = sc.nextInt();
        }

        ListNode newList = modifiedList(arr, dummy.next);

        ListNode temp= newList;
        System.out.println("Elements of new linked list are");
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

    }
}
