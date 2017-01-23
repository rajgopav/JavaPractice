import java.util.*;

class Node {
	private int data;
	private Node left;
	private Node right;
	
	public static Node newNode(int data) {
		Node n = new Node();
		n.data = data;
		n.left = null;
		n.right = null;
		return n;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

public class BinaryInsertion {
	
	public Node insertNode(int data, Node root) {
		Node newNode = Node.newNode(data);
		
		if(root == null) {
			root = newNode;
			return root;
		}
		
		Node parent = null, current = root;
		
		while(current != null) {
			parent = current;
			if(current.getData() < data) {
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}
		
		if(parent.getData() < data) {
			parent.setRight(newNode);
		} else {
			parent.setLeft(newNode);
		}
		return root;
	}
	
	public boolean sameTree(Node root1, Node root2) {
		if((root1 == null && root2 == null)) return true;
		else if((root1 == null || root2 == null)) return false;
		
		return (root1.getData() == root2.getData() && sameTree(root1.getLeft(),root2.getLeft()) && sameTree(root1.getRight(),root2.getRight()));
	}
	
	public int size(Node root) {
		if(root == null) return 0;
		
		int leftSize = size(root.getLeft());
		int rightSize = size(root.getRight());
		return leftSize + rightSize + 1;
	}
	
	public int height(Node root) {
		if(root == null) return 0;
		
		int leftSize = height(root.getLeft());
		int rightSize = height(root.getRight());
		return Math.max(leftSize, rightSize) + 1;
	}
	
	public boolean printPath(Node root, int sum, List<Node> result) {
		if(root == null) return false;
		
		if(root.getLeft() == null && root.getRight() == null) {
			if(root.getData() == sum) {
				result.add(root);
				return true;
			} else { return false; }
		}
		
		if(printPath(root.getLeft(), sum - root.getData(), result) || printPath(root.getRight(), sum - root.getData(), result)) {
			result.add(root);
			return true;
		} else { return false; }
	}
	
	public boolean isBST(Node root, int min, int max) {
		if(root == null) return true;
		
		if(root.getData() < min || root.getData() > max) return false;
		return isBST(root.getLeft(), min, root.getData()) && isBST(root.getRight(), root.getData(), max);
	}
	
	public void levelOrderTraversal(Node root) {
		Node current = root;
		if(	root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(current);
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current.getData() + "->");
			if(current.getLeft() != null) queue.add(current.getLeft());
			if(current.getRight() != null) queue.add(current.getRight());
		}
	}
	
	public void itertaivePostOrderTraversal(Node root) {
		Node current = root;
		if(root == null) return;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(current);
		while(!s1.isEmpty()) {
			current = s1.pop();
			s2.add(current);
			if(current.getLeft() != null) s1.add(current.getLeft());
			if(current.getRight() != null) s1.add(current.getRight());
		}
		
		while(!s2.isEmpty()) {
			Node print = s2.pop();
			System.out.print(print.getData() + " ");
		}
	}
	
	public static int sum = 0;
	public void convertBSTToGreaterSum(Node root) {
		if(root != null) {
			convertBSTToGreaterSum(root.getRight());
			int temp = root.getData();
			root.setData(sum);
			sum = sum + temp;
			convertBSTToGreaterSum(root.getLeft());
		} else return;
	}
	
	public void inorder(Node root){
		if(root!=null){
			inorder(root.getLeft());
			System.out.print("  " + root.getData());
			inorder(root.getRight());
		}
	}
	
	static Node newNode;
	public int sumBST(Node root) {
		if(root != null) {
			int left = sumBST(root.getLeft());
			int right = sumBST(root.getRight());
			int retData = root.getData() + left + right;
			root.setData(left + right);
			newNode = root;
			return retData;
		}
		return 0;
	}
	
	public Node commonAncestor(Node root, Node n1, Node n2) {
		if(root == null) {
			return null;
		} else {
			if(root.getData() == n1.getData() || root.getData() == n2.getData())
				return root;
			
			Node left = commonAncestor(root.getLeft(), n1, n2);
			Node right = commonAncestor(root.getRight(), n1, n2);
			
			if(left != null && right != null)
				return root;
			
			if(left != null)
				return left;
			else if(right != null)
				return right;
		}
		return null;
	}
	
	public static void main(String[] args) {
		BinaryInsertion tree = new BinaryInsertion();
		
		Node head = null;
		head = tree.insertNode(5, head);
        head = tree.insertNode(-1, head);
        head = tree.insertNode(3, head);
        head = tree.insertNode(-2, head);
        head = tree.insertNode(4, head);
        head = tree.insertNode(-6, head);
        head = tree.insertNode(10, head);
        
        System.out.println("Level Order Traversal of the Tree is: "); tree.levelOrderTraversal(head);
        System.out.println();
        System.out.println("Iterative Post Order Traversal of the Tree is: "); tree.itertaivePostOrderTraversal(head);
        List<Node> result = new ArrayList<>();
        boolean bool = tree.printPath(head, 22, result);
        if(bool){
            result.forEach(node -> System.out.print(node.getData() + " "));
            System.out.println();
        }else{
            System.out.println("No path for sum: " + 22); 
        }
        
        int size = tree.size(head);
        System.out.println("Size of the Binary Search Tree is: " + size);
        
        int height = tree.height(head);
        System.out.println("Height of the Binary Search Tree is: " + height);
        
        boolean bool1 = tree.isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(bool1){
        	System.out.println("Binary Search Tree");
        }else{
            System.out.println("Not a Binay Search Tree"); 
        }
        tree.inorder(head);
        //System.out.println("");
        //tree.convertBSTToGreaterSum(head);
        //tree.inorder(head);
	}
}
