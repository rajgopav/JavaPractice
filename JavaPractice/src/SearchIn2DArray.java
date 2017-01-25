public class SearchIn2DArray {

	public static void main(String[] args) {
		int arr[][] = { {10, 20, 30, 40},
                		{15, 25, 35, 45},
                		{27, 29, 37, 48},
                		{32, 33, 39, 50},
              			};
		search(arr, 4, 29);
	}

	private static void search(int arr[][], int n, int number) {
		int i = 0; 
		int j = n - 1;
		
		while(i < n && j >= 0) {
			int element = arr[i][j];
			if( element == number)
				System.out.print("Element found at row: " + i + " and column: " + j);
			
			if(element > number)
				j--;
			else i++;
		}
		System.out.print("Element not found");
	}
}
