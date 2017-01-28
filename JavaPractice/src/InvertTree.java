import java.util.*;

public class InvertTree {

	public static void main(String[] args) {
		InvertTree it = new InvertTree();
		
		InvertNode root = new InvertNode(5);
		root.left = new InvertNode (4);
		root.right = new InvertNode (8);
		
		root.left.left = new InvertNode (11);
		root.left.left.left = new InvertNode (7);
		root.left.left = new InvertNode (2);
		
		root.right.left = new InvertNode (13);
		root.right.right = new InvertNode (4);
		root.right.right.right = new InvertNode (1);
		
		System.out.print("Before Inversion: ");it.inOrderRecursive(root);
		System.out.println();
		System.out.print("After Inversion: ");
		root = it.invertTreeRecursive(root);
		List<Integer> result = it.inOrder(root);
		for(int i : result)
			System.out.print(i + " ");
		
		boolean bool = it.hasPathSum(root, 22);
		System.out.println("Does the sum 22 exists: " + bool);
	} 
	
	public InvertNode invertTreeRecursive(InvertNode root) {
		if(root != null) {
			helper(root);
		}
		return root;
	}
	
	public void helper(InvertNode root) {
		InvertNode  temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if(root.left != null) {
			helper(root.left);
		}
		
		if(root.right != null) {
			helper(root.right);
		}
	}
	
	public List<Integer> inOrder(InvertNode root) {
		List<Integer> result = new ArrayList<Integer>();
	    if(root==null)
	        return result;
	    Stack<InvertNode> stack = new Stack<InvertNode>();
	    stack.push(root);
	 
	    while(!stack.isEmpty()){
	    	InvertNode top = stack.peek();
	        if(top.left!=null){
	            stack.push(top.left);
	            top.left=null;
	        }else{
	            result.add(top.data);
	            stack.pop();
	            if(top.right!=null){
	                stack.push(top.right);
	            }
	        }
	    }
	 
	    return result;
	}
	
	public void inOrderRecursive(InvertNode root) {
		if(root != null) {
			inOrderRecursive(root.left);
			System.out.print(root.data + " ");
			inOrderRecursive(root.right);
		}
	}
	
	public int kthSmallest(InvertNode root, int k) {
		int result = 0;
		Stack<InvertNode> st = new Stack<InvertNode>();
		InvertNode current = root;
		while(!st.isEmpty() || current != null) {
			if(current != null) {
				st.push(current);
				current = current.left;
			} else {
				InvertNode top = st.pop();
				k--;
				
				if(k==0)
					result = top.data;
				current = top.right;
			}
		}
		return result;
	}
	
	public boolean hasPathSum(InvertNode root, int sum) {
		if(root == null) return false;
		
		LinkedList<InvertNode> nodes = new LinkedList<InvertNode>();
		LinkedList<Integer> values = new LinkedList<Integer>();
		
		nodes.add(root);
		values.add(root.data);
		while(!nodes.isEmpty()) {
			InvertNode node = nodes.poll();
			int value = values.poll();
			
			if(node.left == null && node.right == null && value == sum) 
				return true;
			
			if(node.left != null) { 
				nodes.add(node.left);
				values.add(value + node.left.data);
			}
				
			if(node.right != null) {
				nodes.add(node.right);
				values.add(value + node.right.data);
			}
		}
		return false;
	}
}

class InvertNode {
	int data;
	InvertNode left;
	InvertNode right;
	
	public InvertNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
