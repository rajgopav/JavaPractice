import java.util.*;
import java.util.Map.Entry;

public class FirstNonRepeatingCharacter {

	public static char firstNonRepeatingCharacterLinear(String str) {
		if(str.length() == 0)
			throw new RuntimeException("String length is zero"); 
		
		if(str.length() == 1)
			return str.charAt(0);
		
		int counts[] = new int[256];
		for(int i = 0; i < 256; i++)
			counts[i] = 0;
		
		for(int i = 0; i < str.length(); i++) {
			counts[str.charAt(i)]++;
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(counts[str.charAt(i)] == 1)
				return str.charAt(i);
		}
		throw new RuntimeException("didn't find any non repeated Character"); 
	}
	
	public static char firstNonRepeatingCharacterHashMap(String str) {
		Map<Character, Integer> nr = new HashMap<Character, Integer>();
		
		for(char c : str.toCharArray()) {
			nr.put(c, nr.containsKey(c) ? nr.get(c) + 1 : 1);
		}
		
		for(Entry<Character, Integer> entry : nr.entrySet()) {
			if(entry.getValue() == 1)
				return entry.getKey();
		}
		throw new RuntimeException("didn't find any non repeated Character"); 
	}
	
	public static void main(String[] args) {
		String string = "ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB";
		System.out.println("Linear Output: " + firstNonRepeatingCharacterLinear(string));
		System.out.println("HashMap Output: " + firstNonRepeatingCharacterHashMap(string));
	}

}
