package test.algorithms.sort;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import algorithms.sort.MergeSort;

public class MergeSortTest {
	
	private MergeSort mergeSort;
	
	@Before
	public void setup(){
		mergeSort = new MergeSort();
	}
	
	public String printArray(int[] arrayOfIntegers){
		StringBuilder sb = new StringBuilder();
		if(arrayOfIntegers.length==0){
			sb.append("Array is empty");
		}
		for (int i = 0; i < arrayOfIntegers.length; i++) {
			sb.append(arrayOfIntegers[i]);
			if(i<arrayOfIntegers.length-1){
				sb.append(", ");
			}
		}
		return sb.toString();
			
	}

	@Test
	public void testMergeSort(){
		//int[] arrayOfIntegers = {1, 23, 55, 55, 55, 44, 32, 12, 9, 3, 7, 14, 11, 11, 6, 2, 10, 5};
		
		int[] arrayOfIntegers = {6,4,5,10,9};
		
		/*
		 * int[] arrayOfIntegers =
		 * {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,
		 * 8,15,6,2,5,
		 * 10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12
		 * ,3,20,7,15,17,10,6,1,8,
		 * 18,4,9,3,20,17,8,15,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,
		 * 14,13,2,11,11};
		 */
	    int firstIndex = 0;
		int lastIndex = arrayOfIntegers.length - 1;
		mergeSort.mergeSort(arrayOfIntegers, firstIndex, lastIndex);
		System.out.println(printArray(arrayOfIntegers));
	}
	
	
}
