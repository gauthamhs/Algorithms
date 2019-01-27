package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
	
/*	Majority element is that element in the array that is greater than N/2 times the whole array.
	There can only be one majority element in the array or none, but there can never be more than one.*/
	
	public static String findMajorityElement(List<Integer> integerArray) {
		
		int size = integerArray.size();
		Map<Integer, Integer> countMap = new HashMap<>();
		int occurrence = 0;
		for(int i =0; i<integerArray.size();i++) {
			if(countMap.containsKey(integerArray.get(i))) {
				occurrence = countMap.get(integerArray.get(i));
				countMap.put(integerArray.get(i), ++occurrence);
			} else {
				countMap.put(integerArray.get(i), 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			int value = entry.getKey();
			int count = entry.getValue();
			if(count>(size/2)) {
				return "Majority element is: " + value + ", count: " + count + ", for size: " + size;
			}
		}
		
		return "No Majority Element found";
		
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(2);
		integerArray.add(3);
		integerArray.add(3);
		integerArray.add(3);
		integerArray.add(5);
		integerArray.add(5);
		
		
		String majorityElement = findMajorityElement(integerArray);
		System.out.println(majorityElement);
		
	}

}
