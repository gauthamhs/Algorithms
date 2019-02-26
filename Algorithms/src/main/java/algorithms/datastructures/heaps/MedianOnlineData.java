package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOnlineData {
	
	public static List<Double> medianOnline(List<Integer> streamOfIntegers) {
		
		Iterator<Integer> streamIterator = streamOfIntegers.iterator();
		List<Double> medianList = new ArrayList<>();
		
		//Define MinHeap and Maxheap. Min Heap stores the smallest of the larger half of the median.
		// Max heap stores largest of the smallest half of the median.
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		while(streamIterator.hasNext()) {
			minHeap.add(streamIterator.next());
			maxHeap.add(minHeap.poll());
			if(maxHeap.size()>minHeap.size()) {
				minHeap.add(maxHeap.poll());
			}
			
			if(minHeap.size()==maxHeap.size()) {
				medianList.add((double)0.5*(minHeap.peek()+maxHeap.peek()));
			} else { 
				medianList.add((double)minHeap.peek());
			}
		}
		
		
		
		return medianList;
		
		
		
	}
	
	public static void main(String[] args) {
		
		Integer[] stream = {3,9,1,4,5,7,3,1,3,5,7,55,43,133};
		List<Integer> streamOfIntegers = Arrays.asList(stream);
		System.out.println(streamOfIntegers);
		List<Double> median = medianOnline(streamOfIntegers);
		System.out.println(median);
	}

}
