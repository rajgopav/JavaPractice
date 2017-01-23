import java.util.*;

public class Beginner {

	public void preOrderTraversal(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode temp = root;
		
		while(true) {
			while(temp != null) {
				System.out.print(temp.data + " ");
				s.push(temp);
				temp = temp.left;
			}

			if(s.isEmpty()) {
				return;
			}
		
			temp = s.pop();
			temp = temp.right;
		}
	}
	
	public void inOrderTraversal(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode temp = root;
		
		while(true) {
			while(temp != null) {
				s.push(temp);
				temp = temp.left;
			}
			
			if(s.isEmpty()) {
				return;
			}
		
			temp = s.pop();
			System.out.print(temp.data + " ");
			temp = temp.right;
		}
	}
	
	public boolean searchTreeRecursion(BinaryTreeNode root, int data) {
		BinaryTreeNode temp = root;
		if(temp == null) 
			return false;
		else {
			if(temp.data == data) {
				return true;
			}
			return searchTreeRecursion(temp.left, data) || searchTreeRecursion(temp.right, data); 
		}
	}
	
	public boolean searchTreeIteration(BinaryTreeNode root, int data) {
		BinaryTreeNode temp = root;
		if(temp == null) 
			return false;
		else{
			Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			queue.add(temp);
			while(!queue.isEmpty()) {
				BinaryTreeNode node = queue.poll();
				if(node.data == data)
					return true;
				
				if(node.left != null)
					queue.add(node.left);
				
				if(node.right != null)
					queue.add(node.right);
			}
		}
		return false;
	}
	
	public void findKthElement(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < arr.length; i++)
			pq.add(arr[i]);
		
		int n = -1;
		while(k > 0) {
			n = pq.poll();
			k--;
		}
		System.out.println("The 4th largest element is " + n);
	}
	
	public void DFS(BinaryTreeNode root) {
		if(root == null) return;
		BinaryTreeNode temp = root;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(temp);
		while(!stack.isEmpty()) {
				BinaryTreeNode node = stack.pop();
				if(node.right != null) stack.push(node.right);
				if(node.left != null) stack.push(node.left);
				System.out.print(node.data + " ");	
		}
	}
	
	public void secondLargestElement(int arr[]) {
		int fstNo = arr[0];
		int sndNo = -1;
		
		for(int i = 1; i < arr.length; i++) {
			if(fstNo < arr[i]) {
				sndNo = fstNo;
				fstNo = arr[i];
			} else if(sndNo < arr[i]) {
				sndNo = arr[i];
			}
		}
		System.out.print("The second largest number is: " + sndNo);	
	}
	
	public void sortLast(ArrayList<String> al) {
		Collections.sort(al, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String arr[] = o1.split(" ");
				String arr1[] = o2.split(" ");
				String lastName1 = arr[1];
				String lastName2 = arr1[1];
				if(lastName1.compareTo(lastName2) > 0 ) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		System.out.println(al);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		
		Beginner be = new Beginner();
		be.preOrderTraversal(root);
		System.out.println();
		be.inOrderTraversal(root);
		System.out.println();
		
		boolean result = be.searchTreeRecursion(root, 3);
		System.out.println("Does 3 exit in the tree:" + result);
		
		result = be.searchTreeIteration(root, 3);
		System.out.println("Does 3 exit in the tree:" + result);
		
		be.DFS(root);
		System.out.println();
		
		int[] A = { 1, 2, 10, 20, 40, 32, 44, 51, 6 };
		be.findKthElement(A, 4);
		
		be.secondLargestElement(A);
		System.out.println();
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Daenerys Targaryen");
		al.add("Jon Show");
		al.add("Tyrion Lannister");
		al.add("Joffrey Baratheon");
		be.sortLast(al);
	}
}

class BinaryTreeNode{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(int data) {
		this.data = data;
	}
}