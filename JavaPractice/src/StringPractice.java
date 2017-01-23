import java.util.*;

public class StringPractice{
	public static void main(java.lang.String[] args) {
		StringPracticeImplementation sp = new StringPracticeImplementation();

		char[] charArr = "  Hi there, how  are you   doing? ".toCharArray();
		sp.removeStringWhiteSpace(charArr);

		String str = "((BCD)AE)";
		System.out.println("isValid: " + sp.isValid(str));
		str = ")(PH)N(X)";
		System.out.println("isValid: " + sp.isValid(str));

		String str1 = "hellolle";
		System.out.println("Number of Palindromes is: " + sp.countPalindrome(str1));

		sp.generateParenthesis(3);
		System.out.println();

		String strA = "AABCDEBAZ";
		int x = sp.longestPalindromicSubsequence(strA);
		System.out.println("Length of Longest Palindrome in '" + strA + "' is - " + x);

		String str11 = "AAABABAA";
		String str12 = "AABA";         
		System.out.println();
		sp.findSubstring(str12.toCharArray(),str11.toCharArray());
		
		//sp.searchAnagramSubstring(str11, str12);
	}
}

class StringPracticeImplementation {

	public void removeStringWhiteSpace(char[] charArr) {
		int end = charArr.length;
		int numofSpaces = 0;

		for(int i = 0; i < end; i++ ) {
			if(charArr[i] == ' ')
				numofSpaces++;
			else
				charArr[i - numofSpaces] = charArr[i];
		}
		charArr = Arrays.copyOf(charArr, charArr.length - numofSpaces);
		System.out.println(charArr);
	}

	public boolean isValid(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}

		int count = 0, i = 0;
		while(i < str.length()) {
			if(str.charAt(i) == '(')
				count++;
			else if(str.charAt(i) == ')') {
				if(count == 0)
					return false;
				count--;
			}
			i++;
		}
		if(count == 0) return true;
		return false;
	}

	public int countPalindrome(String str) {
		int globalCount = str.length();
		for(int i = 1; i < str.length() - 1; i++) {
			int count = 0;
			int low = i - 1, high = i + 1;
			while(low >= 0 && high < str.length() && str.charAt(low--) == str.charAt(high++))
				count++;
			globalCount += count;

			count = 0;
			low = i - 1;
			high = i;

			while(low >= 0 && high < str.length() && str.charAt(low--) == str.charAt(high++))
				count++;
			globalCount += count;
		}
		return globalCount;
	}

	public void generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<String>();
		generate(list," ", n, n);
		for(String s : list)
			System.out.print(s);
	}

	public void generate(ArrayList<String> list, String string, int left, int right) {
		if(left > right)
			return;

		if(left == 0 && right == 0) {
			list.add(string);
			return;
		}

		if(left > 0)
			generate(list, string + "(", left - 1, right);

		if(right > 0)
			generate(list, string + ")", left, right - 1);
	}

	public int longestPalindromicSubsequence(String str) {
		char chars[] = str.toCharArray();
		int LP[][] = new int[chars.length][chars.length];

		for(int i = 0; i < chars.length; i++) {
			LP[i][i] = 1;
		}

		for(int sublen = 2; sublen <= chars.length; sublen++) {
			for(int i = 0; i <= LP.length - sublen; i++) {
				int j = i + sublen - 1;
				if(chars[i] == chars[j] && sublen == 2)
					LP[i][j] = 2;
				else if(chars[i] == chars[j])
					LP[i][j] = 2 + LP[i+1][j-1];
				else
					LP[i][j] = Math.max(LP[i+1][j],LP[i][j-1]);
			}
		}
		return LP[0][LP.length-1];
	}

	public void findSubstring(char pat[], char txt[]){
		int M = pat.length, N = txt.length;
		int count = 0;
		int countP[] = new int[256];
		int countTW[] = new int[256];

		for (int i = 0; i < M; i++)
		{
			(countP[pat[i]])++;
			(countTW[txt[i]])++;
		}

		if (compare(countP, countTW))
			count++;
		// Traverse through remaining characters of pattern
		for (int i = M; i < N; i++)
		{
			countTW[txt[i]]++;
			countTW[txt[i-M]]--;

			if (compare(countP, countTW))
				count++;;
		}
		System.out.println(count);
	}

	public boolean compare(int[] arr1, int[] arr2){
		for(int i = 0; i < 256; i++) {
			if(arr1[i] != arr2[i]) 
				return false;
		}
		return true;
	}

	private  boolean equalHistogram(int[] hist1, int[] hist2){
		for(int i = 0; i < hist1.length; i++){
			if(hist1[i] != hist2[i]){
				return false;
			}
		}

		return true;
	}

	public void searchAnagramSubstring(String text, String pattern){
		int count = 0;
		int n = text.length();
		int m = pattern.length();

		int textHist []  =  new  int [ 256 ]; 
		int patHist []  =  new  int [ 256 ];

		
		int i = 0;
		for(i = 0; i < m; i++){
			patHist[pattern.charAt(i)]++;
			textHist[text.charAt(i)]++;
		}

		//search the pattern histogram in a sliding window of text histogram
		do{
			//O(1) time check as array size is constant
			if(equalHistogram(textHist, patHist)){
				System.out.println("anagram found : "+text.substring(i-m, i));
				count++;
			}

			//slide the text histogram window by 1 position to the right and check for anagram
			textHist[text.charAt(i)]++;
			textHist[text.charAt(i-m)]--;
		} while(++i < n);

		System.out.println(count);
	}
}



