package algorithms.datastructures.dynamicProgramming;

public class MinimumInsertionsDeletionsForPalindrome {
	
	public static int minimumInsertions(String sequence) {
		int LPSLength = longestPalindromicSubsequenceLength(sequence);
		return sequence.length() - LPSLength;
	}
	
	public static boolean isKPalindrome(String sequence, int k) {
		
		int minInsertions = minimumInsertions(sequence);
		
		// K must be equal to or greater than minimum insertion/deletions to form a palindrome
		if(k<minInsertions) {
			return false;
		}
		
		return true;
	}
	
	
	public static int longestPalindromicSubsequenceLength(String sequence) {
		
		int[][] bottomUpMatrix = new int[sequence.length()][sequence.length()];
		
		for(int k=0;k<sequence.length();k++) {
			bottomUpMatrix[k][k] = 1;
		}
		
		for(int i=sequence.length()-1;i>=0;i--) {
			for(int j=i+1;j<sequence.length();j++) {
				if(sequence.charAt(i)==sequence.charAt(j)) {
					bottomUpMatrix[i][j] = 2 + bottomUpMatrix[i+1][j-1];
				}else { 
					bottomUpMatrix[i][j] = Math.max(bottomUpMatrix[i+1][j], bottomUpMatrix[i][j-1]);
				}
			}
		}
		
		return bottomUpMatrix[0][sequence.length()-1];
	}
	
	public static void main(String[] args) {
		
		String sequence = "acbcbcccaa";
		int subsequenceLength = longestPalindromicSubsequenceLength(sequence);
		System.out.println(subsequenceLength);
		int minInsertions = minimumInsertions(sequence);
		System.out.println(minInsertions);
		
		boolean isPalindromePossible = isKPalindrome(sequence, 2);
		System.out.println(isPalindromePossible);
		
	}

}
