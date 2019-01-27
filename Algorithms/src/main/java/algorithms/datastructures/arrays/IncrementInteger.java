package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class IncrementInteger {

	public static List<Integer> addInteger(List<Integer> integerArray){
		int arrayLength = integerArray.size()-1;
		integerArray.set(arrayLength, integerArray.get(arrayLength) + 1);
		for(int i = arrayLength; i>0 && integerArray.get(i)==10;i--) {
			integerArray.set(i, 0);
			integerArray.set(i-1, integerArray.get(i-1)+ 1);
		}
		
		if(integerArray.get(0)==10) {
			integerArray.set(0, 1);
			integerArray.add(0);
		}
		return integerArray;
		
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(9);
		integerArray.add(9);
		List<Integer> intArr = addInteger(integerArray);
		System.out.println(printArray(intArr));
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
