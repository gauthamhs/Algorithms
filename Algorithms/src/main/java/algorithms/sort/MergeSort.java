package algorithms.sort;

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

	public int[] mergeSort(int[] arrayOfIntegers, int firstIndex, int lastIndex) {

		if (firstIndex >= lastIndex) {
			return arrayOfIntegers;
		}

		int midIndex = firstIndex + (lastIndex - firstIndex) / 2;
		mergeSort(arrayOfIntegers, firstIndex, midIndex);
		mergeSort(arrayOfIntegers, midIndex + 1, lastIndex);
		merge(arrayOfIntegers, firstIndex, midIndex, lastIndex);

		return arrayOfIntegers;

	}

	/*
	 * Merge method: This is used to merge the two recursively sorted arrays. In
	 * this method, we create two temporary arrays( left and right) to store the
	 * left and right part of the array for comparison. If the element in left or
	 * right array is smaller, we put that element in the main array and increment
	 * the index.
	 * 
	 */

	public int[] merge(int[] arrayOfIntegers, int firstIndex, int midIndex, int lastIndex) {

		int leftArraySize = midIndex - firstIndex + 1;
		int rightArraySize = lastIndex - midIndex;

		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; i++) {
			leftArray[i] = arrayOfIntegers[firstIndex + i];
		}

		for (int j = 0; j < rightArraySize; j++) {
			rightArray[j] = arrayOfIntegers[midIndex + 1 + j];
		}

		int k = 0;
		int l = 0;

		
		  for(int m = firstIndex;m<=lastIndex;m++){
		  
			/*
			 * If there are no more smaller elements in the right array, when we increment
			 * the pointer, we get an ArrayIndexOutOfBounds Exception. Therefore, we need a
			 * check to see if there are no more smaller elements in the right array.
			 */
			  
		  if((l>=rightArraySize)||(k<leftArraySize&& leftArray[k]<=rightArray[l])){
		  arrayOfIntegers[m] = leftArray[k]; k++; } 
		  else{ arrayOfIntegers[m] =
		  rightArray[l]; l++; } }
		 


		return arrayOfIntegers;

	}

}
