package algorithms.sort;


/*Bubble Sort is a simple sorting algorithm.  The bubble sort works by iterating down an array to be sorted from the 
first element to the last, comparing each pair of elements and switching their positions if necessary. 
This process is repeated as many times as necessary, until the array is sorted. 
The name "Bubble Sort" is stated due to a fact that the largest element will bubble to the top of the list.

Complexity:

Worst Case : O(n2)
Best Case: O(n) for the most efficient Bubble Sort.*/

public class BubbleSort {
	
/*	Implementation 1: This is the simplest implementation of a Bubble Sort Algorithm. The array is iterated
	from the first element to the last element and positions of the elements are swapped if necessary.
	However, this is the least efficient method since the iteration doesn't check if the elements are already
	swapped or not.*/
	
	public int[] bubbleSortClassic(int[] arrayOfIntegers){
		
		int temp = 0;
		
		for (int i = 0; i < arrayOfIntegers.length; i++) {
			for (int j = 0; j < arrayOfIntegers.length-1; j++) {
				if(arrayOfIntegers[j]>arrayOfIntegers[j+1]){
					temp = arrayOfIntegers[j+1];
					arrayOfIntegers[j+1] = arrayOfIntegers[j];
					arrayOfIntegers[j] = temp;
				}
			}
			
		}
		
		return arrayOfIntegers;
		
	}
	
/*	Implementation 2: This is a better implementation of the Classic Bubble Sort. Since we know that
	the highest element would be "Bubbled" to the top of the list, we need to only sort elements in the unsorted array
	that precedes it  thereby decreasing the no of iterations and swappings.
	 */
	
	public int[] betterBubbleSort(int[] arrayOfIntegers){
		
		int temp = 0;
		
		for (int i = 0; i < arrayOfIntegers.length; i++) {
			for (int j = 0; j < arrayOfIntegers.length-1-i; j++) {
				if(arrayOfIntegers[j]>arrayOfIntegers[j+1]){
					temp = arrayOfIntegers[j+1];
					arrayOfIntegers[j+1] = arrayOfIntegers[j];
					arrayOfIntegers[j] = temp;
				}
			}
			
		}
		
		return arrayOfIntegers;
		
	}
	
	/*	Implementation 3: This is called as the modified Bubble Sorting algorithm which is the a more efficient
	 * variant of Bubble sort algorithm. Here we assign a flag to determine whether the array has already been sorted.
	 * If so, we break out of the loop to reduce iterations.
	 */
	
	public int[] modifiedBubbleSort(int[] arrayOfIntegers){
		
		int temp = 0;
		
		for (int i = 0; i < arrayOfIntegers.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < arrayOfIntegers.length-1-i; j++) {
				if(arrayOfIntegers[j]>arrayOfIntegers[j+1]){
					swapped = true;
					temp = arrayOfIntegers[j+1];
					arrayOfIntegers[j+1] = arrayOfIntegers[j];
					arrayOfIntegers[j] = temp;
				}
			}
			if(!swapped){
				break;
			}
			
		}
		
		return arrayOfIntegers;
		
	}

}
