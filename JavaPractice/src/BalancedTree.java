import java.util.*;

public class BalancedTree {
	public static int maxWidth = 0;
	public static int paths[] = new int[20];
	
	public static void main(String[] args) {
		BalancedNode root = new BalancedNode(5);
		root.left = new BalancedNode(10);
		root.right = new BalancedNode(15);
		root.left.left = new BalancedNode(20);
		root.left.right = new BalancedNode(25);
		root.right.left = new BalancedNode(30);
		root.right.right = new BalancedNode(35);		
		System.out.println(" Is Tree Balanced : " + checkBalance(root));
		root.right.right.right = new BalancedNode (40);
		root.right.right.right.right = new BalancedNode (45);
		
		System.out.println(" Is Tree Balanced : " + checkBalance(root));
		System.out.println(" Width of tree : " + widthofBT(root));
		printPaths(root, paths, 0);
	}
	
	public static boolean checkBalance(BalancedNode root) {
		int balance = balance(root);
		if(balance > 0) {
			return true;
		} else 
			return false;
	}
	
	public static int balance(BalancedNode root) {
		if(root == null) return 0;
		int leftHeight = balance(root.left);
		if(leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = balance(root.right);
		if(rightHeight == -1) {
			return -1;
		}
		
		int diff = leftHeight - rightHeight;
		if(Math.abs(diff) > 1)
			return -1;
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public static void printPaths(BalancedNode root, int pathArray[], int length) {
		if(root == null)
			return;
		pathArray[length++] = root.data;
		if(root.left == null && root.right == null) {
			printPaths(pathArray, length);
		} else {
			printPaths(root.left, pathArray, length);
			printPaths(root.right, pathArray, length);
		}
	}
	
	private static void  printPaths(int arr[], int length) {
		for(int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static int widthofBT(BalancedNode root) {
		if(root == null)
			return 0;
		int levelNodes = 0;
		Queue<BalancedNode> q = new LinkedList<BalancedNode>();
		q.add(root);
		while(!q.isEmpty()) {
			levelNodes = q.size();
			if(levelNodes > maxWidth)
				maxWidth = levelNodes;
			while(levelNodes > 0) {
				BalancedNode current = q.poll();
				if(current.left != null) q.add(current.left);
				if(current.right != null) q.add(current.right);
				levelNodes--;
			}
		}
		return maxWidth;
	}
	
	
}

class BalancedNode{
	int data;
	BalancedNode left;
	BalancedNode right;
	
	public BalancedNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}