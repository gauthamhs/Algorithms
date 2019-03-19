package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.List;

public class MissingElement {
	
/*	To find the missing element, we can make the use of the following formula: 
	n*(n+1)/2
	This provides the sum of 1 to n.
	
	TimeComplexity: O(n)
	SpaceComplexity: O(1);
	*/
	public static int findMissingElementFormula(List<Integer> integerArray) {
		int sum = 0;
		int size = integerArray.size();
		int totalElements = size + 1;
		int sumFromFormula = totalElements*(totalElements+1)/2;
		for (Integer value : integerArray) {
			sum += value;
		}
		
		return sumFromFormula - sum;
	}
	
	public static int findMissingElementXOR(List<Integer> integerArray) {
		int sumFromArray = 0;
		int sumFromXOR = 0;
		int size = integerArray.size();
		int n = size + 1;
		for( int i=1;i<=n;i++) {
			sumFromXOR ^= i;
		}
		for(int value : integerArray) {
			sumFromArray ^= value;
		}

		return sumFromXOR ^ sumFromArray;
		
	}
	
	public static int findMissingElementBinarySearch(int[] integerArray) {
		
		if(integerArray==null || integerArray.length==0) {
			return -1;
		}
		
		if(integerArray.length==1) {
			return integerArray[0] + 1;
		}
		
		int arithmeticProgressionDiff = (integerArray[integerArray.length-1] - integerArray[0] )/ integerArray.length;
		arithmeticProgressionDiff = (arithmeticProgressionDiff<=0) ? 1 : arithmeticProgressionDiff;
		int startIndex = 0;
		int midIndex = 0;
		int endIndex = integerArray.length-1;
		
		return findMissingElementBinarySearchHelper(integerArray, arithmeticProgressionDiff, startIndex, midIndex, endIndex);
	
	}
	
	public static int findMissingElementBinarySearchHelper(int[] integerArray, int arithmeticProgressionDiff, int startIndex, int midIndex, int endIndex) {
		
		while(startIndex<=endIndex) {
			midIndex = startIndex + (endIndex-startIndex)/2;
			
			if(midIndex>0 && integerArray[midIndex] - integerArray[midIndex-1] != arithmeticProgressionDiff) {
				return integerArray[midIndex] - 1;
			} else if(midIndex+1<integerArray.length && integerArray[midIndex+1] - integerArray[midIndex] != arithmeticProgressionDiff) {
				return integerArray[midIndex] + 1;
			}
			
			if(integerArray[0] + arithmeticProgressionDiff*midIndex == integerArray[midIndex]) {
				return findMissingElementBinarySearchHelper(integerArray, arithmeticProgressionDiff, midIndex+1,midIndex, endIndex );
			} else {
				return findMissingElementBinarySearchHelper(integerArray, arithmeticProgressionDiff, startIndex, midIndex, midIndex-1 );
			}
			
	
		}
		
		return integerArray[midIndex] + 1;
		
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(1);
		integerArray.add(3);
		integerArray.add(4);
		integerArray.add(7);
		integerArray.add(6);
		integerArray.add(9);
		integerArray.add(2);
		integerArray.add(8);
		
		int missingElement = findMissingElementFormula(integerArray);
		int missingElement2 = findMissingElementXOR(integerArray);
		System.out.println(missingElement);
		System.out.println(missingElement2);
		
		// Binary Search
		
		int[] array = new int[]{-3,-2,-1,0,1,2,3,4};
		int missingElementBinary = findMissingElementBinarySearch(array);
		System.out.println(missingElementBinary);
		
		
		}
		
		
		
		
	}

