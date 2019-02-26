package algorithms.datastructures.dynamicProgramming;

public class ShortestCommonSubsequence {
	
	//To find the shortest common supersequence, we need to find the longest common subsequence between the two strings and 
	// subtract the lcs from the total length of the two strings.
	
	public static int shortestCommonSubsequence(String sequence1, String sequence2) {
		int lcs = longestCommonSubsequence(sequence1, sequence2);
		int shortestCommonSupersequence = sequence1.length() + sequence2.length() - lcs;
		return shortestCommonSupersequence;
	}
	
	public static int longestCommonSubsequence(String sequence1, String sequence2) {
		
		if(sequence1==null || sequence2==null || sequence1.isEmpty() || sequence2.isEmpty()) {
			return 0;
		}
		
		int maxLength = 0;
		int[][] bottomUpMatrix = new int[sequence1.length()+1][sequence2.length()+1];
		
		for(int i=1;i<=sequence1.length();i++) {
			for(int j=1;j<=sequence2.length();j++) {
				if(sequence1.charAt(i-1)==sequence2.charAt(j-1)) {
					bottomUpMatrix[i][j] = 1 + bottomUpMatrix[i-1][j-1];
				} else { 
					bottomUpMatrix[i][j] = Math.max(bottomUpMatrix[i-1][j], bottomUpMatrix[i][j-1]);
				}
				maxLength = Math.max(maxLength, bottomUpMatrix[i][j]);
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		String sequence1 = "AGGTAB";
		String sequence2 = "GXTXAYB";
		
		int shortestCommonSupersequence = shortestCommonSubsequence(sequence1, sequence2);
		System.out.println(shortestCommonSupersequence);
		
	}

}
