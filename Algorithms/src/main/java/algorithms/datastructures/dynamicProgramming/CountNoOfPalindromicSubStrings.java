package algorithms.datastructures.dynamicProgramming;

public class CountNoOfPalindromicSubStrings {
	
	public static boolean isPalindrome(String sequence, int startIndex, int endIndex) {
		while(startIndex<=endIndex) {
			if(sequence.charAt(startIndex)!=sequence.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}
		
		return true;
	}

	
	public static int countNoOfPalindromicSubStringNaive(String sequence) {
		
		int count = sequence.length();
		
		for(int startIndex=1;startIndex<sequence.length();startIndex++) {
			for(int endIndex=0;endIndex<startIndex;endIndex++) {
				if(isPalindrome(sequence, startIndex, endIndex)) {
					count++;
				}	
			}
		}
		
		return count;
	}
	
	public static int countNoOfPalindromicSubStringsBottomUp(String sequence) {
		
		int count = 0;
		
		boolean[][] bottomUpMatrix = new boolean[sequence.length()][sequence.length()];
		for(int k=0;k<sequence.length();k++) {
			bottomUpMatrix[k][k] = true;
			count++;
		}
		
		for(int i=sequence.length()-1;i>=0;i--) {
			for(int j=i+1;j<sequence.length();j++) {
				if(sequence.charAt(i)==sequence.charAt(j)) {
					if(j-i==1 || bottomUpMatrix[i+1][j-1]) {
						bottomUpMatrix[i][j] = true;
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		String sequence = "aaa";
		int count = countNoOfPalindromicSubStringsBottomUp(sequence);
		System.out.println(count);
		
		int count2 = countNoOfPalindromicSubStringNaive(sequence);
		System.out.println(count2);
	}

}
