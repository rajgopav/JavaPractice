
public class SubSetSum {
	
	public static boolean subSetSum(int arr[], int sum) {
		boolean solution[][] = new boolean[arr.length + 1][sum + 1];
		
		for(int i = 1; i <= sum; i++) {
			solution[0][i] = false;
		}
		
		for(int i = 0; i <= arr.length; i++) {
			solution[i][0] = true;
		}
		
		for(int i = 1 ; i <= arr.length; i++) {
			for(int j = 1; j <= sum; j++) {
				solution[i][j] = solution[i - 1][j];
				
				if(solution[i][j] == false && j >= arr[i - 1] )
					solution[i][j] = solution[i][j] || solution[i - 1][j - arr[i-1]];
			}
		}
		return solution[arr.length][sum];
	}
	
	public static void main(String[] args) {
		int[] A = { 3, 2, 7, 1};
		System.out.println("From DP: " + subSetSum(A, 6) );
	}
}
