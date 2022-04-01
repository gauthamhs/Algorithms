package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSorting2 {
	
	public static List<String> topologicalSorting(List<List<String>> dependencies){
		
		// Build Graph
		Map<String, List<String>> adjacencyList = new HashMap<>();
		Map<String, Integer> zeroDegreeMap = new HashMap<>();
		
		buildGraph(adjacencyList,zeroDegreeMap,dependencies);
		
		// Do a BFS/Topological Sort on the graph
		return bfs(adjacencyList, zeroDegreeMap);
		

	}
	
	public static void buildGraph(Map<String, List<String>> adjacencyList, Map<String, Integer> zeroDegreeMap, List<List<String>> dependencies) {
		
		for(List<String> dependency : dependencies) {
			String outgoing = dependency.get(0);
			String incoming = dependency.get(1);
			
			adjacencyList.putIfAbsent(incoming, new ArrayList<>());
			adjacencyList.putIfAbsent(outgoing, new ArrayList<>());
			
			zeroDegreeMap.putIfAbsent(incoming, 0);
			zeroDegreeMap.putIfAbsent(outgoing, 0);
			
			adjacencyList.get(incoming).add(outgoing);
			zeroDegreeMap.put(outgoing, zeroDegreeMap.get(outgoing)+1);
			
		}
	}
	
	public static List<String> bfs(Map<String, List<String>> adjacencyList, Map<String, Integer> zeroDegreeMap){
		List<String> result = new ArrayList<>();
		Deque<String> queue = new ArrayDeque<>();
		for(String key : zeroDegreeMap.keySet()) {
			if(zeroDegreeMap.get(key)==0) {
				queue.add(key);
			}
		}
		
		while(!queue.isEmpty()) {
			String node = queue.remove();
			result.add(node);
			
			List<String> neighbors = adjacencyList.get(node);
			for(String neighbor : neighbors) {
				zeroDegreeMap.put(neighbor, zeroDegreeMap.get(neighbor)-1);
				if(zeroDegreeMap.get(neighbor)==0) {
					queue.add(neighbor);
				}
			}
		}
		
		return (result.size()==adjacencyList.size()) ? result : null;
	}
	
	
	public static void main(String[] args) {
		List<List<String>> dependencies = Arrays.asList(Arrays.asList("B","C"), Arrays.asList("C","A"));
		List<String> toposort = topologicalSorting(dependencies);
		System.out.println(toposort);
	}

}
