package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycle {
	
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
       int[] visited = new int[graph.size()];
       for(int i=0;i<numCourses;i++){
           if(visited[i]==0 && !dfs(graph, visited, i)) return false;
       }
       
       return true;
       
   }
   
   public static Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
       Map<Integer, List<Integer>> graph = new HashMap<>();
       for(int i=0;i<numCourses;i++){
           graph.put(i, new ArrayList<>());
       }
       
       for(int[] prerequisite: prerequisites){
           int u = prerequisite[1];
           int v = prerequisite[0];
           
           graph.get(u).add(v);
       }
       
       return graph;
   }
   
   public static boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, Integer u){
       visited[u] = 1;
       
       List<Integer> neighbors = graph.get(u);
       
       for(Integer v: neighbors){
           if(visited[v]==1) return false; //Back Edge
           if(visited[v]==0 && !dfs(graph,visited,v)) return false; //Self loop
       }
       
       visited[u]=2;
       return true;
   }
   
   public static void main(String[] args) {
		int courses = 4;
		int[][] prerequisites = {{1,0},{0,1},{3,1},{3,2}};
		System.out.println(canFinish(courses,prerequisites));
}

}
