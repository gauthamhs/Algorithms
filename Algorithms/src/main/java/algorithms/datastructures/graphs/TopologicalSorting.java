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


/*For Topological Sorting, It goes like this: 
 * 
 * In Topological sorting, we have vertices that is dependent on other vertex to finish a task. 
 * The algorithm for topological sort is as follows
 *1) Find the list of vertex that don't have any dependencies/prerequisite(Also called as zero degree)
 *2) Create an adjacency list based off of the zero degree vertex and the list of dependent vertices
 *3) Add all the zero-degree vertex and start processing the dependent vertices until they become zero degree
 *4) Process all the vertices until queue is empty
 * */
public class TopologicalSorting {
	
	public static List<Integer> prerequisitesOrder(int courses, int[][] prerequisites){
		
		Deque<Integer> queue = new ArrayDeque<>();
		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
		Map<Integer, Integer> zeroDegreeMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i=0;i<courses;i++) {
			adjacencyList.put(i, new ArrayList<>());
			zeroDegreeMap.put(i, 0);
		}
		
		for(int[] prerequisite : prerequisites) {
			Integer dependent = prerequisite[0];
			Integer dependency = prerequisite[1];
			
			zeroDegreeMap.put(dependent, zeroDegreeMap.get(dependent)+1);
			adjacencyList.get(dependency).add(dependent);
		}
		
		for(Integer zeroDegree : zeroDegreeMap.keySet()) {
			if(zeroDegreeMap.get(zeroDegree)==0) {
				queue.add(zeroDegree);
				result.add(zeroDegree);
			}
		}
		
		while(!queue.isEmpty()) {
			Integer zeroDegree = queue.remove();
			List<Integer> dependents = adjacencyList.get(zeroDegree);
			
			for(Integer dependent : dependents) {
				zeroDegreeMap.put(dependent, zeroDegreeMap.get(dependent)-1);
				if(zeroDegreeMap.get(dependent)==0) {
					queue.add(dependent);
					result.add(dependent);
				}
			}
		}
		
		return (courses==result.size()) ? result : Collections.emptyList();
		
		
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
				queue.add((char) ('A' + j));
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
