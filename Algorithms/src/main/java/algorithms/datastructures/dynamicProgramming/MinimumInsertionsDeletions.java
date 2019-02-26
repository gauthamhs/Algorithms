package algorithms.datastructures.dynamicProgramming;

public class MinimumInsertionsDeletions {
	
	public static void minimumNoOfInsertionsAndDeletions(String sequence1, String sequence2) {
		int lcs = longestCommonSubsequenceBottomUp(sequence1, sequence2);
		System.out.println("Minimum No of Deletions: "  + (sequence1.length() - lcs));
		System.out.println("Minimum No of Insertions: "  + (sequence2.length() - lcs));
		
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
		
		minimumNoOfInsertionsAndDeletions(sequence1, sequence2);
		
		
	}
}
