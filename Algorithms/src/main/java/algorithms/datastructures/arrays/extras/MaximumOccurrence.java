package algorithms.datastructures.arrays.extras;

import java.util.HashMap;
import java.util.Map;

public class MaximumOccurrence {

	public static int maximumOccurrence(int[] integerVals) {
		Integer maxItem = null;
		int count = 0;
		
		Map<Integer, Integer> maxOccurrenceCountMap = new HashMap<>();
		for(int i=0;i<integerVals.length;i++) {
			if(maxOccurrenceCountMap.containsKey(integerVals[i])) {
				int occurrence = maxOccurrenceCountMap.get(integerVals[i]);
				maxOccurrenceCountMap.put(integerVals[i], ++occurrence);
			} else { 
				maxOccurrenceCountMap.put(integerVals[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entries : maxOccurrenceCountMap.entrySet()) {
			int element = entries.getKey();
			int occurrence = entries.getValue();
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
