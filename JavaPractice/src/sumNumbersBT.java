
public class sumNumbersBT {
	public static void main(String[] args) {

	}
	
	public int sumNumbers(sumNode root) {
		if(root == null)
			return 0;
		
		return dfs(root, 0 , 0); 
	}
	
	public int dfs(sumNode root, int num, int sum) {
		if(root == null)
			return sum;
		
		num = num * 10 + root.data;
		
		if(root.left == null && root.right == null) {
			sum += num;
			return sum;
		}
		
		sum = dfs(root.left, num, sum) + dfs(root.right, num, sum);
		return sum;
	}
}

class sumNode {
	int data;
	sumNode left;
	sumNode right;

	public sumNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
