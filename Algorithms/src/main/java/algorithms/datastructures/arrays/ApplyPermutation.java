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
		List<Integer> rearrangedArray = new ArrayList<>();
		int arraySize = originalArray.size();
		
		
		
		for(int i =0; i<originalArray.size(); i++) {
			rearrangedArray.add(originalArray.get(permutationArray.get(i)<0 ? permutationArray.get(i)+arraySize:permutationArray.get(i)));
		}
		
		return rearrangedArray;
		
	}
	
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
		System.out.println(printArray(permutatedArray2));
	}
	
	public static String printArray(List<Integer> sortedList){

		StringBuilder sb = new StringBuilder("");
		for(Integer i: sortedList){
		sb.append(i +", ");
		}
		return sb.toString();

		}
	
	

}
