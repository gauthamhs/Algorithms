package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class ArrayFeature{
	public Integer value;
	public Integer id;
	
	public ArrayFeature(Integer value, Integer id) {
		this.value = value;
		this.id = id;
	}
}

public class MergeKSortedArrays {
	
	public static List<Integer> mergeKSortedLists(List<List<Integer>> sortedArrayList){
		List<Integer> result = new ArrayList<>();
		
		List<Iterator<Integer>> iterator = new ArrayList<>(sortedArrayList.size());
		PriorityQueue<ArrayFeature> minHeap = new PriorityQueue<>(sortedArrayList.size(), (s1, s2)-> Integer.compare(s1.value, s2.value));
		for(List<Integer> array: sortedArrayList) {
			iterator.add(array.iterator());
		}
		
		for(int i=0;i<sortedArrayList.size();i++) {
			if(iterator.get(i).hasNext()) {
				minHeap.add(new ArrayFeature(iterator.get(i).next(), i));
			}
		}
		
		while(!minHeap.isEmpty()) {
			ArrayFeature arrayFeature = minHeap.poll();
			result.add(arrayFeature.value);
			if(iterator.get(arrayFeature.id).hasNext()) {
				minHeap.add(new ArrayFeature(iterator.get(arrayFeature.id).next(), arrayFeature.id));
			}
		}
		
		
		
		return result; 
		
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		
		list1.add(6);
		list1.add(8);
		list1.add(10);
		list1.add(1);
		
		list2.add(0);
		list2.add(5);
		list2.add(7);
		
		list3.add(11);
		list3.add(12);
		list3.add(14);
		list3.add(16);
		
		List<List<Integer>> sortedArrayList = new ArrayList<>();
		sortedArrayList.add(list1);
		sortedArrayList.add(list2);
		sortedArrayList.add(list3);
		
		List<Integer> mergedList = mergeKSortedLists(sortedArrayList);
		System.out.println(mergedList);
		
		
		
		
		
	}

}
