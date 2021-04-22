package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Tarjan's Strongly connected components algorithm is used to find strongly connected components in a graph.
// In other words, it is used to find number of components where a vertex in a cycle reach every other vertex in the same cycle

public class StronglyConnectedComponents {
	
	static int sCC=0;
	static int id=0;
	public static int[] tarjan(Integer N, int[][] edges) {
		Map<Integer, List<Integer>> nodeMap = new HashMap<>();
		for(int[] edge : edges) {
			nodeMap.putIfAbsent(edge[0], new ArrayList<>());
			nodeMap.get(edge[0]).add(edge[1]);
		}
		boolean[] onStack = new boolean[N];
		Deque<Integer> stack = new ArrayDeque<>();
		int[] lowLink = new int[N];
		int[] ids = new int[N];
		Arrays.fill(ids, -1);
		
		for(int i=0;i<N;i++) {
			if(ids[i]==-1) {
				dfs(ids,lowLink,i,stack,onStack, nodeMap);
			}
		}
		
		return lowLink;
		
	}
	
	public static void dfs(int[] ids, int[] lowLink, int currentNode, Deque<Integer> stack, boolean[] onStack, Map<Integer, List<Integer>> nodeMap) {
		stack.addFirst(currentNode);
		onStack[currentNode]=true;
		lowLink[currentNode] = ids[currentNode] = id++;
		
		List<Integer> edges = nodeMap.get(currentNode);
		
		for(Integer edge: edges) {
			if(ids[edge]!=-1) continue;
			dfs(ids,lowLink,edge,stack,onStack,nodeMap);
			if(onStack[edge]) lowLink[currentNode] = Math.min(lowLink[currentNode], lowLink[edge]);
			
		}
			
			if(lowLink[currentNode]==ids[currentNode]) {
				while(!stack.isEmpty()) {
					Integer poppedNode= stack.pop();
					onStack[poppedNode] = false;
					lowLink[poppedNode] = ids[currentNode];
				}
				++sCC;
			}
			

			
			
		}
	
	
	public static void main(String[] args) {
		int N = 8;
		int[][] edges = {{6,0},{6,2},{6,4},{3,4},{2,0},{0,1},{4,5},{5,6},{3,7},{7,5},{1,2},{7,3},{5,0}};
		int[] lowLink = tarjan(N, edges);
		System.out.println(Arrays.toString(lowLink));
		System.out.println(sCC);
	}

}
