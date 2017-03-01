package test.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import algorithms.sort.CombSort;

public class CombSortTest {

private CombSort combSort;

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
combSort = new CombSort();

}

@Test
public void combSort() {

int[] arrayInt = {-51, 0, -32, 11, 53, 32, 55, 74, 19, 66};
int[] arrayIntSorted = combSort.combSort(arrayInt);
printArray(arrayIntSorted);
}

}