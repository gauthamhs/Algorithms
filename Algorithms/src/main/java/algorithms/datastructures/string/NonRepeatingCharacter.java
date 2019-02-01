package algorithms.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {
	
	public static Character firstNonRepeatingCharacter(String word) {
		
		
		if(word.isEmpty() || word==null) {
			return null;
		}
		
		Map<Character, Integer> charCount = new HashMap<>();
		for(int i=0;i<word.length();i++) {
			if(charCount.containsKey(word.charAt(i))) {
				int occurrence = charCount.get(word.charAt(i));
				charCount.put(word.charAt(i), ++occurrence);
				
			} else {
				charCount.put(word.charAt(i), 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry: charCount.entrySet()) {
			Character ch = entry.getKey();
			int occurrence = entry.getValue();
			
			if(occurrence==1) {
				return ch;
			}
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		String word = "aabbccaaadddeffffgg";
		Character nonRepeatingCharacter = firstNonRepeatingCharacter(word);
		System.out.println(nonRepeatingCharacter);
		
	}

}
