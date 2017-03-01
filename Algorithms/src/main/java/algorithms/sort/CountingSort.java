package algorithms.sort;

/*Counting sort is an integer sorting algorithm that sorts the elements based on keys 
 pertaining to a specific range.
 Counting sort uses key values as indexes into the array to count the no. of occurrences.

Algorithm:

- Find the total no. of occurrences of the distinct element in the input array(histogram)
and put the total count in the respective index.
- Identify the position of each element in the output sequence.

Complexity:

O(n+k)

n: No. of elements in the array.
k: the range of elements in that array.

*/

public class CountingSort {

/*This method identifies the total no. of occurrences of the distinct elements in the input array.

Once the occurrences for each element has been identified, the array consists of the following:

value: The no. of occurrences
key: Distinct element

*/

public int[] countOccurrences(int[] arrayOfIntegers, int maxVal) {

int[] equalArray = new int[maxVal + 1];
int index = 0;

for(int i=0;i<arrayOfIntegers.length;i++){
index = arrayOfIntegers[i];
equalArray[index]++;
}

return equalArray;

}

/*This method sorts the elements in ascending order by identifying the position of each element in the 
  output array.
It checks how many times a distinct element has occurred using the countOfOccurrences array and 
places the distinct element in the output array based on its occurrence.
For example: If element 1 has occurred 2 times in the input array, the array will consist of {1,1} etc.*/

public int[] countingSort(int[] originalArray, int[] equalArray){

int[] sortedArray = new int[originalArray.length];

int sortedArrayIndex = 0;

for(int i = 0;i<equalArray.length;i++){
for(int j = 0;j<equalArray[i];j++){
sortedArray[sortedArrayIndex] = i;
sortedArrayIndex++;
}
}

return sortedArray;

}

}
