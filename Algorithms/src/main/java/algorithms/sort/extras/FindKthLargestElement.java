package algorithms.sort.extras;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElement {

	public static int findKthLargestSorting(int[] array, int k) {

		Arrays.sort(array);
		return array[array.length - k];

	}

	public static int findKthLargestMinHeap(int[] array, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			minHeap.add(array[i]);
		}

		for (int j = k; j < array.length; j++) {
			minHeap.add(array[j]);
			if (minHeap.size() > k) {
				minHeap.remove();
			}
		}

		return minHeap.peek();
	}

	public static int findKthLargestQuickSort(int[] arr, int low, int high, int k) {
		

		if (k > 0 && k <= high - low + 1) {

			int pivot = partitionForQuickSort(arr, low, high);

			if (pivot - low == k - 1)
				return arr[pivot];

			if (pivot - low > k - 1)
				return findKthLargestQuickSort(arr, low, pivot - 1, k);

			return findKthLargestQuickSort(arr, pivot + 1, high, k - pivot + low - 1);
		}

		return Integer.MAX_VALUE;
	}

	public static int partitionForQuickSort(int[] array, int firstIndex, int lastIndex) {
		int pivot = array[lastIndex];
		int i = firstIndex;

		for (int j = firstIndex; j < lastIndex; j++) {
			if (array[j] <= pivot) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}

		int temp = array[i];
		array[i] = pivot;
		array[lastIndex] = temp;

		return i;
	}

	public static void main(String[] args) {
		int[] array = { 9, 10, 4, 5, 16, 33, 22, 11, 56 };
		int findKthSort = findKthLargestSorting(array, 4);
		System.out.println(findKthSort);

		int findKthMinheap = findKthLargestMinHeap(array, 4);
		System.out.println(findKthMinheap);
		
		int k=4;

		int findKthQuickSort = findKthLargestQuickSort(array, 0, array.length - 1 ,k);
		System.out.println(findKthQuickSort);
	}

}
