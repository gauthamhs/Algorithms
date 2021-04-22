package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlights {
	
	class Edge{
	    Integer vertex; 
	    Integer cost;
	    
	    public Edge(Integer vertex, Integer cost){
	        this.vertex=vertex;
	        this.cost=cost;
	    }
	}

	class Node{
	    Integer vertex;
	    Integer cost;
	    Integer k;
	    
	    public Node(Integer vertex, Integer cost, Integer k){
	        this.vertex = vertex;
	        this.cost = cost;
	        this.k = k;
	    }
	}
	
	
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Map<Integer, List<Edge>> nodeMap = new HashMap<>();
        
        for(int i=0;i<n;i++){
            nodeMap.put(i, new ArrayList<>());
        }
        
        for(int[] flight : flights){
            nodeMap.get(flight[0]).add(new Edge(flight[1],flight[2]));
        }
        
        Comparator<Node> cmp = (a,b) -> {
          return a.cost-b.cost;  
        };
        
        distance[src]=0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(cmp);
        minHeap.add(new Node(src,0,0));
        
        while(!minHeap.isEmpty()){
            
            Node node = minHeap.remove();
            Integer u = node.vertex;
            Integer uCost = node.cost;
            Integer uK = node.k;
            
            if(u==dst){
                return uCost;
            }
            
            if(uK>K){
                continue;
            }
            
            
            List<Edge> edgeList = nodeMap.get(u);
            
            for(Edge edge: edgeList){
                    Integer v = edge.vertex;
                    Integer w = edge.cost;
                minHeap.add(new Node(v,w+uCost,uK+1));
            }
                        
            
        }
        
        return -1;
        
        
    }
}

