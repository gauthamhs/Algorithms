package algorithms.sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*Implementation: Merge sort is a general purpose, efficient sorting algorithm that works on the 
  divide-and-conquer paradigm.
  
  Algorithm: 
  
  1) Divide by finding the midIndex between first and last index.
  2) Conquer by recursively sorting the two subproblems created by the divide step.
  In other words, sorting the subarray from first to midIndex, and midIndex+1 to the lastIndex.
  3) Combine the two sorted subarrays so that the array from first to lastIndex are sorted.
  
  Complexity:
  
  O(nLog(n)) in all cases.
  
  Form:
  
  T(n) = 2T(n/2) + T(n). Where T(n/2) is formed due to recursively sorting the sub-problems
  and T(n) is due to merging the two recursively sorted sub-arrays.
  
  */

public class MergeSort {

	public static int[] mergeSort(int[] arr, int first, int last) {

		if (first >= last) {
			return arr;
		}

		int middle = first + (last - first) / 2;

		mergeSort(arr, first, middle);
		mergeSort(arr, middle + 1, last);
		merge(arr, first, middle, last);

		return arr;

	}

	/*
	 * Merge method: This is used to merge the two recursively sorted arrays. In
	 * this method, we create two temporary arrays( left and right) to store the
	 * left and right part of the array for comparison. If the element in left or
	 * right array is smaller, we put that element in the main array and increment
	 * the index.
	 * 
	 */

	public static void merge(int[] arr, int first, int middle, int last) {
		Deque<Integer> firstBucket = new ArrayDeque<>();
		Deque<Integer> secondBucket = new ArrayDeque<>();
		
		for(int i=first;i<=middle;i++) {
			firstBucket.add(arr[i]);
		}
		
		for(int j=middle+1;j<=last;j++) {
			secondBucket.add(arr[j]);
		}
		
		int idx=first;
		while(!(firstBucket.isEmpty() || secondBucket.isEmpty())){
			if(firstBucket.peek()<=secondBucket.peek()) {
				arr[idx++] = firstBucket.remove();
			}else {
				arr[idx++] = secondBucket.remove();
			}
		}
		
		while(!firstBucket.isEmpty()) {
			arr[idx++]=firstBucket.remove();
		}
		
		while(!secondBucket.isEmpty()) {
			arr[idx++]=secondBucket.remove();
		}
		
	}

	public static void main(String[] args) {

		
		  int[] arrayOfIntegers =
		  {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,
		  8,15,6,2,5,
		  10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12
		  ,3,20,7,15,17,10,6,1,8,
		  18,4,9,3,20,17,8,15,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,
		  14,13,2,11,11};
		 
		int firstIndex = 0;
		int lastIndex = arrayOfIntegers.length - 1;
		System.out.println(Arrays.toString(MergeSort.mergeSort(arrayOfIntegers, firstIndex, lastIndex)));

		
	}

}
