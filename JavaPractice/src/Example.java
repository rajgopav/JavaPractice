import java.util.Arrays;
import java.util.Scanner;

public class Example {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of the array: ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the array elements : ");
		for(int i = 0;i < size; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Enter k: ");
		int k = in.nextInt();
		Arrays.sort(arr);
		int numofPairs = pairs(arr,size,k);
		System.out.println(numofPairs);
	}
	
	static int pairs(int[] arr, int n,int k) {
		int count = 0;
	    for (int i = 0; i < n; i++)
	    {       
	        // See if there is a pair of this picked element
	        for (int j = i+1; j < n; j++)
	            if (arr[i] - arr[j] == k || arr[j] - arr[i] == k )
	                  count++;
	    }
	    return count;
	}
}
