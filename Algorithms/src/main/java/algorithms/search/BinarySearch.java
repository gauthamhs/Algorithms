package algorithms.search;

public class BinarySearch {

/*Binary Search Implementation:

Binary Search looks for the required element by continuously halving the array to remove the elements that are greater
or lesser than the searched value.

Note: First Index must always be smaller than the last Index. Otherwise, it implies the array is empty.

Here are some of the following conditions:

1) If the element at midIndex is equal to the searched value, the item is found 
   and we return the index where the value is found.
2) If the element at midIndex is greater than searched value, we need to eliminate the elements from midIndex
to the right half of the elements and set the lastIndex = midIndex-1.
3) If the element at midIndex is lesser than searched value, we need to eliminate the elements from firstIndex 
   to the midIndex and set firstIndex = midIndex + 1;
*/

public int binarySearch(int[] arrayInt, int value){

int firstIndex = 0;
int lastIndex = arrayInt.length - 1;
int midIndex = 0;

while(firstIndex<=lastIndex){
midIndex = firstIndex+((lastIndex-firstIndex)/2);
if(arrayInt[midIndex]==value){
return midIndex;
}
else{
if(arrayInt[midIndex]>value){
lastIndex = midIndex-1;
}else if(arrayInt[midIndex]<value){
firstIndex = midIndex + 1;
}
}
}

return -1;
}

public int binarySearchRecursion(int[] arrayOfIntegers,int firstIndex, int lastIndex, int value){
	
	int midIndex = 0;
	
	if(arrayOfIntegers.length==0){
		return -1;
	}

	while(firstIndex<=lastIndex){
		midIndex = firstIndex + (lastIndex-firstIndex)/2;
		if(arrayOfIntegers[midIndex]==value){
			return midIndex;
		}
		else if(arrayOfIntegers[midIndex]>value){
		return binarySearchRecursion(arrayOfIntegers,firstIndex, midIndex-1, value);
		
		}
		else if(arrayOfIntegers[midIndex]<value){
			return binarySearchRecursion(arrayOfIntegers,midIndex+1, lastIndex, value);
		}
	}
	return -1;
}

}