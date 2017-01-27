
public class BSTImplementation {
	
	public static void main(String[] args) {
		BST bt = new BST();
		bt.insert(3);bt.insert(8);bt.insert(1);bt.insert(4);bt.insert(6);
		bt.insert(2);bt.insert(10);bt.insert(9);bt.insert(20);bt.insert(25);
		bt.insert(15);bt.insert(16);
		System.out.println("Original Tree is: ");
		bt.display(BST.root);
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + bt.find(4));
		System.out.println("Delete Node with no children (2) : " + bt.delete(2));		
		bt.display(BST.root);
		System.out.println("\n Delete Node with one child (4) : " + bt.delete(4));		
		bt.display(BST.root);
	}
}

class NodeBST{
	int data;
	NodeBST left;
	NodeBST right;
	
	public NodeBST(int id) {
		this.data = id;
		left = null;
		right = null;
	}
}

class BST {
	public static NodeBST root;
	
	public BST() {
		root = null;
	}
	
	public void insert(int data) {
		NodeBST newNode = new NodeBST(data);
		if(root == null) {
			root = newNode;
			return;
		}
		
		NodeBST current = root;
		NodeBST parent = null;
		while(true) {
			parent = current;
			if(data < current.data) {
				current = current.left;
				if(current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if(current == null) {
					 parent.right = newNode;
					 return;
				}
			}
		}
	}
	
	public boolean delete(int data) {
		NodeBST current = root;
		NodeBST parent = root;
		boolean isLeftChild = false;
		
		while(current.data != data)
		{
			parent = current;
			if(data < current.data) {
				isLeftChild = true;
				current = current.left;
			} else if(data > current.data) {
				isLeftChild = false;
				current = current.right;
			}
			
			if(current == null) 
				return false;
		}
		
		if(current.left == null && current.right == null) {
			if(current == root) {
				root = null;
			} else if(isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (current.right == null) {
			if(current == root) {
				root = current.left;
			} else if(isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if(current.left == null) {
			if(current == root) {
				root = current.right;
			} else if(isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		}
		
		return true;
	}
	
	public boolean find(int data){
		NodeBST current = root;
		while(current != null) {
			if(current.data == data)
				return true;
			else if(data < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return false;
	}
	
	public void display(NodeBST root) {
		if(root != null) {
			display(root.left);
			System.out.print(root.data + " ");
			display(root.right);
		}
	}
}