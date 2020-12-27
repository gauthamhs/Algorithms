package algorithms.datastructures.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeStrings {
	
	public static String reorganizeString(String S) {
		
		Map<Character, Integer> charMap = new HashMap<>();
		
		for(char c: S.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c,0) + 1);
		}
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> charMap.get(b)-charMap.get(a));
		StringBuilder sb = new StringBuilder("");
		maxHeap.addAll(charMap.keySet());
		
		while(maxHeap.size()>1) {
			
			
			char c1 = maxHeap.remove();
			char c2 = maxHeap.remove();
			
			sb.append(c1).append(c2);
			
			charMap.put(c1,charMap.get(c1)-1);
			charMap.put(c2,charMap.get(c2)-1);

			if(charMap.get(c1)>0) {
				maxHeap.add(c1);
			}
			
			if(charMap.get(c2)>0) {
				maxHeap.add(c2);
			}
			
		}
		
		if(!maxHeap.isEmpty()) {
		char c = maxHeap.remove();
		if(charMap.get(c)>1) {
			return "";
		}else {
			sb.append(c);
		}
		}
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		
		String o1="aab";
		String o2="aaab";
		
		String reorg1 = reorganizeString(o1);
		String reorg2 = reorganizeString(o2);
		
		System.out.println(reorg1);
		System.out.println(reorg2);
	}

}
