package algorithms.datastructures.dynamicProgramming;

public class LongestRepeatingSubsequence {
	
	// Longest Repeating subsequence is very similar to LCS. Longest common subsequence is between two strings. 
	// LRS is between the same string, the only difference is that the two indexes in the string shouldn't be similar.
	
	public static int longestRepeatingSubsequenceNaive(String sequence) {
		int i1 = 0;
		int i2 = 0;
		return longestRepeatingSubsequenceNaiveHelper(sequence, i1, i2);
	}
	
	public static int longestRepeatingSubsequenceNaiveHelper(String sequence, int i1, int i2) {
		

		if(i1==sequence.length() || i2==sequence.length()) {
			return 0;
		}
		
		if(sequence.charAt(i1)==sequence.charAt(i2) && i1!=i2) {
			return 1 + longestRepeatingSubsequenceNaiveHelper(sequence, i1+1, i2+1);
		} else { 
			int c1 = longestRepeatingSubsequenceNaiveHelper(sequence, i1+1, i2);
			int c2 = longestRepeatingSubsequenceNaiveHelper(sequence, i1, i2+1);
			return Math.max(c1, c2);
		}
		
	}
	
	public static void main(String[] args) {
		
		String sequence = "aabdbcec";
		int lrsNaive = longestRepeatingSubsequenceNaive(sequence);
		System.out.println(lrsNaive);
		
	}

}
