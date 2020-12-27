package algorithms.datastructures.arrays.extras;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaximumOccurrence {

	public static int maximumOccurrence(int[] integerVals) {
		Integer maxItem = null;
		long count = 0;
		
		// Map<Integer, Integer> maxOccurrenceCountMap = new HashMap<>();
		/*
		 * for(int i=0;i<integerVals.length;i++) {
		 * if(maxOccurrenceCountMap.containsKey(integerVals[i])) { int occurrence =
		 * maxOccurrenceCountMap.get(integerVals[i]);
		 * maxOccurrenceCountMap.put(integerVals[i], ++occurrence); } else {
		 * maxOccurrenceCountMap.put(integerVals[i], 1); } }
		 */
		
		Map<Integer, Long> maxOccurrenceCountMap = Arrays.stream(integerVals).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		
		
		for(Entry<Integer, Long> entries : maxOccurrenceCountMap.entrySet()) {
			int element = entries.getKey();
			Long occurrence = entries.getValue();
			if(occurrence>count) {
				count = occurrence;
				maxItem = element;
			}
		}
		
		return maxItem;
		
		
	}
	
	public static void main(String[] args) {
		int[] values = {1,2,1,4,2,2,2,4,4,4,4,2,1,1,4,4,4};
		int maxItem = maximumOccurrence(values);
		System.out.println(maxItem);
	}
}
