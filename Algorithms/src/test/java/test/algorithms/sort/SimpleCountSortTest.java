package test.algorithms.sort;

import org.junit.Before;
import org.junit.Test;
import algorithms.sort.SimpleCountSort;

public class SimpleCountSortTest {

	private SimpleCountSort simpleCountSort;

	public String printArray(int[] arrayOfIntegers) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i <= arrayOfIntegers.length - 1; i++) {
			sb.append(arrayOfIntegers[i]);
			if (i < arrayOfIntegers.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	@Before
	public void setup() {
		simpleCountSort = new SimpleCountSort();
	}

	@Test
	public void testSimpleSort() {
		int[] arrayOfIntegers = { 1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1};
		int[] sortedArray = simpleCountSort.simpleSort(arrayOfIntegers);
		System.out.println(printArray(sortedArray));
	}
	
	@Test
	public void testSimpleSort4Values() {
		int[] arrayOfIntegers = {1,2,2,1,2,3,1,2,3,4,4,4,1,2,3,3,3,3,1,1,1,1,3,3,4,2,3,1,2};
		int[] sortedArray = simpleCountSort.simpleSort4Count(arrayOfIntegers);
		System.out.println(printArray(sortedArray));
	}
	
	

}
