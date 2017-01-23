
public class BinarySearch {

	public static int binarySearch(int arr[], int num) {
		if(arr == null || arr.length == 0)
			return -1;
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = ( start + end ) / 2;
			if(arr[mid] == num) {
				return mid;
			} else if( num < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {21, 32, 43, 74, 75, 86, 97, 108, 149};
		int num = 21;
		int index = binarySearch(arr, num);
		System.out.println("Element " + num + (index >= 0 ? (" is found at index " + index) : " not found "));
	}
}
