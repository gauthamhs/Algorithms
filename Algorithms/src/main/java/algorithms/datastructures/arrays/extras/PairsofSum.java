package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairsofSum {
	
	public static List<List<Integer>> findPairsOfSums(List<Integer> integerArray, int sum){
		List<List<Integer>> pairOfSumsList = new ArrayList<>();
		Collections.sort(integerArray);
		
		int i = 0;
		int j = integerArray.size()-1;
		
		while(i<j) {
			
			if((integerArray.get(i) + integerArray.get(j)<sum)){
				i++;
			} else if ((integerArray.get(i) + integerArray.get(j)>sum)) {
				j--;
			} else {
				pairOfSumsList.add(Arrays.asList(i,j));
				i++; // You could either increment startIndex or decrement EndIndex.
			}
			
		}

		return pairOfSumsList;
		
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(5);
		integerArray.add(8);
		integerArray.add(3);
		integerArray.add(4);
		integerArray.add(2);
		integerArray.add(6);
		integerArray.add(10);
		integerArray.add(7);
		integerArray.add(1);
		integerArray.add(9);
		System.out.println(integerArray);
		List<List<Integer>> pairOfSumsList = findPairsOfSums(integerArray, 10);
		System.out.println(pairOfSumsList);
		
	}

}
