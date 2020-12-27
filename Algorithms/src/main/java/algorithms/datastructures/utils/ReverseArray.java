package algorithms.datastructures.utils;

import java.util.Arrays;

// Time Complexity: O(n)

public class ReverseArray {
	
	public static int[] reverseArray(int[] array) {
		
		for(int i=0;i<array.length/2;i++) {
			int end = array.length-1-i;
			int temp = array[i];
			array[i] = array[end]; 
			array[end] = temp;
			
		}
		
		return array;
		
	}
	
	public static void main(String[] args) {
		int[] array = {3,5,7};
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(reverseArray(array)));
	}

}
