package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*Djikstra Algorithm:
Time Complexity: O(Elog(V))
Space Complexity: O(V)*/

class Edge {
	Integer vertex;
	Integer cost;

	public Edge(Integer vertex, Integer cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
}

class Node {
	Integer vertex;
	Integer distanceFromSource;

	public Node(Integer vertex, Integer distanceFromSource) {
		this.vertex = vertex;
		this.distanceFromSource = distanceFromSource;
	}
}

public class DjikstraAlgorithm {

	public static int[] djikstra(int[][] edges, Integer N, Integer source) {
		int[] distance = new int[N];
		boolean[] visited = new boolean[N];
		Map<Integer, List<Edge>> nodeMap = new HashMap<>();

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		for (int i = 0; i < N; i++) {
			nodeMap.put(i, new ArrayList<>());
		}

		for (int[] edge : edges) {
			Edge newEdge = new Edge(edge[1], edge[2]);
			nodeMap.get(edge[0]).add(newEdge);
		}

		Comparator<Node> cmp = (a, b) -> {
			return a.distanceFromSource - b.distanceFromSource;
		};

		PriorityQueue<Node> minHeap = new PriorityQueue<>(cmp);
		minHeap.add(new Node(source, 0));

		while (!minHeap.isEmpty()) {
			Node node = minHeap.remove();
			Integer u = node.vertex;
			List<Edge> nodeEdges = nodeMap.get(u);
			for (Edge nodeEdge : nodeEdges) {
				Integer v = nodeEdge.vertex;
				Integer cost = nodeEdge.cost;
				if (!visited[v]) {
					distance[v] = Math.min(distance[v], distance[u] + cost);
					minHeap.add(new Node(v, distance[v]));
				}

			}

			visited[u] = true;
		}

		return distance;

	}

	public static int djikstra(int[][] edges, Integer N, Integer source, Integer destination) {
		int[] distance = new int[N];
		boolean[] visited = new boolean[N];
		Map<Integer, List<Edge>> nodeMap = new HashMap<>();

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		for (int i = 0; i < N; i++) {
			nodeMap.put(i, new ArrayList<>());
		}

		for (int[] edge : edges) {
			Edge newEdge = new Edge(edge[1], edge[2]);
			nodeMap.get(edge[0]).add(newEdge);
		}

		Comparator<Node> cmp = (a, b) -> {
			return a.distanceFromSource - b.distanceFromSource;
		};

		PriorityQueue<Node> minHeap = new PriorityQueue<>(cmp);
		Integer[] parent = new Integer[N];
		minHeap.add(new Node(source, 0));

		parent[source] = null;

		while (!minHeap.isEmpty()) {
			Node node = minHeap.remove();

			Integer u = node.vertex;

			List<Edge> nodeEdges = nodeMap.get(u);
			for (Edge nodeEdge : nodeEdges) {
				Integer v = nodeEdge.vertex;
				Integer cost = nodeEdge.cost;
				if (!visited[v]) {
					parent[v] = u;
					distance[v] = Math.min(distance[v], distance[u] + cost);
					minHeap.add(new Node(v, distance[v]));
				}

			}

			visited[u] = true;
		}

		List<Integer> path = reconstructPath(parent, source, destination);
		System.out.println(path);

		return distance[destination];
	}

	public static List<Integer> reconstructPath(Integer[] prev, Integer source, Integer destination) {
		List<Integer> path = new ArrayList<>();
		  for(int i=destination;prev[i]!=null;i=prev[i]) { path.add(i); }
		  path.add(source);
		  
		  Collections.reverse(path);

		return path;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1, 10 }, { 0, 4, 3 }, { 1, 2, 2 }, { 1, 4, 4 }, { 2, 3, 9 }, { 3, 2, 7 }, { 4, 1, 1 },
				{ 4, 2, 8 }, { 4, 3, 2 } };
		int N = 5;
		int source = 0;
		int destination = 3;
		int[] shortestPath = djikstra(edges, N, source);
		System.out.println(Arrays.toString(shortestPath));
		System.out.println(djikstra(edges, N, source, destination));

		// System.out.println(reconstructPath(edges, N, 0, 4));

	}

}
