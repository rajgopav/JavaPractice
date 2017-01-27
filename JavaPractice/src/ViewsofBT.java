
public class ViewsofBT {
	public static int leftCurrentView = 0;
	public static int rightCurrentView = 0;
	
	public static void main(String[] args) {
		NodeView root = new NodeView(5);
		root.left = new NodeView(10);
		root.right = new NodeView(15);
		root.left.left = new NodeView(20);
		root.left.right = new NodeView(25);
		root.right.left = new NodeView(30);
		root.right.right = new NodeView(35);
		root.left.right.right = new NodeView(45);
		
		ViewsofBT vbt = new ViewsofBT();
		//vbt.leftRecurView(root, 1);
		vbt.rightRecurView(root, 1);
	}
	
	public void leftRecurView(NodeView root, int level) {
		if(root == null) return;
		if(leftCurrentView < level) {
			System.out.print(root.data + " ");
			leftCurrentView = level;
		}
		leftRecurView(root.left, level + 1);
		leftRecurView(root.right, level + 1);
	}
	
	public void rightRecurView(NodeView root, int level) {
		if(root == null) return;
		if(rightCurrentView < level) {
			System.out.print(root.data + " ");
			rightCurrentView = level;
		}
		rightRecurView(root.right, level + 1);
		rightRecurView(root.left, level + 1);
	}
}

class NodeView {
	int data;
	NodeView left;
	NodeView right;
	
	public NodeView(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
