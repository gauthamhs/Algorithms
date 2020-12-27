package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlternateArrayValues {
	
/*	In alternating arrays, we swap array elements such that the following property is satisfied: 
	A[0]<=A[1]>=A[2]<=A[3]
	We need to check based on the modulo to see if the index is odd or even
	hint: if index is odd: check if A[0] is greater than A[1] else lesser if even;
	
	Time Complexity: O(n)
	*/
	
	public static List<Integer> alternateArrayValues(List<Integer> integerArray){
		for(int i = 0;i<integerArray.size()-1;i++) {
			if((i%2!=0 && integerArray.get(i) < integerArray.get(i+1)) || (i%2==0 && integerArray.get(i) > integerArray.get(i+1))
					) {
				Collections.swap(integerArray, i, i+1);
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
