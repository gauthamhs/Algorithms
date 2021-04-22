package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	
	public static List<String> findItinerary(List<List<String>> tickets){
		List<String> result = new ArrayList<>();
		Map<String, Integer> outMap = new HashMap<>();
		Map<String, PriorityQueue<String>> nodeMap = new HashMap<>();
		
		for(List<String> ticket : tickets) {
			String outgoingEdge = ticket.get(0);
			String incomingEdge = ticket.get(1);
			nodeMap.putIfAbsent(outgoingEdge, new PriorityQueue<>());
			nodeMap.get(outgoingEdge).add(incomingEdge);
			outMap.put(outgoingEdge, outMap.getOrDefault(outgoingEdge, 0)+1);
		}
		
		String startingNode = "JFK";
		
		dfs(startingNode, outMap,nodeMap,result);
		Collections.reverse(result);
		
		return result;
		
	}
	
	public static void dfs(String currentNode, Map<String, Integer> outMap, Map<String, PriorityQueue<String>> nodeMap, List<String> result) {
		
		if(!outMap.containsKey(currentNode)) {
			result.add(currentNode);
			return;
		}
		
		while(outMap.get(currentNode)!=0) {
			outMap.put(currentNode, outMap.get(currentNode)-1);
			String edge = nodeMap.get(currentNode).remove();
			dfs(edge, outMap, nodeMap, result);
		}
		result.add(currentNode);
	}
	
	
	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList("MUC","LHR"));
		tickets.add(Arrays.asList("JFK","MUC"));
		tickets.add(Arrays.asList("SFO","SJC"));
		tickets.add(Arrays.asList("LHR","SFO"));
		
		System.out.println(tickets);
		
		List<String> itinerary = findItinerary(tickets);
		System.out.println(itinerary); //["JFK", "MUC", "LHR", "SFO", "SJC"]
		
		List<List<String>> tickets2 = new ArrayList<>();
		tickets2.add(Arrays.asList("JFK","SFO"));
		tickets2.add(Arrays.asList("JFK","ATL"));
		tickets2.add(Arrays.asList("SFO","ATL"));
		tickets2.add(Arrays.asList("ATL","JFK"));
		tickets2.add(Arrays.asList("ATL","SFO"));

		
		System.out.println(tickets2);
		
		List<String> itinerary2 = findItinerary(tickets2);
		System.out.println(itinerary2); // ["JFK","ATL","JFK","SFO","ATL","SFO"]
		
		

		
	}

}
