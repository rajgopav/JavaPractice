
public class MissingNumber {

	public static void main(String[] args) {
		int [] arrA = {1,2,3,4,5,7,8,9,10};
		System.out.println("Missing number is : " + (new MissingNumber()).missingNumber(arrA,10));
	}

	private int missingNumber(int[] arrA, int n) {
		int size = (n* (n + 1)) / 2;
		int size1 = 0;
		
		for(int i = 0; i < arrA.length; i++) {
			size1 += arrA[i];
		}
		return (size - size1);
	}
}
