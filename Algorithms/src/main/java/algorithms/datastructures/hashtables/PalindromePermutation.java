package algorithms.datastructures.hashtables;

import java.util.HashSet;
import java.util.Set;

// For a Palindrome, it can contain only one char of odd length, and for even palindrome, there cannot be any characters of odd length. 
// For this algorithm, we are adding and removing characters to see that once we have exhausted the string, we only have one or none of
// the characters left
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
