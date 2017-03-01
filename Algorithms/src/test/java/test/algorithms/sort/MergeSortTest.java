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
		int[] arrayOfIntegers = {12, 9, 3, 7, 14, 11, 6, 2, 10, 5};
		int firstIndex = 0;
		int lastIndex = arrayOfIntegers.length - 1;
		mergeSort.mergeSort(arrayOfIntegers, firstIndex, lastIndex);
		System.out.println(printArray(arrayOfIntegers));
	}
	
	
}
