package algorithms.datastructures.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KclosestPointsToOrigin {
	
    public static int[][] kClosest(int[][] points, int K) {
    	
    	int[][] closestPoints = new int[K][2];
    	
    	Comparator<int[]> distanceComparator = (a,b)->{
    		return ((b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])); 
    	};
    	
    	
    	PriorityQueue<int[]> maxHeap = new PriorityQueue<>(distanceComparator);
    	
    	int i=0;
    	while(i<points.length) {
    		maxHeap.add(points[i]);
    		
    		if(maxHeap.size()>K) {
    			maxHeap.remove();
    		}
    		++i;
    	}
    	
    	int j=0;
    	while(!maxHeap.isEmpty()) {
    		closestPoints[j]=maxHeap.remove();
    		++j;
    	}
    	
    	return closestPoints;

        
    }
    
    public static int[][] kClosestVertex(int[][] points, int K, int[] v) {
    	
    	int[][] closestPoints = new int[K][2];
    	
    	Comparator<int[]> distanceComparator = (a,b) -> {
    	
    		
    		return ((int)(Math.pow(b[0]-v[0], 2) + Math.pow(b[1]-v[1], 2) - (Math.pow(a[0]-v[0], 2) + Math.pow(a[1]-v[1], 2))));
    		
    	};
    		 
    	
    	PriorityQueue<int[]> maxHeap = new PriorityQueue<>(distanceComparator);
    	
    	int i=0;
    	while(i<points.length) {
    		maxHeap.add(points[i]);
    		
    		if(maxHeap.size()>K) {
    			maxHeap.remove();
    		}
    		
    		++i;
    	}
    	
    	i=0;
    	while(!maxHeap.isEmpty()) {
    		closestPoints[i] = maxHeap.remove();
    		i++;
    	}
    
		return closestPoints;
        
    }
    
    public static void main(String[] args) {
    	
    	int[][] points = {{3,3},{5,-1},{-2,4}};
    	int K =2;
    	int[][] closestPoints = kClosest(points, K);
    	System.out.println(Arrays.deepToString(closestPoints));
    	
    	int[] v = {4,4};
    	int[][] closestPointsVertex = kClosestVertex(points, K, v);
    	System.out.println(Arrays.deepToString(closestPointsVertex));
		
	}

}
