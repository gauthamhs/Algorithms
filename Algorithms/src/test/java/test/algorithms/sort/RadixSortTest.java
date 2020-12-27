package test.algorithms.sort;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import algorithms.sort.RadixSort;

public class RadixSortTest {
	
	private RadixSort radixSort;

public String printArray(int[] arrayOfIntegers){

StringBuilder sb = new StringBuilder("");
for(int i = 0;i<=arrayOfIntegers.length-1;i++){
sb.append(arrayOfIntegers[i]);
if(i<arrayOfIntegers.length - 1){
sb.append(", ");
}
}
return sb.toString();

}

@Before
public void setup(){
	radixSort = new RadixSort();
}

@Test
public void testRadixSort(){
int[] arrayOfIntegers = {35, 1003, 31, 45};
System.out.println(Arrays.toString(arrayOfIntegers));
int[] sortedArray = radixSort.radixSort(arrayOfIntegers);
System.out.println(printArray(sortedArray));
}

}