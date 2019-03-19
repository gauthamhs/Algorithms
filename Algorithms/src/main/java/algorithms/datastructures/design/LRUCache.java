package algorithms.datastructures.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer>{
	
	// For this design problem, We will implement an LRU cache which performs cache eviction and caching.
	// We will implement three operations: insert, lookup, and instantiating a cache.
	// An implementation of LRU cache will be done using a Linked HashMap which supports O(1) lookup, 
	// O(1) deletions, insertions and have link to the elements in insertion order.
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int capacity;
	    
	    public LRUCache(int capacity) {
	        super(capacity, 0.75F, true);
	        this.capacity = capacity;
	    }

	    public int get(int key) {
	        return super.getOrDefault(key, -1);
	    }

	    public void put(int key, int value) {
	        super.put(key, value);
	    }

	    @Override
	    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	        return size() > capacity; 
	    }
	
	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache(5);
		cache.put(7, 7);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(4, 8);
		System.out.println(cache);
		cache.put(5, 5);
		cache.put(6, 6);
		System.out.println(cache);
		cache.get(4);
		System.out.println(cache);
	}

}
