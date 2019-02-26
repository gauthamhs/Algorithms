package algorithms.datastructures.dynamicProgramming;

public class LongestPalindromicSubstring {
	
	public static int longestPalindromicSubstringNaive(String sequence) {
		int startIndex = 0;
		int lastIndex = sequence.length()-1;
		return longestPalindromicSubstringNaiveHelper(sequence, startIndex, lastIndex);
	}
	
	public static int longestPalindromicSubstringNaiveHelper(String sequence, int startIndex, int lastIndex) {
		if(startIndex>lastIndex) {
			return 0;
		}
		
		if(startIndex==lastIndex) {
			return 1;
		}
		
		int c1 = 0;
		if(sequence.charAt(startIndex)==sequence.charAt(lastIndex)) {
			int remainingSubstringLength = lastIndex-startIndex-1;
			if(remainingSubstringLength == longestPalindromicSubstringNaiveHelper(sequence, startIndex+1, lastIndex-1)){
				return 2 + remainingSubstringLength;
			}
		}
			
			int c2 = longestPalindromicSubstringNaiveHelper(sequence, startIndex, lastIndex-1);
			int c3 = longestPalindromicSubstringNaiveHelper(sequence, startIndex+1, lastIndex);
			
			return Math.max(c1, Math.max(c2, c3));
			
	}
	
	public static int longestPalindromicSubstringMemoize(String sequence) {
		int startIndex = 0;
		int endIndex = sequence.length()-1;
		int[][] memoize = new int[sequence.length()][sequence.length()];
		return longestPalindromicSubstringMemoizeHelper(sequence, startIndex, endIndex, memoize);
	}
	
	public static int longestPalindromicSubstringMemoizeHelper(String sequence, int startIndex, int lastIndex, int[][] memoize) {
		if(startIndex>lastIndex) {
			return 0;
		}
		
		if(startIndex==lastIndex) {
			return 1;
		}
		
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;

		if(memoize[startIndex][lastIndex]==0) {
			
			if(sequence.charAt(startIndex)==sequence.charAt(lastIndex)) {
				int remainingLength = lastIndex - startIndex - 1;
				if(remainingLength == longestPalindromicSubstringMemoizeHelper(sequence, startIndex+1, lastIndex-1, memoize)) {
					 c1 = 2 + remainingLength;
				}
			}
			
			 c2 = longestPalindromicSubstringMemoizeHelper(sequence, startIndex+1, lastIndex, memoize);
			 c3 = longestPalindromicSubstringMemoizeHelper(sequence, startIndex, lastIndex-1, memoize);
			
			memoize[startIndex][lastIndex] = Math.max(c1, Math.max(c2, c3));
		}
		
		return memoize[startIndex][lastIndex];
		
	}
	
	public static int longestPalindromicSubStringBottomUp(String sequence) {
		boolean[][] bottomUpMatrix = new boolean[sequence.length()][sequence.length()];
		
		for(int k=0;k<sequence.length();k++) {
			bottomUpMatrix[k][k] = true;
		}
		
		int maxLength = 1;
		
		for(int i=sequence.length()-1;i>=0;i--) {
			for(int j=i+1; j<sequence.length();j++) {
				if(sequence.charAt(i)==sequence.charAt(j)) {
					if(j-i==1 || bottomUpMatrix[i+1][j-1]) {
						bottomUpMatrix[i][j] = true;
						maxLength = Math.max(maxLength, j-i+1);
						
					}
				}
			}
		}
		
		return maxLength;
	}
	
	public static String longestPalindromicSubString(String s) {
		if(s==null || s.isEmpty()) {
			return "";
		}
		

		
		boolean[][] bottomUpMatrix = new boolean[s.length()][s.length()];
		
		for(int k=0;k<s.length();k++) {
			bottomUpMatrix[k][k] = true;
		}
		
		int maxLength = 1;
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i = s.length()-1;i>=0;i--) {
			for(int j=i+1;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j)) {
					if(j-i==1 || bottomUpMatrix[i+1][j-1]) {
						bottomUpMatrix[i][j] = true;
						
						if (j-i+1>maxLength) {
							startIndex = i;
							endIndex = j;
							maxLength = j-i+1;
						}
						
					}
				}
			}
		}
		
		return s.substring(startIndex, endIndex+1);
		
		
	}
	
	public static void main(String[] args) {
		String sequence = "sakdosadkamalamkdalsdksadl";
		int longestSubstringNaive = longestPalindromicSubstringNaive(sequence);
		System.out.println(longestSubstringNaive);
		
		int longestSubstringMemoize = longestPalindromicSubstringMemoize(sequence);
		System.out.println(longestSubstringMemoize);
		
		int longestSubstringBottomUp = longestPalindromicSubStringBottomUp(sequence);
		System.out.println(longestSubstringBottomUp);
		
		String longestSubstring = longestPalindromicSubString(sequence);
		System.out.println(longestSubstring);
	}

}
