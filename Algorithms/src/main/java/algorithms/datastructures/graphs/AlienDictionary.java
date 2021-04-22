package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
	
	public static String alienDictionary(String[] words){
		Map<Character, Set<Character>> adjacencyList = new HashMap<>();
		Map<Character, Integer> zeroDegreeMap = new LinkedHashMap<>();
		buildGraph(adjacencyList, zeroDegreeMap, words);
		return bfs(adjacencyList, zeroDegreeMap);
	}
	
	public static void buildGraph(Map<Character, Set<Character>> adjacencyList, 
			Map<Character, Integer> zeroDegreeMap, String[] words) {
		
		for(String word : words) {
			for(char c : word.toCharArray()) {
				zeroDegreeMap.putIfAbsent(c, 0);
				adjacencyList.putIfAbsent(c, new HashSet<>());
			}
		}
		
		for(int i=0;i<words.length-1;i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			
			// Check for Prefix
			if(word1.length()>word2.length() && word1.contains(word2)) {
				
				return;
			}
			
			int length = Math.min(word1.length(), word2.length());
			
			for(int j=0;j<length;j++) {
				Character a = word1.charAt(j);
				Character b = word2.charAt(j);
				
				
				if(a!=b) {
					// b->a
					
					adjacencyList.get(a).add(b);
					zeroDegreeMap.put(b, zeroDegreeMap.get(b)+1);
	
					break;
				}
			}
		}
		
	}
	
	public static String bfs(Map<Character, Set<Character>> adjacencyList, 
			                      Map<Character, Integer> zeroDegreeMap){
		Deque<Character> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for(Character c : zeroDegreeMap.keySet()) {
			if(zeroDegreeMap.get(c)==0) {
				queue.add(c);
				sb.append(c);
			}
		}
		
		while(!queue.isEmpty()) {
			Character c = queue.remove();
			Set<Character> neighbors = adjacencyList.get(c);
			for(Character neighbor : neighbors) {
				zeroDegreeMap.put(neighbor, zeroDegreeMap.get(neighbor)-1);
				if(zeroDegreeMap.get(neighbor)==0) {
					queue.add(neighbor);
					sb.append(neighbor);
				}
			}
		}
		
		return (sb.length()==zeroDegreeMap.size()) ? sb.toString() : "";
	}
	
	
	
	public static void main(String[] args) {
		String[] words = {"ab", "adc"};
		
		/*
		 * String result1 = alienDictionary(words1); System.out.println(result1);
		 */
		String result2 = alienDictionary(words);
		System.out.println(result2);
		
	}

}
