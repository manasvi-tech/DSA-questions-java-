import java.util.*;
public class A {

	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
			next = null;
		}
	}

	public static ListNode reverse(ListNode head){
		ListNode prev = null;
		ListNode current = head;
		ListNode further = head;
		while(further!=null){
			further = further.next;
			current.next = prev;
			prev = current;
			current = further;
		}
		return prev;
	}

	public static ListNode sum(ListNode head1, ListNode head2){
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		int carry = 0;

		while(head1!=null || head2!=null){
			int a = (head1!=null) ? head1.val : 0;
			int b = (head2!=null) ? head2.val : 0;
			int sum = a+b+carry;
			ListNode newNode = new ListNode(sum%10);
			curr.next = newNode;
			curr = newNode;
			carry = sum/10;
			if(head1!=null){
				head1 = head1.next;
			}
			if(head2!=null){
				head2 = head2.next;
			}
		}		
		if(carry!=0){
			curr.next = new ListNode(carry);
		}
		return reverse(dummy.next);

	}

	public static void print(ListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		ListNode head1=null;
		ListNode tail1 = null;
		ListNode head2 = null;
		ListNode tail2 = null;

		for(int i =0;i<n1;i++){
			int val = sc.nextInt();
			ListNode newNode = new ListNode(val);
			if(head1==null){
				head1 = newNode;
				tail1 = newNode;
			}
			else{
				tail1.next = newNode;
				tail1 = newNode;
			}
		}

		for(int i =0;i<n2;i++){
			int val = sc.nextInt();
			ListNode newNode = new ListNode(val);
			if(head2==null){
				head2 = newNode;
				tail2 = newNode;
			}
			else{
				tail2.next = newNode;
				tail2 = newNode;
			}
		}
		print(sum(reverse(head2),reverse(head1)));

    }
}