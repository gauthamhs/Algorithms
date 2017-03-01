package algorithms.sort;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

public int[] radixSort(int[] arrayOfIntegers){

Queue[] buckets = new Queue[10];
for (int i = 0; i < buckets.length; i++) {
buckets[i] = new LinkedList<Integer>();
}
boolean sorted = false;
int exponential = 1;
int maxNum = findMax(arrayOfIntegers);

while(!sorted){
for (int item:arrayOfIntegers) {
int digit = (item/exponential)%10;
if(digit==0 && (maxNum/exponential)==0){
sorted = true;
}
buckets[digit].add(item);
}

exponential*=10;
int index = 0;
for (Queue<Integer> bucket : buckets) {
while(!bucket.isEmpty()){
arrayOfIntegers[index] = bucket.remove();
index++;
}
}
}

return arrayOfIntegers;

}

public int findMax(int[] arrayOfIntegers){
int maxNum = 0;
for(int i=0;i<arrayOfIntegers.length;i++){
if(arrayOfIntegers[i]>maxNum){
maxNum = arrayOfIntegers[i];
}
}
return maxNum;
}
}