package algorithms.datastructures.dynamicProgramming;

public class PalindromePartition {
	
	public static int minimumCutsNeeded(String sequence) {
		int startIndex = 0;
		int endIndex = sequence.length()-1;
		
		return minimumCutsNeededHelper(sequence, startIndex, endIndex);
	}
	
	public static int minimumCutsNeededHelper(String sequence, int startIndex, int endIndex) {
		if(startIndex>=endIndex || isPalindrome(sequence, startIndex, endIndex)) {
			return 0;
		}
		
		int minCutsNeeded = endIndex - startIndex;
		
		for(int i=startIndex;i<=endIndex;i++) {
			if(isPalindrome(sequence, startIndex, i)) {
				minCutsNeeded = Math.min(minCutsNeeded, 1 + minimumCutsNeededHelper(sequence, i+1, endIndex));
			}
		}
		
		return minCutsNeeded;
		
		
	}
	
	public static boolean isPalindrome(String sequence, int startIndex, int endIndex) {
		while(startIndex<endIndex) {
			if(sequence.charAt(startIndex)!=sequence.charAt(endIndex)) {
				return false;
			}
			
			startIndex++;
			endIndex--;
			
		}

		
		return true;
	}
	
	public static void main(String[] args) {
		String sequence = "abdbca";
		int mincutsNeeded = minimumCutsNeeded(sequence);
		System.out.println(mincutsNeeded);
	}

}
