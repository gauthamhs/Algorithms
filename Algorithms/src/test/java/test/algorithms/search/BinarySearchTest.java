package test.algorithms.search;

import static org.assertj.core.api.Assertions.*;


import org.junit.Before;
import org.junit.Test;

import algorithms.search.BinarySearch;

public class BinarySearchTest {

private BinarySearch binarySearch;

@Before
public void setup() throws Exception{
binarySearch = new BinarySearch();

}

@Test
public void testBinarySearchSuccess(){
int[] arrayInt = {0, 5, 6, 7, 11, 17, 18, 18, 20, 23, 25, 26, 27};
int value = 20;
int valueFromBinarySearch = binarySearch.binarySearch(arrayInt, value);
assertThat(valueFromBinarySearch).isEqualTo(8);

}

@Test
public void testBinarySearchEmpty(){
int[] arrayInt = {};
int value = 20;
int valueFromBinarySearch = binarySearch.binarySearch(arrayInt, value);
assertThat(valueFromBinarySearch).isEqualTo(-1);
}

@Test
public void testBinarySearchValueNotFound(){
int[] arrayInt = {0, 5, 6, 7, 11, 17, 18, 18, 20, 23, 25, 26, 27};
int value = 21;
int valueFromBinarySearch = binarySearch.binarySearch(arrayInt, value);
assertThat(valueFromBinarySearch).isEqualTo(-1);
}

@Test
public void testBinarySearchRecursionSuccess(){
int[] arrayOfIntegers = {0, 5, 6, 7, 11, 17, 18, 18, 20, 23, 25, 26, 27};
int value = 20;
int firstIndex = 0;
int lastIndex = arrayOfIntegers.length;
int valueFromBinarySearch = binarySearch.binarySearchRecursion(arrayOfIntegers, firstIndex, lastIndex, value);
assertThat(valueFromBinarySearch).isEqualTo(8);

}

@Test
public void testBinarySearchRecursionEmpty(){
int[] arrayOfIntegers = {};
int value = 20;
int firstIndex = 0;
int lastIndex = arrayOfIntegers.length;

int valueFromBinarySearch = binarySearch.binarySearchRecursion(arrayOfIntegers, firstIndex, lastIndex, value);
assertThat(valueFromBinarySearch).isEqualTo(-1);
}

@Test
public void testBinarySearchValueRecursionNotFound(){
int[] arrayOfIntegers = {0, 5, 6, 7, 11, 17, 18, 18, 20, 23, 25, 26, 27};
int value = 21;
int firstIndex = 0;
int lastIndex = arrayOfIntegers.length;
int valueFromBinarySearch = binarySearch.binarySearchRecursion(arrayOfIntegers, firstIndex, lastIndex, value);
assertThat(valueFromBinarySearch).isEqualTo(-1);
}

}