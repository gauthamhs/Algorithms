package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreviousPermutation {
	
	// This is the reverse of nextPermutation wherein we get the previous permutation value. 
	// For example, if the permutationArray is <0 3 2 1>, we return <0 3 1 2>. Also, if the array
	// is at its lowest permutation, we return an empty list.
	public static List<Integer> previousPermutation(List<Integer> permutationArray){
		
		int inversionPoint = permutationArray.size() - 2;
		while(inversionPoint>=0 && permutationArray.get(inversionPoint)<= permutationArray.get(inversionPoint + 1) ) {
			inversionPoint--;
		}
		
		// The array is already at its lowest permutation, return an empty array.
		if(inversionPoint == - 1 ) {
			return Collections.emptyList();
		}
		
		// Next we swap the largest entry with perm.get(i) if get(i) is lower because permutation array
		// must appear in increasing order.
		for(int i = permutationArray.size()-1;i>inversionPoint;i--) {
			if(permutationArray.get(i)<permutationArray.get(inversionPoint)) {
				Collections.swap(permutationArray, inversionPoint, i);
				break;
			}
		}
		
		Collections.reverse(permutationArray.subList(inversionPoint+1, permutationArray.size()));
		
		return permutationArray;
		
	}
	
	public static void main(String[] args) {
		List<Integer> permutationArray = new ArrayList<>();
		permutationArray.add(1);
		permutationArray.add(0);
		permutationArray.add(2);
		permutationArray.add(3);
		
/*		permutationArray.add(2);
		permutationArray.add(1);
		permutationArray.add(5);
		permutationArray.add(0);
		permutationArray.add(0);*/

		List<Integer> previousPermutationArray = previousPermutation(permutationArray);
		System.out.println(printArray(previousPermutationArray));
		
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
