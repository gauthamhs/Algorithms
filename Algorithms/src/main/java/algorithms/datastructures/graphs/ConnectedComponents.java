package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedComponents {
	
	public static int[] connectedComponents(int N, int[][] edges) {
		
		
		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
		for(int[] edge : edges) {
			Integer from = edge[0];
			Integer to = edge[1];
			adjacencyList.putIfAbsent(from, new ArrayList<>());
			adjacencyList.putIfAbsent(to, new ArrayList<>());
			adjacencyList.get(from).add(to);
			adjacencyList.get(to).add(from);
		}
		
		Integer count = 0;
		boolean[] visited = new boolean[N];
		int[] components = new int[N];
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				count++;
				dfs(i, visited, components, adjacencyList, count);
			}
		}
		
		return components;
		
	}
	
	public static void dfs(Integer i, boolean[] visited, int[] components, Map<Integer, List<Integer>> adjacencyList, Integer count) {
		visited[i] = true;
		components[i] = count;
		
		for(int edge : adjacencyList.get(i) ) {
			if(!visited[edge]) {
				dfs(edge, visited, components, adjacencyList, count);
			}
		}
	}
	
	public static void main(String[] args) {
    	int[][] edges = {{0,1},{1,4},{3,2}};
    	int[] components = connectedComponents(5, edges);
    	System.out.println(Arrays.toString(components));

	}

}
