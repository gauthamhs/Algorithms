package algorithms.sort;

public class CombSort {

/*Implementation:

 Comb Sort is a variant of the Bubble Sort Algorithm and provides a significant improvement over bubble-sort algorithm.
 The basic idea is to eliminate turtles, or small values near the end of the list, 
 since in a bubble sort these slow the sorting down tremendously.
 Rabbits, large values around the beginning of the list, do not pose a problem in bubble sort.

 The Bubble Sort algorithm always compares values that are adjacent to each other in the data set.
 The Comb Sort improves on this by adding a gap which allows non-adjacent numbers to be compared.
 After each iteration, the gap is reduced by a shrink factor until it reaches the value of 1.
 Hence, at the very end, the Comb Sort behaves exactly like the Bubble Sort.

 Each iteration of the algorithm consists of three stages:
 1) Calculation of the gap value.
 2) Iterating over the data set comparing each item with the item that is elements further down the list 
    and swapping them if required.
 3) Checking to see if the gap value has reached one and no swaps have occurred. If so, then the set has been sorted.

 Credits: OJ( for clarity about the understanding of the Comb Sort Algorithm)

 Complexity:

 Worst Case : O(n2)
 Best Case: O(nlog(n).

  */

public int[] combSort(int[] arrayOfIntegers){

int size = arrayOfIntegers.length;
int gap = size;
double shrinkingFactor = 1.3;
int temp = 0;

while(true){

if(gap>1){
gap = (int)(gap/shrinkingFactor);
}

boolean swapped = false;
for (int i = 0; i < size-gap; i++) {

if(arrayOfIntegers[i]>arrayOfIntegers[i+gap]){
swapped = true;
temp = arrayOfIntegers[i+gap];
arrayOfIntegers[i+gap] = arrayOfIntegers[i];
arrayOfIntegers[i] = temp;
}

}

if(gap==1 && !swapped){
break;
}
}
return arrayOfIntegers;
}

public void swap(int[] arrayOfIntegers, int i, int j){
if(arrayOfIntegers[i]>arrayOfIntegers[j]){
int temp = 0;
temp = arrayOfIntegers[j];
arrayOfIntegers[j] = arrayOfIntegers[i];
arrayOfIntegers[i] = temp;
}

}
}