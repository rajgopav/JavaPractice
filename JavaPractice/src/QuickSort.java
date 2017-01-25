
public class QuickSort {
	private int arrA[];
	
	public QuickSort(int a[]) {
		this.arrA = a;
	}
	
	public static void main(String[] args) {
		int a[] = { 6, 2, 4, 12, 10 };
		QuickSort i = new QuickSort(a);
		System.out.print("UnSorted : ");
		i.display();
		i.quickS(0, a.length - 1);
		System.out.println("");
		System.out.print("Quick Sorted : ");
		i.display();
	}

	private void quickS(int low, int high) {
		int mid = (low + high) / 2;
		int left = low;
		int right = high;
		int pivot = arrA[mid]; 
		while (left <= right) {
			while (arrA[left] < pivot)
				left++;
			while (arrA[right] > pivot)
				right--;
			
			if (left <= right) {
				int temp = arrA[left];
				arrA[left] = arrA[right];
				arrA[right] = temp;
				left++;
				right--;
			}
		}
		
		if (low < right)
			quickS(low, right);
		if (left < high)
			quickS(left, high);
	}
 
	private void display() {
		for(int i = 0; i < arrA.length; i++) 
			System.out.print(arrA[i] + " ");
	}
}
