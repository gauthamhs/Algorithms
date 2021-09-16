package algorithms.datastructures.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	
	int cap;
	int min = 1;
	Map<Integer, Integer> keyValueMap;
	Map<Integer, Integer> frequencyMap;
	Map<Integer, LinkedHashSet<Integer>> itemCounterMap;
	
	
	public LFUCache(int capacity) {
		this.cap = capacity;
		keyValueMap = new HashMap<>();
		frequencyMap = new HashMap<>();
		itemCounterMap = new HashMap<>();
		itemCounterMap.put(1, new LinkedHashSet<>());
		
	}
	
	public Integer get(Integer key) {
		if(!keyValueMap.containsKey(key)) {
			return -1;
		}
		
		int frequency = frequencyMap.get(key);
		frequencyMap.put(key, frequency+1);
		itemCounterMap.get(frequency).remove(key);
		
		if(min==frequency && itemCounterMap.get(frequency).size()==0) {
			min++;
		}
		
		itemCounterMap.putIfAbsent(frequency+1, new LinkedHashSet<>()); 	
		itemCounterMap.get(frequency+1).add(key);	
		
		return keyValueMap.get(key);
	}
	
	public void put(Integer key, Integer value) {
		if(cap<=0) {
			return;
		}
		
		if(keyValueMap.size()>=cap) {
			Integer evict = itemCounterMap.get(min).iterator().next();
			itemCounterMap.get(min).remove(evict);
			keyValueMap.remove(evict);
			frequencyMap.remove(evict);
		}
		
		keyValueMap.put(key, value);
		frequencyMap.put(key, frequencyMap.getOrDefault(key,0)+1);
		int frequency = frequencyMap.get(key);
		itemCounterMap.get(frequency).add(key);
		
		
	}

}
