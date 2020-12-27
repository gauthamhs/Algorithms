package algorithms.datastructures.string;

public class PalindromeWithSpecialCharacters {
	
/*	Time Complexity: O(n)
	Space Complexity: O(1)*/
	public static boolean isPalindrome(String sentence) {
		int i = 0;
		int j =sentence.length()-1;
		
		while(i<j) {
			while(i<j && !Character.isLetterOrDigit(sentence.charAt(i))) {
				++i;
			}
			while(i<j && !Character.isLetterOrDigit(sentence.charAt(j))) {
			   --j;	
			}
			
			if(Character.toLowerCase(sentence.charAt(i))!=
			   Character.toLowerCase(sentence.charAt(j))) {
				return false;
			}
			++i;
			--j;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String sentence = "Able was I, ere I saw ELba !";
		boolean isPalindrome = isPalindrome(sentence);
		System.out.println(isPalindrome);
	}

}
