package algorithms.datastructures.arrays.extras;

import java.util.Arrays;

public class MoveZeroesToRight {
	
	
	// In this method, we are moving zeroes to right. We can do it two ways: 
	// 1) Use temp array
	// 2) In place by counting non-zero elements
	
	// Algorithm using O(n) time complexity and O(n) space complexity.
	public static int[] moveZeroesToRight(int[] array) {
		int length = array.length;
		
		int[] tempArray = new int[array.length];
		
		int j = 0;
		
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				tempArray[j] = array[i];
				j++;
			}
		}
		
		while(j<length) {
			tempArray[j] = 0;
			j++;
		}
		
		return tempArray;
		
	}
	
	public static int[] moveZeroestoRightConstantSpace(int[] array) {
		int length = array.length;
		
		int j=0;
		
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				array[j] = array[i];
				j++;
			}
		}
		
		while(j<length) {
			array[j] = 0;
			j++;
		}
		
		return array;
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {1,0,3,5,0,0,2,0,2,1,0,0,9,0,0,4,3,2};
		int[] zeroRightArray = moveZeroesToRight(array);
		System.out.println(Arrays.toString(zeroRightArray));
		int[] zeroRightArray2 = moveZeroestoRightConstantSpace(zeroRightArray);
		System.out.println(Arrays.toString(zeroRightArray2));
		
	}

}
