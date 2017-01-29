import java.util.HashSet;

public class LCS {
	public static void main(String[] args) {
		int arr[] = {1, 9, 3, 10, 4, 20, 2};
		int n = arr.length;
		System.out.println("Longest consecutive subsequence is: " + lcs(arr,n));
		
		String A = "acbaed";
		String B = "abcadf";
		int result = longestCommonSubSequence(A,B);
		System.out.print(result);
	}
	
	public static int lcs(int arr[], int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int ans = 1;
		
		for(int i : arr)
			hs.add(i);
		
		for(int i : arr) {
			int left = i - 1;
			int right = i + 1;
			int count = 1;
			
			while(hs.contains(left)) {
				count++;
				hs.remove(left);
				left--;
			}
			
			while(hs.contains(right)) {
				count++;
				hs.remove(right);
				right++;
			}
			
			ans = Math.max(count, ans);
		}
		
		return ans;
	}
	
	public static int longestCommonSubSequence(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n ; j++){
				if(i==0 || j==0){
					dp[i][j] = 0; 
				} else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
}
