package algorithms.datastructures.graphs;

public class UnionFind {
	
	 public static int countComponents(int n, int[][] edges) {
	        
	        int[] components = new int[n];
	        int[] rank = new int[n];
	        for(int i=0;i<n;i++){
	            components[i] = i;
	            rank[i]=1;
	        }
	    
	        for(int[] edge: edges){
	            int s1 = edge[0];
	            int s2 = edge[1];
	            
	            int root1 = findWithPathCompression(components, s1);
	            int root2 = findWithPathCompression(components, s2);
	            
	            if(root1==root2) continue;
	            
	            union(components, rank, root1,root2);
	            --n;
	        }
	        
	        return n;
	    
	}
	    
	    public static void union(int[] components, int[] rank, int root1, int root2){
	        if(rank[root1]>=rank[root2]){
	            rank[root1]+=rank[root2];
	            components[root2] = root1;
	        }else{
	            rank[root2]+=rank[root1];
	            components[root1] = root2;
	        }
	    }
	    
	    public static int find(int[] components, int label){
	    
	        if(components[label]==label){
	            return label;
	        }
	        
	        return find(components, components[label]);
	        
	    }
	    
	    public static int findWithPathCompression(int[] components, int label) {
	        if(components[label]==label){
	            return label;
	        }
	        
	        components[label] = find(components, components[label]); // Path Compression
	        return components[label];
	    }
    
    public static void main(String[] args) {
    	int[][] edges = {{0,1},{1,2},{3,4}};
   
		Integer connectedComponents = countComponents(5, edges);
		System.out.println(connectedComponents);
	}

}
