package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class DeleteElementsMTimes {
	
	public static List<Integer> deleteElementsThatRepeatMTimes(List<Integer> integerArray, int m){
		
		int j = 0;
		int lastIndex = integerArray.size() - 1 ;
		
		for(int i = 0;i<lastIndex;i++) {
			
			if((m-1)==lastIndex && integerArray.get(i) == integerArray.get(i+m-1)) {
				return integerArray.subList(0, 2);
			}

			if(integerArray.get(i) != integerArray.get(i+1)) {
				integerArray.set(j, integerArray.get(i));
				j++;
			} 
			else if (((i+m-1)==lastIndex && integerArray.get(i) == integerArray.get(i+m-1)) 
					|| ((i+m-1)<lastIndex && integerArray.get(i) == integerArray.get(i+m-1)
					&& integerArray.get(i+m-1) != integerArray.get(i+m))) {
				int k = 0;
				while(k<2) {
					integerArray.set(j, integerArray.get(i));
					k++;j++;
				}
				if(i+m-1==lastIndex) {
					j--;
				}
				i = i+m-1;
			} else {
				while(i<lastIndex && integerArray.get(i) == integerArray.get(i+1)) {
					integerArray.set(j, integerArray.get(i));
					j++;i++;
				}
				i--;
			}
		}
		integerArray.set(j, integerArray.get(integerArray.size()-1));
		
		return integerArray.subList(0, j+1);
		
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray1 = new ArrayList<>();
		integerArray1.add(1);
		integerArray1.add(1);
		integerArray1.add(1);
		integerArray1.add(1);
		integerArray1.add(2);
		integerArray1.add(2);
		integerArray1.add(3);
		integerArray1.add(3);
		integerArray1.add(3);
		integerArray1.add(4);
		integerArray1.add(4);
		integerArray1.add(4);
		integerArray1.add(4);

		int m = 10;
		List<Integer> uniqueArray1 = deleteElementsThatRepeatMTimes(integerArray1, m);
		System.out.println(printArray(uniqueArray1));

		}
	
	public static String printArray(List<Integer> arrayOfIntegers){

		StringBuilder sb = new StringBuilder("");
		for(int i = 0;i<=arrayOfIntegers.size()-1;i++){
		sb.append(arrayOfIntegers.get(i));
		if(i<arrayOfIntegers.size() - 1){
		sb.append(", ");
		}
		}
		return sb.toString();

		}
}
