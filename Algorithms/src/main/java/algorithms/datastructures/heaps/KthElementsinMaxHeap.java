package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class ArrayFeatures{
	int arrayIndex;
	int arrayValue;
	
	public ArrayFeatures(int arrayIndex, int arrayValue) {
		this.arrayIndex = arrayIndex;
		this.arrayValue = arrayValue;
	}
}

public class KthElementsinMaxHeap {
	
	public static List<Integer> kthMaxElements(List<Integer> arrayList, int k){
		List<Integer> result = new ArrayList<>();
		
		int arrayIndex = 0;
		PriorityQueue<ArrayFeatures> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.arrayValue, o1.arrayValue));
		if(k<=0) {
			return Collections.emptyList();
		}
		
		maxHeap.add(new ArrayFeatures(0, arrayList.get(0)));
		
		for(int i=0;i<k;i++) {
			arrayIndex = maxHeap.peek().arrayIndex;
			result.add(maxHeap.poll().arrayValue);
			
			Integer leftChildIndex = 2*arrayIndex + 1;
			Integer rightChildIndex =2*arrayIndex + 2;
			
			if(leftChildIndex<arrayList.size()) {
				maxHeap.add(new ArrayFeatures(leftChildIndex, arrayList.get(leftChildIndex)));
			}
			
			if(rightChildIndex<arrayList.size()) {
				maxHeap.add(new ArrayFeatures(rightChildIndex, arrayList.get(rightChildIndex)));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Integer[] array = {516,314,401,28,156,359,271,11,3};
		List<Integer> arrayList = Arrays.asList(array);
		System.out.println(arrayList);
		List<Integer> kthMaxElements = kthMaxElements(arrayList, 4);
		System.out.println(kthMaxElements);
		
		
	}

}
