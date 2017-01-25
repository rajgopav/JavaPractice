import java.util.HashSet;

public class FirstRepeatedElement {

	public static void main(String[] args) {
		int [] a = {1,2,5,7,5,3,10,2};
		FirstRepeatedElement f = new FirstRepeatedElement();
		System.out.println("{1,2,5,7,5,3,10,2}");
		System.out.println("first repeated element by index is : " + f.find(a));

	}

	private int find(int[] a) {
		int index = -1;
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = a.length - 1;i >= 0; i--) {
			if(hs.contains(a[i]))
				index = i;
			else
				hs.add(a[i]);
		}
		return a[index];
	}
}
