
public class LongestPrefix {
	public static void main(String[] args) {
		String str[] = "Bed­room Bed­Clock Bed­Table Bed­Wall".split(" ");
		int len = str[0].length();
		int curr;
		for(int i = 1; i < str.length; i++) {
			curr = 0;
			while(curr < len && curr < str[i].length() && str[0].charAt(curr) == str[i].charAt(curr))
				curr++;
			
			len = curr;
		}
		System.out.print(str[0].substring(0, len));
	}
}
