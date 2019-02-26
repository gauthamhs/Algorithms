package algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	
	public static int longestIncreasingSubsequenceNaive(int[] array) {
		if(array==null || array.length==0) {
			return 0;
		}
		
		int previousIndex = -1;
		int currentIndex = 0;
		
		return longestIncreasingSubsequenceNaiveHelper(array, previousIndex, currentIndex);
	}
	
	public static int longestIncreasingSubsequenceNaiveHelper(int[] array, int previousIndex, int currentIndex) {
		
		if(currentIndex==array.length) {
			return 0;
		}
		
		int c1 = 0;
		if(previousIndex==-1 || array[currentIndex]>=array[previousIndex]) {
			 c1 = 1 +  longestIncreasingSubsequenceNaiveHelper(array, currentIndex, currentIndex+1);
		}
		
		int c2 = longestIncreasingSubsequenceNaiveHelper(array, previousIndex, currentIndex+1);
		
		return Math.max(c1, c2);
	}
	
	public static int longestIncreasingSubsequence(int[] array) {
		Integer[] maxLength = new Integer[array.length];
		Arrays.fill(maxLength, 1);
		
		for(int i=1;i<array.length;i++) {
			for(int j=0;j<i;j++) {
				if(array[i]>=array[j]) {
					maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
				}
			}
		}
		
		return Collections.max(Arrays.asList(maxLength));
	}
	
	public static void main(String[] args) {
		int[] array = {4,2,3,6,10,1,12};
		
		int LIS = longestIncreasingSubsequence(array);
		System.out.println(LIS);
		
		int LIS2 = longestIncreasingSubsequenceNaive(array);
		System.out.println(LIS2);
	}

}
