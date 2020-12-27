package algorithms.datastructures.string;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {
	
	public static Character firstNonRepeatingCharacter(String word) {
		
		
		Map<Character, Long> charMap = word.chars().mapToObj(i -> (char)i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		for(Map.Entry<Character, Long> entry : charMap.entrySet()) {
			Character key = entry.getKey();
			Long value = entry.getValue();
			
			if(value==1) {
				return key;
			}
		}
		return null;
		
	}
	
	public static Character firstNonRepeatingCharacterNoMap(String word) {
		
		if(word.length()==0) {
			return null;
			
		}
		
		for(int i=0;i<word.length();i++) {
			int count = 1 ;
			while(i+1<word.length() && word.charAt(i)==word.charAt(i+1)) {
				++count;
				++i;
			}
			if(count==1) {
				return word.charAt(i);
			}
			
		}
		
		
		
		
		return null;
	}
	
	public static void main(String[] args) {
		String word = "aabbccaaadddeffffgg";
		Character nonRepeatingCharacter = firstNonRepeatingCharacter(word);
		System.out.println(nonRepeatingCharacter);
		Character nonRepeatingCharacterNoMap = firstNonRepeatingCharacterNoMap(word);
		System.out.println(nonRepeatingCharacterNoMap);
		
	}
}
