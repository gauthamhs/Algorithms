package algorithms.sort;

public class SimpleCountSort {

public int[] simpleSort(int[] arrayOfIntegers){

int arrayLength = arrayOfIntegers.length;
int k = 0;
for(int i = 0;i<arrayLength;i++){
if(arrayOfIntegers[i]==1){
k++;
}
}
for(int j=0;j<k;j++){
arrayOfIntegers[j] = 1;
}
for (int l = k+1; l < arrayOfIntegers.length; l++) {
arrayOfIntegers[l] = 2;
}

return arrayOfIntegers;
}

}
