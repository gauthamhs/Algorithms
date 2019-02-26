package algorithms.datastructures.dynamicProgramming;

public class SubsequencePatternMatching {
	
	// In this method, we are trying to determine how many times a pattern repeats in the string.
	
	public static int countOfSubsequencePatternMatchingNaive(String sequence, String pattern) {
		
		int sequenceIndex = 0;
		int patternIndex = 0;
		return countOfSubsequencePatternMatchingNaiveHelper(sequence, pattern, sequenceIndex, patternIndex);
	}
	
	public static int countOfSubsequencePatternMatchingNaiveHelper(String sequence, String pattern, int sequenceIndex, int patternIndex) {
		
		// If Pattern is empty, return one
		if(patternIndex==pattern.length()) {
			return 1;
		}
		
		if(sequenceIndex == sequence.length()) {
			return 0;
		}
		
		int c1 = 0;
		if(sequence.charAt(sequenceIndex) == pattern.charAt(patternIndex)) {
			c1 = countOfSubsequencePatternMatchingNaiveHelper(sequence, pattern, sequenceIndex+1, patternIndex+1);
		}
		
		int c2 = countOfSubsequencePatternMatchingNaiveHelper(sequence, pattern, sequenceIndex+1, patternIndex);
		
		return c1 + c2;
		
	}
	
	public static int countNoOfSubsequencePatternMatchingBottomUp(String sequence, String pattern) {
		if(sequence.length()==0 && pattern.length()==0 || pattern.length()==0) {
			return 1;
		}
		
		if(sequence.length()==0 || pattern.length()>sequence.length()) {
			return 0;
		}
		
		int[][] bottomUpMatrix = new int[sequence.length()+1][pattern.length()+1];
		
		for(int k=0;k<=sequence.length();k++) {
			bottomUpMatrix[k][0] = 1;
		}
		
		for(int i=1;i<=sequence.length();i++) {
			for(int j=1;j<=pattern.length();j++) {
				if(sequence.charAt(i-1)==pattern.charAt(j-1)) {
					bottomUpMatrix[i][j] = bottomUpMatrix[i-1][j-1];
				}
				
				bottomUpMatrix[i][j] += bottomUpMatrix[i-1][j];
				
			}
		}
		
		return bottomUpMatrix[sequence.length()][pattern.length()];
			
	}
	
	public static void main(String[] args) {
		
		String sequence = "tomorrow";
		String pattern = "tor";
		
		int countSubsequencePattern = countOfSubsequencePatternMatchingNaive(sequence, pattern);
		System.out.println(countSubsequencePattern);
		
		int countSubsequencePatternBottomUp = countNoOfSubsequencePatternMatchingBottomUp(sequence, pattern);
		System.out.println(countSubsequencePatternBottomUp);
		
	}

}
