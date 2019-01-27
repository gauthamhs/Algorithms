package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.List;

public class MissingElement {
	
/*	To find the missing element, we can make the use of the following formula: 
	n*(n+1)/2
	This provides the sum of 1 to n.
	*/
	public static int findMissingElementFormula(List<Integer> integerArray) {
		int sum = 0;
		int size = integerArray.size();
		int totalElements = size + 1;
		int sumFromFormula = totalElements*(totalElements+1)/2;
		for (Integer value : integerArray) {
			sum += value;
		}
		
		return sumFromFormula - sum;
	}
	
	public static int findMissingElementXOR(List<Integer> integerArray) {
		int sumFromArray = 0;
		int sumFromXOR = 0;
		int size = integerArray.size();
		int n = size + 1;
		for( int i=1;i<=n;i++) {
			sumFromXOR ^= i;
		}
		for(int value : integerArray) {
			sumFromArray ^= value;
		}

		return sumFromXOR ^ sumFromArray;
		
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(1);
		integerArray.add(3);
		integerArray.add(4);
		integerArray.add(7);
		integerArray.add(6);
		integerArray.add(9);
		integerArray.add(2);
		integerArray.add(8);
		
		int missingElement = findMissingElementFormula(integerArray);
		int missingElement2 = findMissingElementXOR(integerArray);
		System.out.println(missingElement);
		System.out.println(missingElement2);
		
		
	}

}
