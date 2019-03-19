package algorithms.datastructures.hashtables;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
	
	public static boolean canPermutePalindrome(String word) {
		
		Set<Character> charSet = new HashSet<>();
		
		for(char c : word.toCharArray()) {
			if(charSet.contains(c)) {
				charSet.remove(c);
			} else {
				charSet.add(c);
			}
		}
		
		return charSet.size()<=1;
	}
	
	public static void main(String[] args) {
		String word = "edifieds";
		boolean isPermutePalindrome = canPermutePalindrome(word);
		System.out.println(isPermutePalindrome);
	}

}
