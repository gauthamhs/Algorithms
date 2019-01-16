package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlternateArrayValues {
	
/*	In alternating arrays, we swap array elements such that the following property is satisfied: 
	A[0]<=A[1]>=A[2]<=A[3]
	hint: if index is odd: check if A[0] is greater than A[1] else lesser if even;
	*/
	
	public static List<Integer> alternateArrayValues(List<Integer> integerArray){
		for(int i = 1;i<integerArray.size();i++) {
			if((i%2!=0 && integerArray.get(i-1) > integerArray.get(i)) || (i%2==0 && integerArray.get(i-1) < integerArray.get(i))
					) {
				Collections.swap(integerArray, i, i-1);
			}
		}
		return integerArray;
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(41);
		integerArray.add(39);
		integerArray.add(38);
		integerArray.add(37);
		integerArray.add(35);
		
		List<Integer> alternateArray = alternateArrayValues(integerArray);
		System.out.println(printArray(alternateArray));
		
	}
	
	public static String printArray(List<Integer> sortedList){

		StringBuilder sb = new StringBuilder("");
		for(Integer i: sortedList){
		sb.append(i);
		}
		return sb.toString();

		}

}
