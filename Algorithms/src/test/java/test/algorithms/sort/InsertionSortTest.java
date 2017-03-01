package test.algorithms.sort;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import algorithms.sort.BubbleSort;
import algorithms.sort.InsertionSort;


public class InsertionSortTest {
	
	private InsertionSort insertionSort;
	
	@Before
	public void beforeSetup() {
		insertionSort = new InsertionSort();
	}
	
	public String printArray(int[] arrayOfIntegers){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arrayOfIntegers.length; i++) {
			sb.append(arrayOfIntegers[i]);
			if(i<arrayOfIntegers.length-1){
				sb.append(", ");
			}
		}
		return sb.toString();	
		
	}
	
	@Test
	public void testInsertionSort() {
		int[] arrayOfIntegers = {5,1,4,3,6,7};
		int[] arrayOfIntegersSorted = insertionSort.insertionSort(arrayOfIntegers);
		System.out.println(printArray(arrayOfIntegersSorted));
		
	}
	

}
