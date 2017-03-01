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

}
