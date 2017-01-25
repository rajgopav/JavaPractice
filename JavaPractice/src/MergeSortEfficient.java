
public class MergeSortEfficient {
	
	private int arrSize;
	private static int inputArr[];
	private static int auxArr[];
	
	public MergeSortEfficient(int arr[]) {
		inputArr = arr;
		arrSize = inputArr.length;
		auxArr = new int[arrSize];
	}
	
	public int[] mergeSort() {
		sort(0, arrSize -1);
		return inputArr;
	}
	
	private void sort(int low, int high) {
		if(low < high) {
			int mid = low+((high-low))/2;
			sort(low, mid);
			sort(mid + 1, high);
			merge(low, mid , high);
		}
	}

	private void merge(int low, int mid, int high) {
		for(int i = low; i <= high; i++) {
			auxArr[i] = inputArr[i];
		}
		
		int i = low;
		int j = mid + 1;
		int k = low;
		
		while(i <= mid && j <= high) {
			if(auxArr[i] < auxArr[j]) {
				inputArr[k] = auxArr[i];
				i++;
			} else {
				inputArr[k] = auxArr[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			inputArr[k] = auxArr[i];
			i++; k++;
		}
	}

	private void displayArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}	
	}
	
	public static void main(String[] args) {
		int arr [] = {2,1,6,3,9,4,5,10};
		MergeSortEfficient ms = new MergeSortEfficient(arr);
		int arr1 [] = ms.mergeSort();
		ms.displayArray(arr1);
	}

}
