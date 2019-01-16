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

 * */

public class QuickSort {
	
	public int[] quickSort(int[] arrayOfIntegers, int firstIndex, int lastIndex){

		if(firstIndex>=lastIndex){
			return arrayOfIntegers;
		}else{
		
		int pivot = partition(arrayOfIntegers, firstIndex, lastIndex);
		quickSort(arrayOfIntegers, firstIndex, pivot-1);
		quickSort(arrayOfIntegers, pivot+1, lastIndex);
		
		return arrayOfIntegers;
		}
		
	}
	
	public int partition(int[] arrayOfIntegers, int firstIndex, int lastIndex){
		
		int pivot = arrayOfIntegers[lastIndex];
		int i = firstIndex;
		
		int temp = 0;
		
		for(int j=firstIndex;j<lastIndex;j++){
			if(arrayOfIntegers[j]<=pivot){
				temp = arrayOfIntegers[j];
				arrayOfIntegers[j] = arrayOfIntegers[i];
				arrayOfIntegers[i] = temp;
				i++;
			}
		}
		temp = arrayOfIntegers[i]; // Storing the value at i
		arrayOfIntegers[i] = pivot; // Adding the pivot value at A[i]
/*		pivot = temp;*/
		arrayOfIntegers[lastIndex] = temp; // Adding the a[i] stored in temp to the last index.
		
		return i;	
			
	}

}
