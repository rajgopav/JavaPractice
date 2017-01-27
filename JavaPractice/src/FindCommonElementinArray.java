
public class FindCommonElementinArray {

	public static void main(String[] args) {
		int [] A = {1,2,3,4,5,6,7,8,9,10};
		int [] B = {1,3,5,6,7,8,12};
		int [] C = {2,3,4,5,8,9};
		FindCommonElementinArray fc = new FindCommonElementinArray();
		System.out.print("Common Elements are : ");
		fc.findCommon(A, B, C);
	}

	private void findCommon(int[] a, int[] b, int[] c) {
		int i = 0, j = 0, k = 0;
		while(i < a.length && j < b.length && k < c.length)
		{
			if((a[i] == b[j]) && (b[j] == c[k])) {
				System.out.print(a[i] + " "); i++; j++; k++;
			} else if((a[i] <= b[j]) && (a[i] <= c[k])) {
				i++;
			} else if((b[j] <= a[i]) && (b[j] <= c[k])) {
				j++;
			} else {
				k++;
			}
		}
	}
}
