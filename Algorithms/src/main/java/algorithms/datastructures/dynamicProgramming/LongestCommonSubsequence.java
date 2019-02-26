package algorithms.datastructures.dynamicProgramming;

public class LongestCommonSubsequence {
	
	public static int longestCommonSubsequenceNaive(String sequence1, String sequence2) {
		
		if(sequence1==null||sequence2==null||sequence1.isEmpty()||sequence2.isEmpty()) {
			return 0;
		}
		
		int i1 = 0;
		int i2 = 0;
		return longestCommonSubsequenceNaiveHelper(sequence1, sequence2, i1, i2);
	}
	
	public static int longestCommonSubsequenceNaiveHelper(String sequence1, String sequence2, int i1, int i2) {

		
		if(i1==sequence1.length() || i2==sequence2.length()) {
			return 0;
		}
		
		if(sequence1.charAt(i1)==sequence2.charAt(i2)) {
			return 1 + longestCommonSubsequenceNaiveHelper(sequence1, sequence2, i1+1, i2+1);
		} else { 
			int c1 = longestCommonSubsequenceNaiveHelper(sequence1, sequence2, i1+1, i2);
			int c2 = longestCommonSubsequenceNaiveHelper(sequence1, sequence2, i1, i2+1);
			
			return Math.max(c1, c2);
		}
	}
	
	public static int longestCommonSubsequenceBottomUp(String sequence1, String sequence2) {
		
		if(sequence1==null||sequence2==null||sequence1.isEmpty()||sequence2.isEmpty()) {
			return 0;
		}
		
		int[][] bottomUpMatrix = new int[sequence1.length() + 1][sequence2.length() + 1];
		
		for(int i=1;i<=sequence1.length();i++) {
			for(int j=1;j<=sequence2.length();j++) {
				if(sequence1.charAt(i-1)==sequence2.charAt(j-1)) {
					bottomUpMatrix[i][j] = 1 + bottomUpMatrix[i-1][j-1];
				} else {
					int c1 = bottomUpMatrix[i-1][j];
					int c2 = bottomUpMatrix[i][j-1];
					bottomUpMatrix[i][j] = Math.max(c1, c2);
				}
			}
		}
		
		return bottomUpMatrix[sequence1.length()][sequence2.length()];
		
	}
	
	public static void main(String[] args) {
		
		String sequence1 = "abddkawoee";
		String sequence2 = "bkacee";
		
		int lengthNaive = longestCommonSubsequenceNaive(sequence1, sequence2);
		System.out.println(lengthNaive);
		
		int lengthBottomUp = longestCommonSubsequenceBottomUp(sequence1, sequence2);
		System.out.println(lengthBottomUp);
		
	}

}
