import java.util.HashSet;

public class WordBreak {
	
	public boolean findUsingDP(String s, HashSet<String> dict,
			HashSet<String> memory, String answer) {
		if(s.length() == 0) {
			return true;
		} else if (memory.contains(s)) {
			return false;
		} else {
			int index = 0;
			String word = "";
			
			while(index < s.length()) {
				word += s.charAt(index);
				if(dict.contains(word)) {
					if(findUsingDP(s.substring(index + 1), dict, memory, answer + word + " ")) {
						return true;
					} else {
						index++;
					}
				} else {
					index++;
				}
			}
			memory.add(s);
			return false;
		}
	}
	
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("this");
		hs.add("is");
		hs.add("varun");
		hs.add("rajgopal");
		hs.add("the");
		hs.add("problem");
		String s = "thisisvarunrajgopal";
		
		WordBreak ws = new WordBreak();
		
		// create another HashSet so store the sub problems result
		HashSet<String> memoization = new HashSet<String>();
		boolean bool = ws.findUsingDP(s, hs, memoization, "");
		System.out.println("Is the string present in the dictionary: " + bool);
	}
}
