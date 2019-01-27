package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.List;


public class OddOccurrence {
	
/*	We are using this method to determine the elements that has repeated odd
	number of times.
	Note: We can use this method if and only if only one element has occurred
	odd number of times.*/
	
	public static int findNumberOccurringOddTimes(List<Integer> integerArray) {
		
		int number = 0;
		
		for(int i=0;i<integerArray.size();i++) {
			number ^= integerArray.get(i);
		}
		
		return number;
		
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(1);
		integerArray.add(5);
		integerArray.add(5);
		integerArray.add(1);
		integerArray.add(2);
		integerArray.add(3);
		integerArray.add(4);
		integerArray.add(2);
		integerArray.add(1);
		integerArray.add(2);
		integerArray.add(1);
		integerArray.add(2);
		integerArray.add(3);
		integerArray.add(2);
		integerArray.add(4);
		
		System.out.println(integerArray);
		int numberOddTimes = findNumberOccurringOddTimes(integerArray);
		System.out.println(numberOddTimes);
		
	}

}
