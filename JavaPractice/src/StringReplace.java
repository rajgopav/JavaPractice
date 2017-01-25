import java.util.StringTokenizer;

public class StringReplace {

	public static void main(String[] args) {
		String str = "  My   Name   is Varun  Rajgopal";
		stringReplace(str);
	}

	private static void stringReplace(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		int count = st.countTokens();
		while (st.hasMoreTokens() && count > 0){
			count--;
			sb.append(st.nextToken());
			sb.append("%20");
		}
		System.out.print(sb.delete(sb.length()-3, sb.length()));
	}
}
