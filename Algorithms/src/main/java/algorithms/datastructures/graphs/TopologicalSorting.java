package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopologicalSorting {
	
	public static List<Integer> prerequisitesOrder(int courses, int[][] prerequisites){
		Deque<Integer> queue = new ArrayDeque<>();
		List<Integer> orderedCourses = new ArrayList<>();
		int[] dependencies = new int[courses];
		
		
		// Get the list of Dependencies
		
		for(int i=0;i<prerequisites.length;i++) {
			dependencies[prerequisites[i][0]]++;
		}
		
		System.out.println(Arrays.toString(dependencies));
		
		for(int i=0;i<courses;i++) {
			if(dependencies[i]==0) {
				orderedCourses.add(i);
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			
			Integer node = queue.poll();
			
			for(int i=0;i<prerequisites.length;i++) {
				if(node == prerequisites[i][1]) {
					
					dependencies[prerequisites[i][0]]--;
				
				
				if(dependencies[prerequisites[i][0]]==0) {
					orderedCourses.add(prerequisites[i][0]);
					queue.add(prerequisites[i][0]);
				}
			}
			}
		}
		
		return (courses==orderedCourses.size()) ? orderedCourses : Collections.emptyList();
		
	}
	
	public static List<Character> prerequisiteTopologicalSorting(int courses, char[][] prerequisites){
		
		List<Character> topologicalSortCharacters = new ArrayList<>();
		int[] dependencies = new int[courses];
		
		Deque<Character> queue = new ArrayDeque<>();
		
		Map<Character, List<Character>> charMap = new HashMap<>();
		
		for(int i=0;i<prerequisites.length;i++) {
			
			Character source = prerequisites[i][0];
			Character destination = prerequisites[i][1];
			
			List<Character> adjacencyList = charMap.getOrDefault(destination, new ArrayList<>());
			dependencies[prerequisites[i][0]-'A']++;
			adjacencyList.add(source);
			charMap.put(destination, adjacencyList);
			
		}
		
		for(int j=0;j<courses;j++) {
			if(dependencies[j]==0) {
				queue.add((char) (j + 65));
			}
		}
		
		while(!queue.isEmpty()) {
			Character c = queue.poll();
			topologicalSortCharacters.add(c);
			
			if(charMap.containsKey(c)) {
				
				for(Character neighbor : charMap.get(c)) {
					dependencies[neighbor-'A']--;
					
					if(dependencies[neighbor-'A']==0) {
						queue.add(neighbor);
					}
				}
				
				
			}

		}
		
		return (courses==topologicalSortCharacters.size()) ? topologicalSortCharacters : Collections.emptyList();
				
	}
	
	public static void main(String[] args) {
		
		int courses = 4;
		
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		
		List<Integer> orderedCourses = prerequisitesOrder(courses, prerequisites);
		System.out.println(orderedCourses);
		
		char[][] prerequisitesChar = {{'A','B'},{'A','C'},{'B','D'},{'B','E'},{'C','D'},{'C','F'},{'E','G'},{'G','H'}};
		
		courses = 8;
		List<Character> topologicalSort = prerequisiteTopologicalSorting(courses, prerequisitesChar);
		System.out.println(topologicalSort);
		
	}

}
