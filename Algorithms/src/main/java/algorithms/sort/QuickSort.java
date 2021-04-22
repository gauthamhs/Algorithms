package algorithms.sort;

import java.util.Arrays;

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
	
	public static int[] quickSort(int[] A) {
		return quickSort(A, 0, A.length-1);
	}
	
	public static int[] quickSort(int[] A, int low, int high){

		if(low>=high){
			return A;
		}
		
		int pivot = partition(A, low, high);
		quickSort(A, low, pivot-1);
		quickSort(A, pivot+1, high);
		
		return A;
	}
	
	public static int partition(int[] A, int low, int high){
		int pivot = high;
		
		int idx = low;
		for(int i=low;i<high;i++) {
			if(A[i]<=A[pivot]) {
				swap(A,i,idx);
				idx++;
			}
		}
		
		swap(A,pivot,idx);
		
		return idx;
		
			
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arrayOfIntegers = {9,7,5,10,6};
		System.out.println(Arrays.toString(quickSort(arrayOfIntegers)));
	}

}
