package test.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import algorithms.sort.QuickSort;

public class QuickSortTest {
	
	private QuickSort quickSort;
	
	@Before
	public void setup(){
		quickSort = new QuickSort();
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
	public void testQuickSortPartition(){
		int[] arrayOfIntegers = {12,7,14,9,10,11};

		int pivot = quickSort.partition(arrayOfIntegers, 0, arrayOfIntegers.length-1);
		System.out.println(pivot);
		
	}
	
	@Test
	public void testQuickSort(){
		int[] arrayOfIntegers = {9,7,5,11,12,2,14,3,10,6};
		quickSort.quickSort(arrayOfIntegers, 0, arrayOfIntegers.length-1);
		System.out.println(printArray(arrayOfIntegers));
	}

}
