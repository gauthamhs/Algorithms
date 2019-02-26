package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KthLongestString {
	
	// Min Heap to get a list of K Largest Strings. 
	//Min Heap is good if you want to extract/remove the smallest element.
	//Min Heap arranges the elements from Smallest to largest.
	
	public static List<String> findKthLongestStrings(int k, List<String> strings){
		PriorityQueue<String> minHeap = new PriorityQueue<>(k, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
		
		for (String string : strings) {
			minHeap.add(string);
			if(minHeap.size()>k) {
				minHeap.poll();
			}
		}
		
		return Stream.generate(minHeap::remove).limit(minHeap.size()).collect(Collectors.toList());
	}
	
/*	Max Heap could be used to remove/extract the largest element.
	Max heap sorts from largest to shortest.*/
	
	public static List<String> findKthShortestStrings(int k, List<String> strings){
		PriorityQueue<String> maxHeap = new PriorityQueue<>(k, (s1,s2)->Integer.compare(s2.length(), s1.length()));
		
		for (String string : strings) {
			maxHeap.add(string);
			if(maxHeap.size()>k) {
				maxHeap.poll();
			}
		}
		
		return Stream.generate(maxHeap::remove).limit(maxHeap.size()).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		
		String[] stringArray= {"Hello","Sam","Ace", "Mohenjodaro", "Harappa", "Matrix", "Mahiy","Technician"};
		List<String> stringList = Arrays.asList(stringArray);
		List<String> kthLongestStrings = findKthLongestStrings(3, stringList);
		List<String> kthShortestStrings = findKthShortestStrings(3, stringList);
		System.out.println(kthLongestStrings);
		System.out.println(kthShortestStrings);
		
	}

}
