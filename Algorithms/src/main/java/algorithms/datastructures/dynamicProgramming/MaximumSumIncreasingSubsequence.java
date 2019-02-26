package algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class MaximumSumIncreasingSubsequence {
	
	public static int maximumIncreasingSubSequenceNaive(int[] array) {
		
		int previousIndex = -1;
		int currentIndex = 0;
		int sum = 0;
		return maximumIncreasingSubsequenceNaiveHelper(array, previousIndex, currentIndex, sum);
	}
	
	public static int maximumIncreasingSubsequenceNaiveHelper(int[] array, int previousIndex, int currentIndex, int sum) {
		if(currentIndex==array.length) {
			return sum;
		}
		
		int s1 = sum;
		
		if(previousIndex == -1 || array[currentIndex]>=array[previousIndex]) {
			s1 = maximumIncreasingSubsequenceNaiveHelper(array, currentIndex, currentIndex+1, sum + array[currentIndex]);
		}
		
		int s2 = maximumIncreasingSubsequenceNaiveHelper(array, previousIndex, currentIndex+1, sum);
		
		return Math.max(s1, s2);
	}
	
	public static int maximumIncreasingSubsequence(int[] array) {
		if(array==null || array.length==0) {
			return 0;
		}
		
		Integer[] maxLength = new Integer[array.length];
		for(int k=0;k<array.length;k++) {
			maxLength[k] = array[k];
		}
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<i;j++) {
				if(array[i]>=array[j]) {
					maxLength[i] = Math.max(maxLength[i], array[i] + maxLength[j]);
				}
			}
		}
		
		return Collections.max(Arrays.asList(maxLength));
	}

	public static void main(String[] args) {
		
		int[] array = new int[]{4,1,2,6,10,1,12};
		int[] array2 =  new int[]{1,3,8,4,14,6,14,1,9,4,13,3,11,17,29};
		int misNaive = maximumIncreasingSubSequenceNaive(array);
		int misNaive2 = maximumIncreasingSubSequenceNaive(array2);
		System.out.println(misNaive);
		System.out.println(misNaive2);
		
		int mis = maximumIncreasingSubsequence(array);
		int mis2 = maximumIncreasingSubsequence(array2);
		System.out.println(mis);
		System.out.println(mis2);
		
	}
}
