package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConnectedComponentsDFS {
	
public int countComponents(int n, int[][] edges) {
        
        
        
        Map<Integer, List<Integer>> graph = buildGraph(n, edges);
        
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            
            if(!visited[i]){
                ++count;
                dfs(graph,visited,i);
            }
        }
        
        return count;      
        
    }
    
    public Map<Integer, List<Integer>> buildGraph(Integer n, int[][] edges){
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        return graph;
        
    }
    
    public void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, Integer u){
        if(visited[u]){
            return;
        }
        
        visited[u]=true;
        List<Integer> edges = graph.get(u);
        
        for(Integer v : edges){
            if(!visited[v]){
                dfs(graph, visited, v);
            }
        }
    }

}
