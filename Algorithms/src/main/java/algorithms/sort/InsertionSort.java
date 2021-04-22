package algorithms.sort;

public class InsertionSort {
	
/*	Insertion sort is a simple sorting algorithm that sorts the array one item at a time. 
	It is not efficient for larger list, but is much efficient for shorter list
	than other sorting algorithms such as bubble sort and selection sort.
	
	Algorithm:

    Insertion sort sorts the data one item at a time. It grows a sorted output list. 
    1) During each iteration, insertion sort removes one element from unsorted input data, 
    check the location it belongs to in the sorted list and puts it there. 
    2) It does until no input elements in the unsorted array remain.
	
	Complexity:

    Best Case: O(n)
    Array is sorted. During each iteration, the first element is compared with the 
    right-most element of the sorted array.

    Worst Case: O(n2)
    Array is sorted in reverse order. In this case, during each iteration, 
    the element scans and shifts the entire sorted subsection of the array.

    Average case: O(n2)
    Array is not sorted and 'k' no of swaps need to be performed. Therefore the complexity would be 'nk'.
    
    It works on a key algorithm. key = A[i], and j precedes it. If (A[j]>key) keep sorting and change the key to the lowest val;
	*/
	public int[] insertionSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int j=i;
			while(j>0&&arr[j-1]>arr[j]) {
				swap(arr, j, j-1);
				j = j-1;
			}
		}
		
		return arr;
			
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
