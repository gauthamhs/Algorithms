package test.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import algorithms.sort.SelectionSort;

public class SelectionSortTest {

private SelectionSort selectionSort;

public void printArray(int[] arrayOfIntegers){
StringBuilder sb = new StringBuilder("");
for (int i = 0; i < arrayOfIntegers.length; i++) {
sb.append(arrayOfIntegers[i]);
if(i<arrayOfIntegers.length-1){
sb.append(", ");
}
}

System.out.println(sb.toString());
}

@Before
public void setup() throws Exception{
selectionSort = new SelectionSort();

}

@Test
public void selectionSort() {

int[] arrayInt = {-51, 0, -32, 11, 53, 32, 55, 74, 19, 66};
int[]arrayIntSorted = selectionSort.selectionSort(arrayInt);
printArray(arrayIntSorted);
}

}
