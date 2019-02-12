package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
		
	// We are finding the next permutation in this method. For Example: <1 2 0 3> should give us <1 2 3 0>
	// and <3 2 1 0> should provide us an empty list. 
	// First, we find the inversion point from the right that is the smaller than entry immediately after it.
	
	public static List<Integer> nextPermutation(List<Integer> permutationArray){
		
		int inversionPoint = permutationArray.size() - 2;
		while(inversionPoint>=0 && permutationArray.get(inversionPoint)>= permutationArray.get(inversionPoint + 1) ) {
			inversionPoint--;
		}
		
		// The array is already at its highest permutation, return an empty array.
		if(inversionPoint == - 1 ) {
			return Collections.emptyList();
		}
		
		// Next we swap the smallest entry with perm.get(i) if get(i) is higher because permutation array
		// must appear in decreasing order.
		for(int i = permutationArray.size()-1;i>inversionPoint;i--) {
			if(permutationArray.get(i)>inversionPoint) {
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
		permutationArray.add(4);
		permutationArray.add(1);
		List<Integer> nextPermutationArray = nextPermutation(permutationArray);
		System.out.println(printArray(nextPermutationArray));
		
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
