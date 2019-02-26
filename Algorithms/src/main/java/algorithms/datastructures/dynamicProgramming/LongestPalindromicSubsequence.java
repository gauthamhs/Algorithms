package algorithms.datastructures.dynamicProgramming;

public class LongestPalindromicSubsequence {
	
	
	// In the palindromic subsequence, we return the length of the longest palindrome(adjacent or non-adjacent).
	public static int longestPalindromicSubsequenceNaive(String sequence) {
		int startIndex = 0;
		int lastIndex = sequence.length()-1;
		
		return longestPalindromicSubsequenceNaiveHelper(sequence, startIndex, lastIndex);
	}
	
	public static int longestPalindromicSubsequenceNaiveHelper(String sequence, int startIndex, int lastIndex) {
		if(startIndex>lastIndex) {
			return 0;
		}
		
		// a one char string is a palindrome, so we return one
		if(startIndex == lastIndex) {
			return 1;
		}
		// If first and last character matches.
		if(sequence.charAt(startIndex)==sequence.charAt(lastIndex)) {
		int firstLastCharacterMatch =  2 + longestPalindromicSubsequenceNaiveHelper(sequence, startIndex + 1, lastIndex-1);
		return firstLastCharacterMatch;
		}
		
		// If they dont match, we skip character for each start and last index and take the max out of it.
		
		int firstDontMatch = longestPalindromicSubsequenceNaiveHelper(sequence, startIndex+1, lastIndex);
		int secondDontMatch = longestPalindromicSubsequenceNaiveHelper(sequence, startIndex, lastIndex-1);
		
		return Math.max(firstDontMatch, secondDontMatch);
	}
	
	public static int longestPalindromicSubSequenceMemoization(String sequence) {
		int startIndex = 0;
		int endIndex = sequence.length()-1;
		int[][] memoize = new int[sequence.length()][sequence.length()];
		return longestPalindromicSubSequenceMemoizationHelper(sequence, startIndex, endIndex, memoize);
	}
	
	public static int longestPalindromicSubSequenceMemoizationHelper(String sequence, int startIndex, int endIndex, int[][] memoize) {
		if(startIndex>endIndex) {
			return 0;
		}
		
		if(startIndex==endIndex) {
			return 1;
		}
		
		if(memoize[startIndex][endIndex]==0){
			if(sequence.charAt(startIndex)==sequence.charAt(endIndex)) {
				memoize[startIndex][endIndex] = 2 + longestPalindromicSubSequenceMemoizationHelper(sequence, startIndex+1, endIndex-1, memoize);
			} else {
			
			int firstCharMatch = longestPalindromicSubSequenceMemoizationHelper(sequence, startIndex+1, endIndex, memoize);
			int secondCharMatch = longestPalindromicSubSequenceMemoizationHelper(sequence, startIndex, endIndex-1, memoize);
			
			memoize[startIndex][endIndex] = Math.max(firstCharMatch, secondCharMatch);
			}
		}
		
		return memoize[startIndex][endIndex];
	}
	
	public static int longestPalindromicSubSequenceBottomUpApproach(String sequence) {
		
		int[][] bottomUpMatrix = new int[sequence.length()][sequence.length()];
		
		for(int k=0;k<sequence.length();k++) {
			bottomUpMatrix[k][k]=1;
		}
		
		for(int i=sequence.length()-1;i>=0;i--) {
			for(int j=i+1;j<sequence.length();j++) {
				if(sequence.charAt(i)==sequence.charAt(j)) {
					bottomUpMatrix[i][j] = 2 + bottomUpMatrix[i+1][j-1];
				} else {
					bottomUpMatrix[i][j] = Math.max(bottomUpMatrix[i+1][j], bottomUpMatrix[i][j-1]);
				}
			}
		}
		
		
		return bottomUpMatrix[0][sequence.length()-1];
	}
	
	
	
	public static void main(String[] args) {
		
		String sequence = "aaabbb";
		
		int subSequenceNaiveLength = longestPalindromicSubsequenceNaive(sequence);
		System.out.println(subSequenceNaiveLength);
		
		int subSequenceMemoizeLength = longestPalindromicSubSequenceMemoization(sequence);
		System.out.println(subSequenceMemoizeLength);
		
		int subSequenceBottomUpLength = longestPalindromicSubSequenceBottomUpApproach(sequence);
		System.out.println(subSequenceBottomUpLength);
	
	}

}
