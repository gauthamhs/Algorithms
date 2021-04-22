package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
	
static	class BellmanEdge{
	    int from;
		int to;
		int cost;
		
		public BellmanEdge(int from, int to, int cost) {
			this.to = to;
			this.cost = cost;
			
		}
		
		
	}
	
	public static double[] bellmanFord(int[][] edges, int N, int start) {
		
		double[] distance = new double[N];
		Arrays.fill(distance, Double.POSITIVE_INFINITY);
		
		
		distance[start]=0;
		
		for(int i=0;i<N-1;i++) {
			
			for(int[] edge: edges) {
				int u = edge[0];
				int v = edge[1];
				int cost = edge[2];
				
				if(distance[u] + cost < distance[v]) {
					distance[v] = distance[u] + cost;
				}
				
			}
			
			for(int[] edge: edges) {
				int u = edge[0];
				int v = edge[1];
				int cost = edge[2];
				
				if(distance[u] + cost < distance[v]) {
					distance[v] = Double.NEGATIVE_INFINITY;
				}
				
			}
			
		}
		
		
		return distance;
		
		
	}
	
	public static void main(String[] args) {
		int[][] edges = {{0,1,1},{1,2,1},{2,4,1},{4,3,-3},{3,2,1},{1,5,4},{1,6,4},{5,6,5},{6,7,4},{5,7,3}};
		Integer N = 8;
		Integer start = 0;
		double[] distance = bellmanFord(edges, N, start);
		System.out.println(Arrays.toString(distance));
		

	}

}
