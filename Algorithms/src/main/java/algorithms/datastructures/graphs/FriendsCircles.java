	package algorithms.datastructures.graphs;

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
	
	
	
	  static void dfsVisited(int[][] M, int[] visitedFriends, int i) {
		  
		  for(int j=0;j<M.length;j++) {
			  if(M[i][j]==1 && visitedFriends[j]==0) {
				  visitedFriends[j]=1;
				  dfsVisited(M,visitedFriends,j);
			  }
		  }
		  
		  
	  }
		  
	    public static int findCircleNum(int[][] M) {
	    	
	    	int friendsCircle = 0;
	    	int[] visitedFriends = new int[M.length];
	    	
	    	for(int i=0;i<M.length;i++) {
	    		if(visitedFriends[i]==0) {
	    			dfsVisited(M,visitedFriends,i);
	    			++friendsCircle;
	    		}
	    }
	    	
	    	return friendsCircle;
	    }
	
	public static void main(String[] args) {
		int[][] M = {{1,0,0,1},
				     {0,1,1,0},
				     {0,1,1,1},
				     {1,0,1,1}};
		
		int friends = findCircleNum(M);
		System.out.println(friends);
		
		int friendsEfficient=friendsCirclesEfficient(M);
		System.out.println(friendsEfficient);
	}

}
