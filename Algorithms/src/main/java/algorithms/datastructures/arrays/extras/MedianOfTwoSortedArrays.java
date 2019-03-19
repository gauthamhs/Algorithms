package algorithms.datastructures.arrays.extras;

public class MedianOfTwoSortedArrays {
	
	public static double findMedianOfTwoSortedArrays(int[] sortedArray1, int[] sortedArray2) {
		
		int totalLength = sortedArray1.length + sortedArray2.length;
		
		if(totalLength%2==1) {
			return findMedian(sortedArray1, sortedArray2, 0, 0, totalLength/2 + 1); 
			// We need to find median for odd length. i.e., if length = 7, k = median(4);
		} else {
			return (findMedian(sortedArray1, sortedArray2, 0, 0, totalLength/2) + 
				   findMedian(sortedArray1, sortedArray2, 0, 0, totalLength/2 + 1))/2.0; 
			// We need to find median for even length. i.e., if length = 6, k = median(3) + median(4)/2;
		}
		
	}
	
	// returns the median value
	public static int findMedian(int[] sortedArray1, int[] sortedArray2, int s1, int s2, int medianIndex) {
		if(s1>=sortedArray1.length) {
			return sortedArray2[s2 + medianIndex-1];
		}
		
		if(s2>=sortedArray2.length) {
			return sortedArray1[s1 + medianIndex-1];
		}
		
		if(medianIndex==1) {
			return Math.min(sortedArray1[s1], sortedArray2[s2]);
		}
		
		int i1 = s1 + medianIndex/2 - 1; // Index of 1st Array
		int i2 = s2 + medianIndex/2 - 1; // Index of 2nd Array
		
		int val1 = (i1<sortedArray1.length) ? sortedArray1[i1] : Integer.MAX_VALUE;
		int val2 = (i2<sortedArray2.length) ? sortedArray2[i2] : Integer.MAX_VALUE; 
		
		if(val1<val2) {
			return findMedian(sortedArray1, sortedArray2, s1 + medianIndex/2, s2, medianIndex - medianIndex/2);
			// Traverse the first Array and move the startIndex to medianindex/2 and reduce the search to medianIndex/2
		} else {
			return findMedian(sortedArray1, sortedArray2, s1, s2 + medianIndex/2, medianIndex - medianIndex/2);
			// Traverse the second Array and reduce the search to half
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] sortedArray1 = {1,9};
		int[] sortedArray2 = {3};
		
		double median = findMedianOfTwoSortedArrays(sortedArray1, sortedArray2);
		System.out.println(median);
		
		
	}

}
