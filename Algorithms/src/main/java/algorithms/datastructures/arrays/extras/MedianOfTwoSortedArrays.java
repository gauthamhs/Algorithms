package algorithms.datastructures.arrays.extras;


// There are two ways to solve the median of two arrays problem: 

// Merge the two sorted arrays into a new array and find the median
// Time Complexity: O(n)
// Space Complexity: O(n)

// The second way to do is to do a binary search over the two sorted arrays:
// Algorithm: 
// 1) First find the total length of the two arrays
// 2) If odd, median is the middle element. Eg: 4,5,6 median is 5 which is 2nd element. 
//    If its even, its the average of the two middle elements: 4 5 6 7 ->5+6/2 or 2nd + 3rd element/2
// 3) Once we have determined that, our goal is to find the individual values for these and calculate the median
// Edge cases: 1st array is empty, 2nd array is empty, both are empty, both have only one element(in which case we have to take math.min of both)
// Finally, we iterate our individual pointers of both arrays to median/2 while reducing our search index to -median/2 and then find the median
public class MedianOfTwoSortedArrays {
	
	public static double findMedianOfTwoSortedArrays(int[] sortedArray1, int[] sortedArray2) {
		
		int totalLength = sortedArray1.length + sortedArray2.length;
		
		if(totalLength%2==1) {
			return findMedian(sortedArray1, sortedArray2, 0, 0, totalLength/2 + 1); 
			// We need to find median for odd length. i.e., if length = 7, k = median(4th element);
		} else {
			return (findMedian(sortedArray1, sortedArray2, 0, 0, totalLength/2) + 
				   findMedian(sortedArray1, sortedArray2, 0, 0, totalLength/2 + 1))/2.0; 
			// We need to find median for even length. i.e., if length = 6, k = median(3rd element) + median(4th element)/2;
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
		
		
		// IfA(k/2 - 1)<B(k/2-1), Then we can get rid of first k/2-1 values of A. 
		// That's the reason we move A index position to + medianIndex/2 while reducing search to medianIndex/2;
		if(val1<val2) {
			return findMedian(sortedArray1, sortedArray2, s1 + medianIndex/2, s2, medianIndex - medianIndex/2);
			// Traverse the first Array and move the startIndex to medianindex/2 and reduce the search to medianIndex/2
		} else {
			return findMedian(sortedArray1, sortedArray2, s1, s2 + medianIndex/2, medianIndex - medianIndex/2);
			// Traverse the second Array and reduce the search to half
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] sortedArray1 = {1,2,3,4};
		int[] sortedArray2 = {5,6,7,8,9};
		
		double median = findMedianOfTwoSortedArrays(sortedArray1, sortedArray2);
		System.out.println(median);
		
		
	}

}
