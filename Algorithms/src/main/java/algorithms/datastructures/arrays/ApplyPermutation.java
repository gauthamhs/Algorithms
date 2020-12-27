package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ApplyPermutation {
	
	/*For apply permutation program, we apply permutation to rearrange a sequence of arrays into a new sequence
	 * For example, given a permutated array = {2, -1, 0, 1} and original array = {12 51 33 42}, We rearrange the 
	 * original array based on the index specified by the permutated array. Therefore the original array becomes
	 * {33 42 12 51}
	 * Note for inverse permutation, you need to know this formula: A(A[i] -1 ) = i+1; for i=0 to size
	 * 
	 * */
	
	public static List<Integer> applyPermutation(List<Integer> permutationArray, List<Integer> originalArray){
		List<Integer> rearrangedArray = new ArrayList<>(Collections.nCopies(originalArray.size(), Integer.MAX_VALUE));
		for(int i=0; i<originalArray.size(); i++) {
			rearrangedArray.set(permutationArray.get(i), originalArray.get(i));
		}
		
		return rearrangedArray;
		
	}
	
	/*
	 * To apply permutation in constant space, We need to apply permutation and make the value negative to 
	 * mark it as completed. We would need two variables, next -> to move on to the next permutation and temp to hold the 
	 * permutation index value using which the array values will be swapped. Here is the algorithm:
	 * 
	 * 1) Choose the first index to be the permutation
	 * 2) Swap the elements based on the permutation
	 * 3) Stored the permutation in a temp variable to be the next index for permutation
	 * 4) Mark permutation as completed
	 * 5) Choose the temp as the next permutation
	 * 
	 * 	Time Complexity: O(n)
	 *  Space Complexity: O(1)
	 * 
	 * */
	
	
	public static List<Integer> applyPermutationConstantSpace(List<Integer> permutationArray, List<Integer> originalArray){
		int arraySize = originalArray.size();
		for(int i =0; i<originalArray.size(); i++) {
			int next = i;
			while(permutationArray.get(next)>=0) {
				Collections.swap(originalArray, i, permutationArray.get(next));
				int temp = permutationArray.get(next);
				permutationArray.set(next, permutationArray.get(next) - arraySize);
				next = temp;
			}
		}
		
		for (int i=0;i<permutationArray.size();i++) {
			permutationArray.set(i, permutationArray.get(i)+permutationArray.size());
		}
		
		return originalArray;
		
	}
	
	
	
	public static void main(String[] args) {
		List<Integer> permutationArray = new ArrayList<>();
		List<Integer> originalArray = new ArrayList<>();
		
		permutationArray.add(2);
		permutationArray.add(1);
		permutationArray.add(3);
		permutationArray.add(0);
		
		originalArray.add(12);
		originalArray.add(51);
		originalArray.add(33);
		originalArray.add(42);
		
		
		List<Integer> permutatedArray1 = applyPermutation(permutationArray, originalArray);
		List<Integer> permutatedArray2 = applyPermutationConstantSpace(permutationArray, originalArray);
		System.out.println(permutatedArray1);
		System.out.println(printArray(permutatedArray2));
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
