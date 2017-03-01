package algorithms.sort;

/*

Implementation: Selection Sort is a simple in-place comparison sorting algorithm which has 
low overhead(less code to set up the algorithm).
However, it is very inefficient and should be used if moving array elements is time consuming.
Selection sort algorithm is typically faster for small arrays(less than 20-1000 elements) and almost 
always performs better than bubble sort,but is usually outperformed by other efficient arrays 
such as mergesort for larger arrays.

Complexity: O(n2)
Selection sort will run in O(n2) regardless of whether the array is already sorted or not.

Here are the steps to execute the algorithm:

1) Set the smallest value = i = 0;
2) Now check the unsorted array to find the minimum value.
3) Once found, swap the left most element with the smallest element. This element becomes a part of the sorted array.
4)Continue through the unsorted list to find the minimum element and swap it with the left most element
(the swapped element again becomes a part of the sorted array).
5) The array is sorted before or during the final iteration of i.

*/

public class SelectionSort {

	public int[] selectionSort(int[] arrayOfIntegers) {

		int smallest = 0;
		int temp = 0;

		for (int i = 0; i < arrayOfIntegers.length - 1; i++) {
			smallest = i;
			for (int j = i + 1; j < arrayOfIntegers.length; j++) {
				if (arrayOfIntegers[smallest] > arrayOfIntegers[j]) {
					smallest = j;
				}
			}

			if (arrayOfIntegers[smallest] != arrayOfIntegers[i]) {

				temp = arrayOfIntegers[smallest];
				arrayOfIntegers[smallest] = arrayOfIntegers[i];
				arrayOfIntegers[i] = temp;

			}

		}

		return arrayOfIntegers;

	}

}