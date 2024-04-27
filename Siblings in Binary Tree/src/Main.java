import java.util.*;
public class Main {
	ArrayList<Integer> siblings = new ArrayList<>();

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt = m.new BinaryTree();
		bt.sibling();
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public void sibling() {
			this.sibling(this.root);
		}

		private void sibling(Node node) {
			height(node);
			for(int i=siblings.size()-1;i>=0;i--){
				System.out.print(siblings.get(i)+" ");
			}
		}	
		private int height(Node root){
			if(root == null ) return 0;

			int left = height(root.left);
			int right = height(root.right);

			if(left == 0  && right!=0) siblings.add(root.right.data);
			if(right == 0 && left!=0 ) siblings.add(root.left.data); 

			return 1 + Math.max(left,right);

		}
	
	}

}
