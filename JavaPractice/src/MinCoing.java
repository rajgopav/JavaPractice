import java.util.Arrays;

public class MinCoing {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3};
		int sum = 20;
		int result = minCoin(arr, sum);
		System.out.println("Minimum number of coins required are: " + result);

	}
	
	public static int minCoin(int coins[], int amount) {
		int arr[] = new int[amount + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		
		for(int i = 0; i <= amount; i ++) {
			for(int coin : coins) {
				if(coin + i <= amount) {
					if(arr[i] == Integer.MAX_VALUE) {
						arr[coin + i] = arr[coin + i];
					} else {
						arr[coin + i] = Math.min(arr[coin + i], arr[i] + 1);
					}
				}
			}
		}
		
		if(arr[amount] >= Integer.MAX_VALUE) return -1;
		
		return arr[amount];
	}
}
