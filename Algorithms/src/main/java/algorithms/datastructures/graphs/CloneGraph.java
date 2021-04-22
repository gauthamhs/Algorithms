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
	
	public static Vertex cloneGraph(Vertex originalNode) {
		Map<Vertex, Vertex> cloneMap = new HashMap<>();
		Deque<Vertex> vertexQueue = new ArrayDeque<>();
		
		cloneMap.put(originalNode, new Vertex(originalNode.data));
		vertexQueue.add(originalNode);
		
		while(!vertexQueue.isEmpty()) {
			Vertex root = vertexQueue.poll();
			for(Vertex neighbor: root.edges) {

				if(!cloneMap.containsKey(neighbor)) {
				vertexQueue.add(neighbor);
				cloneMap.put(originalNode, new Vertex(originalNode.data));
				}
				cloneMap.get(root).edges.add(cloneMap.get(neighbor));
			}
			
		}
		
		return cloneMap.get(originalNode);
	}
	
	
	
	public static void main(String[] args) {
		
		HashMap<Integer, Integer> maps = new HashMap<>();
		//System.out.println(cloneGraph(originalVertex));


		
	}

}
