package algorithms.datastructures.hashtables;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/* In this algorithm, We are given a magazine and letters, and we have to determine if we can reconstruct the letters from the given magazine
*  Questions to ask interviewer:
*  1) Can we use the letter in magazine more than once
*  2) Does the magazine or letter contain duplicates
*  
*  Note: 
*  1) If we can read the letter more than once, we can store characters of magazine in a set and check if letter contains in the set
*  2) If the magazine contains duplicates, we have to use a hashmap to store the character and its occurrences and subtract the count from the letter.
*        If not, we can store the characters in a set and then compare the letters.
*        
*        Time Complexity: O(m) + O(n) as we go through the magazine first, construct our hashmap with characters and its occurrences, and then letters separately.
*        Space Complexity: O(k)/O(1) where k is the no. of alphabets we are checking against.
*        
*         
*/

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
	
	public static boolean ransomNote(String letter, String magazine) {
		
		Map<Character, Long> magazineMap = new HashMap<>();
		for(char c : magazine.toCharArray()) {
			
			magazineMap.put(c, magazineMap.getOrDefault(c, 0L) + 1);
			/*
			 * if(magazineMap.containsKey(c)) { magazineMap.put(c, magazineMap.get(c)+1); }
			 * else { magazineMap.put(c, 1L); }
			 */
		}
		
		for(char c: letter.toCharArray()) {
			if(!magazineMap.containsKey(c) || magazineMap.get(c)==0) {
				return false;
			}
			magazineMap.put(c, magazineMap.get(c)-1);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String letter = "murderyee";
		String magazine = "mysteryurdscene";
		
		boolean isLetterPossible = isWordConstructibleForLetterFromMagazine(letter, magazine);
		boolean isRansomNote = ransomNote(letter, magazine);
		System.out.println(isLetterPossible);
		System.out.println(isRansomNote);
		
	}

}
