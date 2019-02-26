package algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class MinimumInsertionDeletionToSortArray {
	
	public static int minimumInsertionDeletionToMakeSorted(int[] array) {
		int lis = longestIncreasingSubsequence(array);
		return array.length - lis;
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
		int[] array = new int[]{4,2,3,6,10,1,12};
		int[] array2 = new int[] {3,2,1,0};
		
		int minInsertDeletionForSorting = minimumInsertionDeletionToMakeSorted(array);
		System.out.println(minInsertDeletionForSorting);
		
		int minInsertDeletionForSorting2 = minimumInsertionDeletionToMakeSorted(array2);
		System.out.println(minInsertDeletionForSorting2);

	}

}
