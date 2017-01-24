
public class ShortestPalindrome {

	public static void main(String[] args) {
		String str = "aacecaaa";
		String str1 = shortestPalindrome(str);
		System.out.println("The shortest palidrome for " + str + " is " + str1);
	}

	private static String shortestPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		
		while(end >= 0) {
			if(str.charAt(start) == str.charAt(end)) {
				start++;
			}
			end--;
		}
		
		if(start == str.length())
			return str;
		
		String suffix = str.substring(start);
		String prefix = new StringBuilder(suffix).reverse().toString();
		String middle = shortestPalindrome(str.substring(0, start));
		return prefix + middle + suffix;
	}

}
