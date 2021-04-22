package algorithms.datastructures.graphs;

import java.util.HashSet;
import java.util.Set;

public class MaxConnectedColors {
	
	public static int maxConnectedColors(int[][] grid) {
		
		if(grid==null || grid.length==0) {
			return 0;
		}
		
		int R = grid.length;
		int C = grid[0].length;
		int maxColors = 0;
		Set<String> visited = new HashSet<>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				int n = dfs(grid, i, j, visited);
				maxColors = Math.max(maxColors, n);
			}
		}
		
		return maxColors;
	}
	
	public static int dfs(int[][] grid, int i, int j, Set<String> visited) {
		
		String key = i + "|" + j;
		
		if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]==0||visited.contains(key)) {
			return 0;
		}
		visited.add(key);
		int n=1;
		int[][] neighbors = neighbors(grid,i,j);
		
		for(int[] neighbor:neighbors) {
			n+=dfs(grid,neighbor[0],neighbor[1],visited);
		}
		/*
		 * n+=dfs(grid,i+1,j,visited); n+=dfs(grid,i,j+1,visited);
		 * n+=dfs(grid,i-1,j,visited); n+=dfs(grid,i,j-1,visited);
		 */

		return n;
			
	}
	
	public static int[][] neighbors(int[][] grid, int i, int j){
		int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
		int[][] neighbors = new int[4][4];
		int k=0;
		for(int[] d : dir) {
			neighbors[k][0] = i + d[0];
			neighbors[k][1] = j + d[1];
			k++;
			
		}
		
		return neighbors;
	}
	
	
	
	public static void main(String[] args) {
		int[][] grid = {
				{1,0,0,1},
				{1,1,1,1},
				{0,1,1,0}};
		
		int maxColors = maxConnectedColors(grid);
		System.out.println(maxColors);
		
	}

}
