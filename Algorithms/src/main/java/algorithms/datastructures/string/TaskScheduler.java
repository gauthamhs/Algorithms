package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	public static int taskScheduler(char[] tasks, int n) {
		
		HashMap<Character, Integer> charMap = new HashMap<>();
		for(char c: tasks) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
		maxHeap.addAll(charMap.values());
		
		int cycles = 0;
		
		while(!maxHeap.isEmpty()) {
			List<Integer> tempArray = new ArrayList<>();
			
			for(int i=0;i<=n;i++) {
				if(!maxHeap.isEmpty()) {
					tempArray.add(maxHeap.remove());
				}
			}
			
			for(int i: tempArray) {
				if(--i>0) {
					maxHeap.add(i);
				}
			}
			
			cycles += maxHeap.isEmpty() ? tempArray.size() : n+1;
		}
		return cycles;
		
	}
	
	public static void main(String[] args) {
		
		char[] tasks = {'A','A','A','B','B','B'};
		int leastInterval = taskScheduler(tasks, 2);
		System.out.println(leastInterval);
		
	}

}
