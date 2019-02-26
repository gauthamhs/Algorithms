package algorithms.datastructures.dynamicProgramming;

import java.util.Arrays;

public class MinimumSubsetSum {
	
	// For this problem, we need to identify the minimum difference that could be formed by subtracting
	// the sum of numbers.
	
	//A basic brute-force solution could be to try adding each element either in S1 or S2, 
	//to find the combination that gives the minimum sum difference between the two sets.
	public static int minimumSubsetDifference(int[] array) {
		if(array == null || array.length==0 ) {
			return -1;
		}
		int sum1 = 0;
		int sum2 = 0;
		return  minimumSubsetDifferenceHelper(array, sum1, sum2, array.length-1);
		
	}
	
	public static int minimumSubsetDifferenceHelper(int[] array, int sum1, int sum2, int currentIndex ) {
		if(currentIndex< 0) {
			return Math.abs(sum1-sum2);
		}
		
		int difference1 = minimumSubsetDifferenceHelper(array, sum1 + array[currentIndex], sum2, currentIndex-1);
		int difference2 = minimumSubsetDifferenceHelper(array, sum1, sum2 + array[currentIndex], currentIndex-1);
		
		int minDifference = Math.min(difference1, difference2);
		
		return minDifference;
		
	}
	
	public static int minimumSubsetDifferenceMemoize(int[] array) {
		
		if(array == null || array.length==0 ) {
			return -1;
		}
		int sum = 0;
		for(int i : array) {
			sum += i;
		}
		int sum1 = 0;
		int sum2 = 0;
		int[][] memoize = new int[array.length][sum+1];
		
		for(int[] arr: memoize) {
			Arrays.fill(arr, -1);
		}
		return  minimumSubsetDifferenceMemoizeHelper(array, sum1, sum2, array.length-1, memoize);
		
	}
	
	public static int minimumSubsetDifferenceMemoizeHelper(int[] array, int sum1, int sum2, int currentIndex, int[][] memoize) {
		
		if(currentIndex<0) {
			return Math.abs(sum2-sum1);
		}
		
		if(memoize[currentIndex][sum1]==-1) {
			int difference1 = minimumSubsetDifferenceMemoizeHelper(array, sum1+array[currentIndex], sum2, currentIndex-1, memoize);
			int difference2 = minimumSubsetDifferenceMemoizeHelper(array, sum1, sum2+array[currentIndex], currentIndex-1, memoize);
			memoize[currentIndex][sum1] = Math.min(difference1, difference2);
		}
		
		return memoize[currentIndex][sum1];
		
	}
	
	
	public static void main(String[] args) {
		int[] array1 = {1,2,3,9};
		int[] array2 = {1,2,7,1,5};
		int[] array3 = {32,1,4,6};
		
		int minSubSetDifference1 = minimumSubsetDifference(array1);
		int minSubSetDifference2 = minimumSubsetDifference(array2);
		int minSubSetDifference3 = minimumSubsetDifference(array3);
		System.out.println(minSubSetDifference1);
		System.out.println(minSubSetDifference2);
		System.out.println(minSubSetDifference3);
		System.out.println();
		
		int minSubSetDifferenceMemoize1 = minimumSubsetDifferenceMemoize(array1);
		int minSubSetDifferenceMemoize2 = minimumSubsetDifferenceMemoize(array2);
		int minSubSetDifferenceMemoize3 = minimumSubsetDifferenceMemoize(array3);
		System.out.println(minSubSetDifferenceMemoize1);
		System.out.println(minSubSetDifferenceMemoize2);
		System.out.println(minSubSetDifferenceMemoize3);
	}

}
