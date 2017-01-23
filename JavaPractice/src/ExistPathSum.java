
public class ExistPathSum {
	
	String path;
	
	static class NodeSum {
		int data;
		NodeSum left, right;

		public NodeSum(int data) {
			this.data = data;
		}
	}
	public void hasPath(NodeSum root, int sum, String path) {
		if(root != null) {
			if(root.data > sum)
				return;
			else {
				path += " " + root.data;
				sum -= root.data;
			
				if(sum == 0)
					System.out.println(path);
			
				hasPath(root.left, sum, path);
				hasPath(root.right, sum, path);
			}
		}
	}
	
	public static void main(String[] args) {
		NodeSum root = new NodeSum(1);
		root.left = new NodeSum(2);
		root.right = new NodeSum(3);
		root.left.left = new NodeSum(7);
		root.left.right = new NodeSum(5);
		root.right.left = new NodeSum(6);
		root.right.right = new NodeSum(7);
		
		ExistPathSum i = new ExistPathSum();
		i.hasPath(root, 10, "");
	}
}
