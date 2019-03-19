package algorithms.datastructures.hashtables;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LetterMagazine {
	
	public static boolean isWordConstructibleForLetterFromMagazine(String letter, String magazine) {
		
		Map<Character, Long> countMap = letter.chars().mapToObj(i -> (char)i)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		for(char c : magazine.toCharArray()) {
			if(countMap.containsKey(c)) {
				
				countMap.put(c, countMap.get(c)-1L);
					countMap.remove(c, 0L);
				
				if(countMap.isEmpty()) {
					break;
				}
				
			}
		}
		
		return countMap.isEmpty();
		
	}
	
	public static void main(String[] args) {
		String letter = "murderye";
		String magazine = "mysteryurdscene";
		
		boolean isLetterPossible = isWordConstructibleForLetterFromMagazine(letter, magazine);
		System.out.println(isLetterPossible);
		
	}

}
