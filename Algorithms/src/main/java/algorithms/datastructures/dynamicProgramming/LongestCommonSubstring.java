package algorithms.datastructures.dynamicProgramming;

import static org.hamcrest.CoreMatchers.instanceOf;

public class LongestCommonSubstring {
	
	/*In this method, We are trying to identify the longest substring that is common between two strings.
	 * For example, s1="aabbdb", s2 = "cacbbdc". The longest substring that is common is bbd.
	 * 
	 * To solve this problem, we need to identify if there is a matching character between the two strings or not.
	 * If there is a matching character, we recursively solve for the other characters while keeping count of the matching length.
	 * If there is no matching character, we solve for other characters by skipping one character from each string.
	 * 
	 * */
	
	public static int longestCommonSubstringNaive(String sequence1, String sequence2) {
		if(sequence1==null || sequence2==null || sequence1.isEmpty() || sequence2.isEmpty()) {
			return 0;
		}
		
		int i1=0;
		int i2=0;
		int count =0;
		
		return longestCommonSubStringNaiveHelper(sequence1, sequence2, i1, i2, count);
		
	}
	
	public static int longestCommonSubStringNaiveHelper(String sequence1, String sequence2, int i1, int i2, int count) {
		if(i1==sequence1.length() || i2==sequence2.length()) {
			return count;
		}
		
		//If characters match.
		if(sequence1.charAt(i1) == sequence2.charAt(i2)) {
			 count = longestCommonSubStringNaiveHelper(sequence1, sequence2, i1+1, i2+1, count+1);
		}
		
		//If they don't match.
		
		int c2 = longestCommonSubStringNaiveHelper(sequence1, sequence2, i1, i2+1, 0);
		int c3 = longestCommonSubStringNaiveHelper(sequence1, sequence2, i1+1, i2, 0);
		
		return Math.max(count, Math.max(c2, c3));
	}
	
	public static int longestCommonSubStringMemoize(String sequence1, String sequence2) {
		int i1 = 0;
		int i2 = 0;
		int count = 0;
		
		int maxLength = Math.max(sequence1.length(), sequence2.length());
		
		int[][][] memoize = new int[sequence1.length()][sequence2.length()][maxLength];
		return longestCommonSubStringMemoizeHelper(sequence1, sequence2, i1, i2, count, memoize);
	}
	
	public static int longestCommonSubStringMemoizeHelper(String sequence1,String sequence2,int i1,int i2,int count,int[][][] memoize){
		
		if(i1==sequence1.length() || i2==sequence2.length()) {
			return count;
		}
		
		if(memoize[i1][i2][count]==0) {
			
			//If characters match.
			if(sequence1.charAt(i1) == sequence2.charAt(i2)) {
				 count = longestCommonSubStringNaiveHelper(sequence1, sequence2, i1+1, i2+1, count+1);
			}
			
			//If they don't match.
			
			int c2 = longestCommonSubStringNaiveHelper(sequence1, sequence2, i1, i2+1, 0);
			int c3 = longestCommonSubStringNaiveHelper(sequence1, sequence2, i1+1, i2, 0);
			
			memoize[i1][i2][count] = Math.max(count, Math.max(c2, c3));
			
		}
		
		return memoize[i1][i2][count];
		
	}
	
	public static int longestCommonSubStringBottomUp(String sequence1, String sequence2) {
		int[][] bottomUpMatrix = new int[sequence1.length()+1][sequence2.length()+1];
		
		int maxLength = 0;
		
		for(int i=1;i<=sequence1.length();i++) {
			for(int j=1;j<=sequence2.length();j++) {
				if(sequence1.charAt(i-1)==sequence2.charAt(j-1)) {
					bottomUpMatrix[i][j] = 1 + bottomUpMatrix[i-1][j-1];
					maxLength = Math.max(maxLength, bottomUpMatrix[i][j]);
				}
		
			}
		}
		
		return maxLength;
		
	}
	
	public static String longestCommonSubStringBottomUpString(String sequence1, String sequence2) {
		
		int[][] bottomUpMatrix = new int[sequence1.length()+1][sequence2.length()+1];
		
		int maxLength = 0;
		int startIndex = -1;
		int endIndex = -1;
		
		for(int i=1;i<=sequence1.length();i++) {
			for(int j=1;j<=sequence2.length();j++) {
				if(sequence1.charAt(i-1)==sequence2.charAt(j-1)) {
					bottomUpMatrix[i][j] = 1 + bottomUpMatrix[i-1][j-1];
					if(maxLength<bottomUpMatrix[i][j]) {
						 startIndex = i;
						 endIndex = j;
						maxLength = bottomUpMatrix[i][j];
					}
				}
		
			}
		}
		
		if(startIndex==-1 && endIndex ==-1) {
			return "No common substring found";
		}
		
		System.out.println("maxLength: " + maxLength);
		System.out.println("startIndex: " + startIndex);
		System.out.println("endIndex: " + endIndex);
		
		StringBuilder sb = new StringBuilder();
		
		while(maxLength>=1) {
			sb.append(sequence1.charAt(startIndex-1));
			--startIndex;
			--endIndex;
			maxLength = bottomUpMatrix[startIndex][endIndex];
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		
		String sequence1 = "passpo";
		String sequence2 = "ppssp";
		int length = longestCommonSubstringNaive(sequence1, sequence2);
		System.out.println(length);
		
		int lengthMemoize = longestCommonSubStringMemoize(sequence1, sequence2);
		System.out.println(lengthMemoize);
		
		int lengthBottomUp = longestCommonSubStringBottomUp(sequence1, sequence2);
		System.out.println(lengthBottomUp);
		
		String commonSubstring = longestCommonSubStringBottomUpString(sequence1, sequence2);
		System.out.println(commonSubstring);
		
/*		String sequence3 = "aad";
		String sequence4 = "e";
		
		String commonSubstring2 = longestCommonSubStringBottomUpString(sequence3, sequence4);
		System.out.println(commonSubstring2);*/
		
	}

}
