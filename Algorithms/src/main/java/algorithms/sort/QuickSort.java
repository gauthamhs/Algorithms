package algorithms.sort;

import java.util.Collections;

/*Quick Sort:

Quicksort(also known as partition-exchange sort) is a highly efficient sorting algorithm that 
is based on the divide-and-conquer paradigm and is one of the most commonly used sorting algorithm.
Quicksort is an in-place sorter meaning that it requires less memory to perform the 
swapping of elements.

Complexity:

Best case: O(n(logN))

Average case: O(nLog(n)).

Worst Case: Although rare, the worst case is O(n2).

Algorithm:

- Divide by choosing any element as pivot from the subarray.
All the elements smaller than the pivot should be on the left of the pivot and all elements 
greater than the pivot should be on the right side of pivot. 
Note the elements on the left or right side are not sorted in any particular order.
- Conquer by recursively sorting the elements to the left and right of the pivot.
- No need to Combine !. The elements would have already been sorted.

Quick sort is in-place as its space efficient, but not stable(relative ordering of records with respect to position)

 * */

public class QuickSort {
	
	public int[] quickSort(int[] A) {
		return quickSort(A, 0, A.length-1);
	}
	
	public int[] quickSort(int[] A, int low, int high){

		if(low>=high){
			return A;
		}else{
		
		int pivot = partition(A, low, high);
		quickSort(A, low, pivot-1);
		quickSort(A, pivot+1, high);
		
		return A;
		}
	}
	
	public int partition(int[] A, int low, int high){
		

		int pivot = A[high];
		//int pivotElement = ((int)Math.random()*(high-low) + 1) + low;
		//int pivotRandom = A[pivotElement];
		
		int i=low;
		int j=high;
		
		//Keep running the low until the two indices meet
		while(i<=j) {
			//If A[i] is smaller than pivot, we need to move the index as this is already in place
			while(A[i]<pivot) {
				++i;
			}
			//If A[j] is greater/equal to pivot, do nothing as its already in place
			while(A[j]>=pivot) {
				--j;
			}
			if(i<=j) { // This condition is needed if j goes below i. If i<j, we can swap i and j and keep moving until two indices meet
			int temp = A[j];
			A[j]=A[i];
			A[i]=temp;
			}
		}
		
		//Once the loop is complete, swap the pivot element with A[low] and return low as the pivot index
		int temp = A[i];
		A[i]=pivot;
		A[high]=temp;
		return i;	
			
	}

}
