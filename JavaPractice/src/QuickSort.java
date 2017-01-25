
public class QuickSort {
	private int arr[];
	
	public QuickSort(int a[]) {
		this.arr = a;
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

	private void quickS(int i, int j) {
		// TODO Auto-generated method stub
		
	}
 
	private void display() {
		// TODO Auto-generated method stub
		
	}
}
