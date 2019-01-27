package algorithms.datastructures.string;

public class Palindrome {
	
/*	This checks if a string is a palindrome. In other words,
	original string is equal to the reversed string.
	*/
	
	
	public static boolean isPalindromeStringBuilder(String word) {
		StringBuilder sb = new StringBuilder(word).reverse();
		if(!word.equals(sb.toString())) {
			return false;
		}
		
		return true;
	}
	
	/*Complexity: O(n) and O(1) space*/
	public static boolean isPalindrome(String word) {
		for(int i=0,j=word.length()-1;i<j;++i,--j) {
			if(word.charAt(i)!=word.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String word = "malayalam";
		boolean isPalindrome = isPalindromeStringBuilder(word);
		System.out.println(isPalindrome);
		boolean isPalindrome2 = isPalindrome(word);
		System.out.println(isPalindrome2);
		int x = 4;
		System.out.println('0' +Math.abs(x%10));
		
	}

}
