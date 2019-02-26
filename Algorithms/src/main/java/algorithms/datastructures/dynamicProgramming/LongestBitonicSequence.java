package algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSequence {
	
	// A bitonic sequence is the one that is monotonically increasing then decreasing.
	// To find the longest Bitonic sequence, we need to find the length of Longest increasing subsequence and LDS reverse; 
	
	
	public static int longestBitonicSubsequence(int[] array) {
		if(array==null || array.length==0) {
			return 0;
		}
		
		int maxLength = 1;
		
		Integer[] longestDecreasingSubsequence = longestIncreasingSubsequence(array);
		Integer[] longestDecreasingSubsequenceReverse = longestIncreasingSubsequenceReverse(array);
		
		for(int i=0;i<array.length;i++) {
			maxLength = Math.max(maxLength, longestDecreasingSubsequence[i] + longestDecreasingSubsequenceReverse[i] - 1);
		}
		
		return maxLength;
	}
	
	public static Integer[] longestIncreasingSubsequence(int[] array) {
		Integer[] maxLength = new Integer[array.length];
		Arrays.fill(maxLength, 1);
		
		for(int i=1;i<array.length;i++) {
			for(int j=0;j<i;j++) {
				if(array[i]>=array[j]) {
					maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
				}
			}
		}
		
		return maxLength;
	}
	
	public static Integer[] longestIncreasingSubsequenceReverse(int[] array) {
		Integer[] maxLength = new Integer[array.length];
		Arrays.fill(maxLength, 1);
		
		for(int i = array.length-2;i>=0;i--) {
			for(int j=array.length-1;j>i;j--) {
				if(array[i]>=array[j]) {
					maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
				}
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{4,2,3,6,10,1,12};
		int longestBitonicSubsequence = longestBitonicSubsequence(array);
		System.out.println(longestBitonicSubsequence);
	}
	
	

}
