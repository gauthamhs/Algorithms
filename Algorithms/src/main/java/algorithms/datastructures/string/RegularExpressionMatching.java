package algorithms.datastructures.string;

public class RegularExpressionMatching {
	
	// For Regular Expression Matching, We are given two conditions: 
	
	//  which means that this could replace any given character sort of like a wildcard.
	//  * such as a*b. This means that we can have 0 occurrence of a and atleast one occurrence of b.
	// We can use dynamic programming to solve this problem. For *, we need to check for two cases.
	// Whether we can remove zero occurrences of the character before * and check to see if that works.
	// If not, We need to see if the pattern and the previous character matches.
	
	public static boolean isMatch(String s, String p) {
	
		boolean[][] regexMatrix = new boolean[s.length() + 1][p.length() + 1];
		regexMatrix[0][0] = true;
		
		for(int i=1;i<regexMatrix[0].length;i++) {
			if(p.charAt(i-1)=='*') {
				regexMatrix[0][i] = regexMatrix[0][i-2];
			}
		}
		
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=p.length();j++) {
				// If the character of the string and pattern matches or if the pattern is ., just check if 
				// the remaining characters match. 
				
				if(p.charAt(j-1)=='.' || s.charAt(i-1)==p.charAt(j-1)) {
					regexMatrix[i][j] = regexMatrix[i-1][j-1];
				} else if(p.charAt(j-1)=='*') { // If pattern is *, then we need to check for two cases.
					// Case 1: Check if zero occurrences for the character before * is true.
					regexMatrix[i][j] = regexMatrix[i][j-2];
					if(p.charAt(j-2)=='.' || p.charAt(j-2) == s.charAt(i-1)) {
						regexMatrix[i][j] = regexMatrix[i][j] | regexMatrix[i-1][j];
					}
				} else {
					regexMatrix[i][j]= false;
				}
			}
		}
		
		return regexMatrix[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
		boolean isMatch = isMatch("b", "c*a*b");
		System.out.println(isMatch);
	}

}
