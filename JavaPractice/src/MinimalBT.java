
public class MinimalBT {
	public static void main(String[] args) {
		int arr [] = {1, 2, 3, 4, 5, 6};
		NodeMin root = constructMinimalBT(arr, 0, arr.length -1);
		display(root);
	}
	
	public static NodeMin constructMinimalBT(int arr[], int low, int high) {
		if(low > high)
			return null;
		
		int mid = (low + high) / 2;
		NodeMin root = new NodeMin(arr[mid]);
		root.left = constructMinimalBT(arr, low, mid - 1);
		root.right = constructMinimalBT(arr, mid + 1, high);
		
		return root;
	}
	
	public static void display(NodeMin root) {
		if(root != null) {
			System.out.print(root.data + " ");
			display(root.left);
			display(root.right);
		}
	}
}

class NodeMin {
	int data;
	NodeMin left;
	NodeMin right;
	
	public NodeMin(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}