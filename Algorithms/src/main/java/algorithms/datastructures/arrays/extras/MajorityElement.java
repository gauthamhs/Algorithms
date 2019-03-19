package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {
	
/*	Majority element is that element in the array that is greater than N/2 times the whole array.
	There can only be one majority element in the array or none, but there can never be more than one.*/
	
	public static String findMajorityElement(List<Integer> integerArray) {
		
		int size = integerArray.size();
		Map<Integer, Long> countMap = integerArray.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
				
		for(Map.Entry<Integer, Long> entry : countMap.entrySet()) {
			int value = entry.getKey();
			long count = entry.getValue();
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
		integerArray.add(3);
		integerArray.add(5);
		integerArray.add(5);
		
		
		String majorityElement = findMajorityElement(integerArray);
		System.out.println(majorityElement);
		
	}

}
