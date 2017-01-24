public class ReverseString {

	public static void reverseString(char str[]) {
		int start = 0;
		for(int j = 0; j < str.length; j++) {
			if(str[j] == ' ') {
				reverse(str, start, j -1);
				start = j + 1;
			}
		}
		
		reverse(str, start, str.length - 1);
		reverse(str, 0, str.length - 1);
 	}
	
	private static void reverse(char[] str, int start, int end) {
		while(start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++; end--;
		}
	}

	public static void main(String[] args) {
		char[] str = "This is a String".toCharArray();
		reverseString(str);
		System.out.print(str);
	}
}
