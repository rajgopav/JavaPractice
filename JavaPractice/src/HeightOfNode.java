public class HeightOfNode {

	public static void main(String[] args) {
		NodeHeight root = new NodeHeight(5);
		root.left = new NodeHeight(10);
		root.right = new NodeHeight(15);
		root.left.left = new NodeHeight(20);		
		NodeHeight x = new NodeHeight(25);
		root.left.right = x;
		root.left.right.left = new NodeHeight(35);		
		System.out.println("Height of the Node " + x.data + " is : " +  getNodeHeight(root, x, 1));
	}

	private static int getNodeHeight(NodeHeight root, NodeHeight x, int height) {
		if(root == null) return 0;
		if(root == x) return height;
		
		int level = getNodeHeight(root.left, x , height + 1);
		if(level != 0) return level;
		return getNodeHeight(root.right, x , height + 1);
	}
}

class NodeHeight{
	int data;
	NodeHeight left;
	NodeHeight right;
	
	public NodeHeight(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
