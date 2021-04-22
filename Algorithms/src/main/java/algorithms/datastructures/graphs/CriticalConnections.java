package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Bridges are used to determine if there are weak links in a network. Removing a bridge increases the connected components in a graph and disconnects the graph
// To find bridges, we use lowLinks to determine if there are connections between nodes. In short, we see if there are any back-edges or alternate routes to a node if 
// a bridges is removed. If so, we capture that bridge in our output array. Bridges are determined based on the following val: id(from)<lowLink(to)

// Read https://medium.com/dev-genius/bridges-and-articulation-points-in-an-undirected-graph-fe79347f0745
public class CriticalConnections {
	
	static int id=0;
	
	public static List<List<Integer>> criticalConnections(int[][] edges, int N){
		List<List<Integer>> bridges = new ArrayList<>();
		int[] lowLinks = new int[N];
		int[] ids = new int[N];
		boolean[] visited = new boolean[N];
		
		Map<Integer, List<Integer>> nodeMap = new HashMap<>();
		for(int i=0;i<N;i++) {
			nodeMap.put(i, new ArrayList<>());
		}
		
		for(int[] edge: edges) {
			nodeMap.get(edge[0]).add(edge[1]);
			nodeMap.get(edge[1]).add(edge[0]);
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				dfs(i,-1,lowLinks,ids,visited, bridges, nodeMap);
			}
		}
		
		return bridges;
		
	}
	
	public static void dfs(int currentNode, int parent, int[] lowLinks, int[] ids, boolean[] visited, List<List<Integer>> bridges, Map<Integer, List<Integer>> nodeMap) {
		
		ids[currentNode] = lowLinks[currentNode] = id++; // assign a unique Id to the nodeId and lowLink. Each node will be assigned its own value as lowlink initially
		visited[currentNode] = true;
		
		List<Integer> edges = nodeMap.get(currentNode);
		
		for(Integer edge: edges) {
			if(edge==parent) continue; // Since this is an undirected graph, if we reach back to parent, we don't process it(Don't process tree edge from child back to parent)
			
			if(!visited[edge]) {
				dfs(edge,currentNode,lowLinks,ids,visited,bridges,nodeMap);
				lowLinks[currentNode]=Math.min(lowLinks[currentNode], lowLinks[edge]);
				if(ids[currentNode]<lowLinks[edge]) {
					bridges.add(Arrays.asList(currentNode,edge));
				}
				
				
			}else {
				lowLinks[currentNode] = Math.min(lowLinks[currentNode], ids[edge]);// If already visited, use the lowest low link value of the currentNode and the edge we are reaching out to
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		int N=4;
		int[][] edges = {{0,1},{1,2},{2,0},{1,3}};
		List<List<Integer>> bridges = criticalConnections(edges, N);
		System.out.println(bridges);
	}

}
