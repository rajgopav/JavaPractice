
public class StringRotation {
	public static boolean isStringRotation(String s1, String s2) {
		int len = s1.length();
		if(len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return isStringRotation(s1s1, s2);
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		boolean bool = isStringRotation(s1,s2);
		System.out.println(bool);
	}

}
