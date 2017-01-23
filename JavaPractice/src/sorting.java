import java.util.Arrays;

public class sorting {
	
	final static int INVALID_NUM = 0;
	
	public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length-1);
    }
 
    private static void mergeSort(int[] array, int start, int end) {
        if(start < end) {
            int mid = (start+end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            merge(array, start, mid, end);
        }
    }
	
	private static void merge(int[] array, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
         
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];
         
        for(int i = 0; i < n1; i++) {
            temp1[i] = array[start+i];
        }
         
        for(int j = 0; j < n2; j++) {
            temp2[j] = array[mid+j+1];
        }
         
        int i = 0, j = 0, k = start;
        while(i < n1 && j < n2) {
            if(temp1[i] <= temp2[j]) {
                array[k] = temp1[i];
                i++;
            } else {
                array[k] = temp2[j];
                j++;
            }
            k++;
        }
         
        while(i < n1) {
            array[k] = temp1[i];
            i++;
            k++;
        }
        while(j < n2) {
            array[k] = temp2[j];
            j++;
            k++;
        }
    }
	
	public static void rotateArrayNaive(int arr[], int k) {
		
		if(k < 0)
			throw new IllegalArgumentException("K cannot be negative");
		
		if(arr == null || arr.length < 2) {
			return;
		}
		
		int n = arr.length;
		if(k > n) k = k % n;
		for(int i = 0; i < k; i++) 
			rotateArrayOnce(arr);
	}
	
	public static void rotateArrayOnce(int arr[]) {
		int temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length-1] = temp;
	}
	
	public static void rotateArrayReverse(int arr[], int k) {
		
		if(k < 0)
			throw new IllegalArgumentException("K cannot be negative");
		
		if(arr == null || arr.length < 2) {
			return;
		}
		
		int n = arr.length;
		if(k > n) k = k % n;
		reverseArray(arr, 0, k - 1);
		reverseArray(arr, k, n - 1);
		reverseArray(arr, 0, n - 1);
	}
	
	private static void reverseArray(int arr[], int start, int end) {
		while(start < end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}
	
	@SuppressWarnings("unused")
	private static void testArrayRotationNaive() {
		int arr[] = {1,2,3,4,5};
		int k = 8;
		System.out.println("Original Array: ");
		System.out.println(Arrays.toString(arr));
		rotateArrayNaive(arr, k);
		System.out.println("After Array Rotation: ");
		System.out.println(Arrays.toString(arr));
	}
	
	@SuppressWarnings("unused")
	private static void testArrayRotationReverse() {
		int arr[] = {1,2,3,4,5};
		int k = 8;
		System.out.println("Original Array: ");
		System.out.println(Arrays.toString(arr));
		rotateArrayReverse(arr, k);
		System.out.println("After Array Rotation: ");
		System.out.println(Arrays.toString(arr));
	}
	
	public static int fibonacci(int n) {
		if(n < 0)
			throw new IllegalArgumentException("The value of N cannot be negative");
		
		if(n == 0 || n == 1)
			return n;
		
		return getfibonacci(n - 1) + getfibonacci(n - 2);
	}
	
	public static int getfibonacci(int n) {
		if(n < 0)
			throw new IllegalArgumentException("The value of N cannot be negative");
		
		if(n == 0 || n == 1)
			return n;
		
		int a = 0, b = 1;
		int c = a + b;
		for(int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	
	public static void inplaceMergeArrays(int arrA[], int arrB[]) {
		int validPlace = arrA.length - 1;
		for(int i = arrA.length - 1; i >=0; i--) {
			if(arrA[i] != INVALID_NUM) {
				arrA[validPlace] = arrA[i];
				validPlace--;
			}
		}
			int i = validPlace + 1;
			int j = 0, k = 0;
			while((i < arrA.length) && (j < arrB.length)) {
				if(arrA[i] < arrB[j]) {
					arrA[k++] = arrA[i++];
				} else {
					arrA[k++] = arrB[j++];
				}
			}
			
			while(j < arrB.length)
				arrA[k++] = arrB[j++];
 	}
	
	
	public static void main(String[] args) {
        //int[] array = {12, 35, 87, 26, 9, 28, 7};
        //mergeSort(array);
        //System.out.println(Arrays.toString(array));
        
        //testArrayRotationNaive();
        //testArrayRotationReverse();
		//System.out.println(fibonacci(6));
		int[] arrayA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM};
        int[] arrayB = {-1, 2, 6, 12};
         
        inplaceMergeArrays(arrayA, arrayB);
        for (int i = 0;  i < arrayA.length; i++)
        {
            System.out.print(arrayA[i] + ", ");
        }
    }
}
