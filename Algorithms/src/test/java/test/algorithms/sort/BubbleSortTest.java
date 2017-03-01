package test.algorithms.sort;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import algorithms.sort.BubbleSort;


public class BubbleSortTest {
	
	private BubbleSort bubbleSort;
	
	@Before
	public void beforeSetup() {
		bubbleSort = new BubbleSort();
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
	public void testBubbleSortClassic() {
		int[] arrayOfIntegers = {5,1,4,3,6,7};
		int[] arrayOfIntegersSorted = bubbleSort.bubbleSortClassic(arrayOfIntegers);

		assertThat(arrayOfIntegersSorted.length).isEqualTo(6);
		assertThat(printArray(arrayOfIntegersSorted)).isEqualTo("1, 3, 4, 5, 6, 7");
		
	}
	
	@Test
	public void testBubbleSortBetter() {
		int[] arrayOfIntegers = {5,1,4,3,6,7};
		int[] arrayOfIntegersSorted = bubbleSort.betterBubbleSort(arrayOfIntegers);
		assertThat(arrayOfIntegersSorted.length).isEqualTo(6);
		assertThat(printArray(arrayOfIntegersSorted)).isEqualTo("1, 3, 4, 5, 6, 7");
	}
	
	@Test
	public void testModifiedBubbleSort() {
		int[] arrayOfIntegers = {5,1,4,3,6,7};
		int[] arrayOfIntegersSorted = bubbleSort.modifiedBubbleSort(arrayOfIntegers);
		assertThat(arrayOfIntegersSorted.length).isEqualTo(6);
		assertThat(printArray(arrayOfIntegersSorted)).isEqualTo("1, 3, 4, 5, 6, 7");
	}

}
