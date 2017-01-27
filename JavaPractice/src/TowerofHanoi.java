
public class TowerofHanoi {

	public static void main(String[] args) {
		int n = 4;
		Tower(n,"A","C","B");
	}

	private static void Tower(int n, String src, String aux, String dest) {
		if(n == 1) {
			System.out.println("Move disc " + n + " from " + src + " to " + dest  );
		} else {
			Tower(n - 1, src, dest, aux );
			System.out.println("Move disc " + n + " from " + src + " to " + dest  );
			Tower(n - 1, aux, src, dest);
		}
	}
}
