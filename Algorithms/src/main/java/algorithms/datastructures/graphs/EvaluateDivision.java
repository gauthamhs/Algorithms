package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	
	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		
		double[] result = new double[queries.size()];
		
		Map<String, Map<String, Double>> graph = buildGraph(equations,values);
		
		for(int i=0;i<queries.size();i++) {
			String start = queries.get(i).get(0);
			String end = queries.get(i).get(1);
			
			if(!graph.containsKey(start) || !graph.containsKey(end)) {
				result[i] = -1;
				continue;
			}
			
			if(start==end) {
				result[i]=1.0;
				continue;
			}
			
			result[i] = getCost(start, end, graph, new HashSet<>());
		}
		
		
		return result;
	}
	
	public static double getCost(String currentNode, String targetNode, Map<String, Map<String, Double>> graph, Set<String> visited) {
		
		if(!graph.containsKey(currentNode)) {
			return -1.0;
		}
		
		if(graph.get(currentNode).containsKey(targetNode)) {
			return graph.get(currentNode).get(targetNode);
		}
		
		visited.add(currentNode);
		Map<String, Double> edges = graph.get(currentNode);
		for(Map.Entry<String, Double> edge : edges.entrySet()) {
			if(!visited.contains(edge.getKey())){
			double product = getCost(edge.getKey(), targetNode, graph, visited);
			if(product!=-1) {
				return product*edge.getValue();
				
			}
		}
		}
		
		return -1.0;
	}
	
	public static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values){
		Map<String, Map<String, Double>> graph = new HashMap<>();
		int i=0;

		for(List<String> equation : equations) {
			String dividend = equation.get(0);
			String divisor = equation.get(1);
			
			graph.putIfAbsent(dividend, new HashMap<>());
			graph.putIfAbsent(divisor, new HashMap<>());
			
			graph.get(dividend).put(divisor, values[i] );
			graph.get(divisor).put(dividend, 1/values[i]);
			i++;
		}
		
		return graph;
	}
	
	public static void main(String[] args) {
		
		/*
		 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
		 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] Output:
		 * [6.00000,0.50000,-1.00000,1.00000,-1.00000]
		 */
		
		List<List<String>> equations = new ArrayList<>();
		equations.add(Arrays.asList("a","b"));
		equations.add(Arrays.asList("b","c"));
		
		double[] values = {2.0,3.0};
		
		List<List<String>> queries = new ArrayList<>();
		queries.add(Arrays.asList("a","c"));
		queries.add(Arrays.asList("b","a"));
		queries.add(Arrays.asList("a","e"));
		queries.add(Arrays.asList("a","a"));
		queries.add(Arrays.asList("x","x"));
		
		
		double[] results = calcEquation(equations, values, queries);
		System.out.println(Arrays.toString(results));

		
	}

}
