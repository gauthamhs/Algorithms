package algorithms.datastructures.graphs;

import java.util.Arrays;

public class FloydWarshall {
	
	public static double[][] floydWarshall(int[][] edges, int N) {
		
		double[][] dp = new double[N][N];
		
		for(double[] d : dp) {
			Arrays.fill(d, Double.POSITIVE_INFINITY);
		}
		
		for(int[] edge: edges) {
			int u = edge[0];
			int v = edge[1];
			int cost = edge[2];
			
			dp[u][v] = cost;
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
		return dp;
		
	}
	
	public static void main(String[] args) {
		/*
		 * int[][] edges = { { 0, 1, 10 }, { 0, 4, 3 }, { 1, 2, 2 }, { 1, 4, 4 }, { 2,
		 * 3, 9 }, { 3, 2, 7 }, { 4, 1, 1 }, { 4, 2, 8 }, { 4, 3, 2 } }; int N = 5;
		 */
		
		int[][] edges = {{0,2,10},{0,1,2},{1,2,4}};
		int N=3;
		System.out.println(Arrays.deepToString(floydWarshall(edges,N)));
	}

}
