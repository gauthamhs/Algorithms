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
for (int l = k; l < arrayOfIntegers.length; l++) {
arrayOfIntegers[l] = 2;
}

return arrayOfIntegers;
}

public int[] simpleSort4Count(int[] arrayOfIntegers){
	
	///{1,2,2,1,2,3,1,2,3,4,4,4,1}
	// elements = 13
	// 1's = 4 (0-3)
	// 2's = 4 (4-7)
	// 3's = 2 (8-9)
	// 4's = 3 (10-12)

int arrayLength = arrayOfIntegers.length;
int k = 0;
int l = 0;
int m = 0;

for(int i = 0;i<arrayLength;i++){
if(arrayOfIntegers[i]==1){
k++;
}else if(arrayOfIntegers[i]==2){
	l++;
} else if(arrayOfIntegers[i]==3) {
	m++;
}
// k=4
//l=4
//m=2
}
for(int n=0;n<k;n++){
arrayOfIntegers[n] = 1;
}
for (int o = k; o < k+l; o++) {
arrayOfIntegers[o] = 2;
}

for (int p = k+l; p < k+l+m; p++) {
arrayOfIntegers[p] = 3;
}

for (int q = k+l+m; q < arrayLength; q++) {
arrayOfIntegers[q] = 4;
}

return arrayOfIntegers;
}


}
