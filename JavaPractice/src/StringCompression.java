import java.util.*;
import java.util.Map.Entry;

public class StringCompression {	
	public static String StringCompression1(String str) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(char ch : str.toCharArray()) {
			map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
		}
		
		for(Entry<Character, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey());
			sb.append(entry.getValue());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "Vvvvvvvaaaarrrrruuunnnnnnnnnnnnn";
		System.out.println("Compression of " + str + " is : " + StringCompression1(str));

	}

}
