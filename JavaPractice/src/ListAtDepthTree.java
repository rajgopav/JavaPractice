import java.util.*;

public class ListAtDepthTree {
	static ArrayList<ListNode> al = new ArrayList<ListNode>();
	
	public static void main(String[] args) {
		ListTreeNode root = new ListTreeNode(5);
		root.left = new ListTreeNode(10);
		root.right = new ListTreeNode(15);
		root.left.left = new ListTreeNode(20);
		root.left.right = new ListTreeNode(25);
		root.right.left = new ListTreeNode(30);
		root.right.right = new ListTreeNode(35);
		
		levelOrderQueue(root);
	}

	private static void levelOrderQueue(ListTreeNode root) {
		if(root == null) return;
		Queue<ListTreeNode> q = new LinkedList<ListTreeNode>();
		int levelNodes = 0;
		q.add(root);
		while(!q.isEmpty()) {
			levelNodes = q.size();
			ListNode head = null;
			ListNode curr = null;
			while(levelNodes > 0) {
				ListTreeNode current = q.poll();
				ListNode node = new ListNode(current.data);
				if(head == null) {
					head = node;
					curr = node;
				} else {
					curr.next = node;
					curr = curr.next;
				}
				if(current.left != null) q.add(current.left);
				if(current.right != null) q.add(current.right);
				levelNodes--;
			}
			al.add(head);
		}
		display(al);
	}
	
	public static void display(ArrayList<ListNode> al) {
		Iterator<ListNode> it = al.iterator();
		while(it.hasNext()) {
			ListNode node = it.next();
			while(node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
			System.out.println(" ");
		}		
	}
}

class ListTreeNode {
	int data;
	ListTreeNode left;
	ListTreeNode right;
	
	public ListTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class ListNode {
	int data;
	ListNode next;
	
	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}
