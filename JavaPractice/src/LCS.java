import java.util.HashSet;

public class LCS {
	public static void main(String[] args) {
		int arr[] = {1, 9, 3, 10, 4, 20, 2};
		int n = arr.length;
		System.out.println("Longest consecutive subsequence is: " + lcs(arr,n));
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
}
