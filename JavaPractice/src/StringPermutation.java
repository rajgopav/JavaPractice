import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class StringPermutation {
	public static boolean stringSort(String str1, String str2) {
		char arr1[] = str1.toCharArray();
		char arr2 [] = str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(Arrays.equals(arr1, arr2)){
			return true;
		}
		return false;
	}
	
	public static boolean stringHash(String str1, String str2) {
		HashMap<Character, Integer> hm= new HashMap<Character, Integer>();
		
		if(str1.length() != str2.length()){
			return false;
		}
		
		for(char c : str1.toCharArray()) {
			if(hm.containsKey(c))
				hm.put(c, hm.get(c) + 1);
			else 
				hm.put(c, 1);
		}
		
		for(char c : str2.toCharArray()) {
			if(hm.containsKey(c))
				hm.put(c, hm.get(c) - 1);
			else 
				hm.put(c, 1);
		}
		
		for(Entry<Character, Integer> entry : hm.entrySet()) {
			if(entry.getValue() == 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "varun";
		String s2 = "nurav";
		System.out.println(s1 +" and "+ s2 + " are permutation of each other? " + stringSort(s1, s2));
		System.out.println(s1 +" and "+ s2 + " are permutation of each other? " + stringHash(s1, s2));
	}

}
