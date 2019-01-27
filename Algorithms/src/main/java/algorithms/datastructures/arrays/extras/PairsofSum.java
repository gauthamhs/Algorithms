package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairsofSum {
	
	public static List<List<Integer>> findPairsOfSums(List<Integer> integerArray, int sum){
		List<List<Integer>> pairOfSumsList = new ArrayList<>();
		Collections.sort(integerArray);
		
		int startIndex = 0;
		int lastIndex = integerArray.size()-1;
		
		while(startIndex<lastIndex) {
			
			if((integerArray.get(startIndex) + integerArray.get(lastIndex)<sum)){
				startIndex++;
			} else if ((integerArray.get(startIndex) + integerArray.get(lastIndex)>sum)) {
				lastIndex--;
			} else {
				List<Integer> pair = new ArrayList<>();
				pair.add(integerArray.get(startIndex));
				pair.add(integerArray.get(lastIndex));
				pairOfSumsList.add(pair);
				startIndex++; // You could either increment startIndex or decrement EndIndex.
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
