package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAlmostSortedArray {
	
	public static List<Integer> sortAlmostSortedArray2(List<Integer> almostSortedArray, int k){
		List<Integer> result = new ArrayList<>();
		Iterator<Integer> arrayIterator = almostSortedArray.iterator();	
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i=0;i<k && arrayIterator.hasNext();i++) {
			minHeap.add(arrayIterator.next());
		}
		
		while(arrayIterator.hasNext()) {
			minHeap.add(arrayIterator.next());
			Integer smallestElement = minHeap.poll();
			result.add(smallestElement);
		}
		
		
		result.addAll(Stream.generate(minHeap::remove).limit(minHeap.size()).collect(Collectors.toList()));
		
		return result;
	}
	
	public static List<Integer> sortAlmostSortedArray(List<Integer> almostSortedArray, int k){
		List<Integer> result = new ArrayList<>();
		int i = 0;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(i=0;i<k;i++) {
			minHeap.add(almostSortedArray.get(i));
		}
		
		for(int j=i;j<almostSortedArray.size();j++) {
			minHeap.add(almostSortedArray.get(j));
			Integer smallestElement = minHeap.poll();
			result.add(smallestElement);
		}
		
		while(!minHeap.isEmpty()) {
			result.add(minHeap.poll());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Integer[] array = {3,-1,2,4,5};
		List<Integer> arrayList = Arrays.asList(array);
		System.out.println(arrayList);
		List<Integer> sortedArray = sortAlmostSortedArray(arrayList, 2);
		System.out.println(sortedArray);
		List<Integer> sortedArray2 = sortAlmostSortedArray2(arrayList, 2);
		System.out.println(sortedArray2);
		
	}

}
