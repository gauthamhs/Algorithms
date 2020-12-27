package algorithms.datastructures.greedy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringKDistance {
	
	public static String rearrangeString(String s, int k) {
		
		Map<Character, Integer> charMap = new HashMap<>();
		for(char c : s.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0)+1);
		}
		
		StringBuilder sb = new StringBuilder("");
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> charMap.get(b)-charMap.get(a));
		maxHeap.addAll(charMap.keySet());
		Deque<Character> queue = new ArrayDeque<>();
		
		while(!maxHeap.isEmpty()) {
			char c = maxHeap.remove();
			sb.append(c);
			charMap.put(c, charMap.get(c)-1);
			queue.addLast(c);
			
			if(queue.size()<k) {
				continue;
			}
			
			char element = queue.removeFirst();
			if(charMap.get(element)>0) {
				maxHeap.add(element);
			}
		}
		
		
		return sb.length() == s.length() ? sb.toString() : "";
		
	}
	
	public static void main(String[] args) {
		String s = "aaadbbc"; int k = 2;
		String rearrangedStrings=rearrangeString(s, k);
		System.out.println(rearrangedStrings);
	}

}
