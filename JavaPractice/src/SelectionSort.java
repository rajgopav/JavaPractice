import java.util.Arrays;

public class SelectionSort {
	public static void selectionSort(int arr[]) {
		int n = arr.length;

		for(int i = 0; i < n; i++) {
			int minIndex = i;
			for(int j = i + 1; j < n; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			if( i!= minIndex && arr[i] != arr[minIndex])
				swap(arr, i, minIndex);
		}		
	}

	private static void swap(int[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
	}

	public static void main(String[] args) {
		int[] array = {12, 35, 87, 26, 9, 28, 7}; 
        selectionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
	}
}
