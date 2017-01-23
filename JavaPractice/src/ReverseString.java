public class ReverseString {

	public static void swap (char[] charArr, int start, int end) {
			char temp = charArr[end];
			charArr[end] = charArr[start];
			charArr[start] = temp;
	}
	
	public static void reverse(char[] charArr, int start, int end) {
		while(start < end) {
			swap(charArr, start, end);
			start++;
			end--;
		}
	}
	
	public static void reverseString(char[] str) {
		int start = 0;
		int end = str.length;
		
		for(int i = 0; i < end; i++){
			if(str[i] == ' ' && i > 0) {
				reverse(str, start, i - 1);
				start = i + 1;
			}  else if(i == end - 1) {
                reverse(str, start, i);
            }
		}
		reverse(str, 0, end - 1);
	}
	
	public static void main(String[] args) {
		char[] str = "This is a String".toCharArray();
		reverseString(str);
		System.out.print(str);
	}
}
