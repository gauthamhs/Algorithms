package test.algorithms.sort;

import org.junit.Before;
import org.junit.Test;
import algorithms.sort.CountingSort;

public class CountingSortTest {

private CountingSort countingSort;

public int findMax(int[] arrayOfIntegers){
int maxNum = 0;
for(int i=0;i<arrayOfIntegers.length;i++){
if(arrayOfIntegers[i]>maxNum){
maxNum = arrayOfIntegers[i];
}
}
return maxNum;
}

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
countingSort = new CountingSort();
}

@Test
public void testTotalNoOfOccurrences(){
	int[] arrayOfIntegers = {4,1,5,0,1,6,5,1,5,3};	
	int maxVal = findMax(arrayOfIntegers);
	int[] countArray = countingSort.countOccurrences(arrayOfIntegers, maxVal);
	System.out.println(printArray(countArray));
}

@Test
public void testCountingSort(){
int[] arrayOfIntegers = {4,1,5,0,1,6,5,1,5,3};
int maxVal = findMax(arrayOfIntegers);
System.out.println(printArray(arrayOfIntegers));
int[] countArray = countingSort.countOccurrences(arrayOfIntegers, maxVal);
System.out.println(printArray(countArray));
int[] sortedArray = countingSort.countingSort(arrayOfIntegers, countArray);
System.out.println(printArray(sortedArray));
}

@Test
public void testMax(){
int[] arrayOfIntegers = {4,1,5,0,1,6,5,1,5,3};
int maxVal = findMax(arrayOfIntegers);
System.out.println(maxVal);
}

}
