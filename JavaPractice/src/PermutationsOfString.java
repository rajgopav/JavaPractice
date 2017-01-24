import java.util.HashSet;

public class PermutationsOfString {
	
	public static HashSet<String> generatePermutations(String str) {
		HashSet<String> permutations = new HashSet<String>();
		if(str == null || str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remanining = str.substring(1);
		HashSet<String> words = generatePermutations(remanining);
		for(String word : words) {
			for(int i = 0; i < str.length(); i++) {
				String prefix = word.substring(0, i);
				String suffix = word.substring(i);
				permutations.add(prefix + first + suffix);
			}
		}
		return permutations;
	}
	
	public static void main(String[] args) {
		String str = "abc";
        HashSet<String> permutations = generatePermutations(str);
        System.out.println(permutations.toString());
	}
}
