
public class MinPathSum {

	public static void main(String[] args) {
		MinPathSum mp = new MinPathSum(); 
		int[][] A = { { 1, 7, 9, 2 }, { 8, 6, 3, 2 }, { 1, 6, 7, 8 },
					{ 2, 9, 8, 2 } };
		System.out.println("Minimum Cost Path " + mp.minPathSum(A));
	}
	
	public int minPathSum(int arr[][]) {
		int row = arr.length;
		int col = arr.length;
		int dp [][] = new int[row][col];
		
		dp[0][0] = arr[0][0];
		
		for(int i = 1; i < col; i++)
			dp[0][i] = arr[0][i] + dp[0][i-1];
		
		for(int i = 1; i < row; i++)
			dp[i][0] = arr[i][0] + dp[i-1][0];
		
		for(int i = 1; i < row; i++)
			for(int j = 1; j < col; j++)
				dp[i][j] = arr[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			
		return dp[arr.length-1][arr.length-1];
	}
}
