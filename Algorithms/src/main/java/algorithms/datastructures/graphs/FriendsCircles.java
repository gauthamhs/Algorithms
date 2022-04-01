	package algorithms.datastructures.graphs;

	
//	Algorithm: Iterate through all provinces that are not visited.
//	           DFS through each city if unvisited, mark them as visited, and see if this city is connected to rest of the cities
//	           if the rest of cities are not visited, and are connected, dfs through those cities to find all connections
public class FriendsCircles {
	
	static int dfs(int[][] M, int i) {
		if(M[i][i]==0) {
			return 0;
		}
		
		M[i][i]=0;
		
		for(int j=0;j<M.length;j++) {
			if(M[i][j]==1) {
				M[i][j]=0;
				M[j][i]=0;
				dfs(M,j);
			}
		}
		
		return 1;
	}
	
	public static int friendsCirclesEfficient(int[][] M) {
		int friendsCircle = 0;
		
		for(int i=0;i<M.length;i++) {
			friendsCircle+=dfs(M,i);
		}
		
		
		return friendsCircle;
	}
	
	
	
	  static void dfsVisited(int[][] M,  int i, boolean[] visited) {
		  
		  if(visited[i]) return;
		  visited[i]=true;
		  
		  for(int j=0;j<M.length;j++) {
			  if(!visited[j] && M[i][j]==1) {
				  dfsVisited(M, j, visited);
			  }
		  }
		  
	  }
		  
	    public static int findCircleNum(int[][] M) {
	    	
	    	int friendsCircle = 0;
	    	boolean[] visited = new boolean[M.length];
	    	
	    	for(int i=0;i<M.length;i++) {
	    		if(!visited[i]) {
	    			dfsVisited(M, i, visited);
	    			++friendsCircle;
	    		}
	    	}
	    	
	    	
	    	return friendsCircle;

	    }
	
	public static void main(String[] args) {
		int[][] M = {{1,0,0,0},
				     {0,1,0,0},
				     {0,0,1,0},
				     {0,0,0,1}};
		
		int friends = findCircleNum(M);
		System.out.println(friends);
		
		int friendsEfficient=friendsCirclesEfficient(M);
		System.out.println(friendsEfficient);
	}

}
