package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Vertex{
	int data;
	List<Vertex> edges;
	
	Vertex(int data){
		this.data = data;
		edges = new ArrayList<>();
	}
}
// To clone a graph, we use hashmap that contains the original and cloned nodes. 
// And we use a queue to keep track of the current vertex we are dealing with.
public class CloneGraph {
	
	public static Vertex cloneGraph(Vertex originalVertex) {
		Map<Vertex, Vertex> cloneMap = new HashMap<>();
		Deque<Vertex> vertexQueue = new ArrayDeque<>();
		
		cloneMap.put(originalVertex, new Vertex(originalVertex.data));
		vertexQueue.add(originalVertex);
		
		while(!vertexQueue.isEmpty()) {
			Vertex mainVertex = vertexQueue.poll();
			for(Vertex vertices: mainVertex.edges) {
				if(cloneMap.putIfAbsent(vertices, new Vertex(vertices.data))==null) {
					vertexQueue.add(vertices);
				}
				
				cloneMap.get(mainVertex).edges.add(cloneMap.get(vertices));
			}
			
		}
		
		return cloneMap.get(originalVertex);
	}
	
	
	
	public static void main(String[] args) {
		
		HashMap<Integer, Integer> maps = new HashMap<>();
		System.out.println(maps.putIfAbsent(1, 1));
		System.out.println(maps.putIfAbsent(1, 2));

		
	}

}
