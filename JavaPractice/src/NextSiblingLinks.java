public class NextSiblingLinks {
	static class SiblingNode {
		int data;
		SiblingNode left;
		SiblingNode right;
		SiblingNode nextSibling;
		
		public SiblingNode(int data) {
			this.data = data;
		}
	}
	
	public SiblingNode provideSibling(SiblingNode root) {
		if(root != null) {
			if(root.left != null) {
				root.left.nextSibling = root.right;
			}
			
			if(root.right != null && root.nextSibling != null ) {
				root.right.nextSibling = root.nextSibling.left;
			}
			provideSibling(root.left);
			provideSibling(root.right);
			return root;	
		}
		return null;
	}
	
	public void printLevel(SiblingNode n) {
		while (n != null) {
			System.out.print(" " + n.data);
			n = n.nextSibling;
		}
	}
	
	public static void main(String[] args) {
		SiblingNode root = new SiblingNode(1);
		root.left = new SiblingNode(2);
		root.right = new SiblingNode(3);
		root.left.left = new SiblingNode(4);
		root.left.right = new SiblingNode(5);
		root.right.left = new SiblingNode(6);
		root.right.right = new SiblingNode(7);

		NextSiblingLinks i = new NextSiblingLinks();
		SiblingNode x = i.provideSibling(root);
		i.printLevel(x);
		System.out.println("");
		i.printLevel(x.left);
		System.out.println("");
		i.printLevel(x.left.left);
	}
}
