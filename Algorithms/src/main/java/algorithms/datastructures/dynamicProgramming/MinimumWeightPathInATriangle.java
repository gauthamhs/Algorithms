package algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumWeightPathInATriangle {
	
	public static int minimumWeightPath(List<List<Integer>> triangle) {
		
		int minWeightPath = 0;
		
		if(triangle==null || triangle.isEmpty()) {
			return minWeightPath;
		}
		
		List<Integer> previousRow = new ArrayList<>(triangle.get(0));
		
		for(int i=1;i<triangle.size();i++) {
			List<Integer> currentRow = new ArrayList<>(triangle.get(i));
			
			// Add first Element
			currentRow.set(0, currentRow.get(0) + previousRow.get(0));
			
			// Add in-between elements
			
			for(int j=1;j<currentRow.size()-1;j++) {
				currentRow.set(j, currentRow.get(j) + Math.min(previousRow.get(j), previousRow.get(j-1)));
			}
			
			// Add Last element.
			currentRow.set(currentRow.size()-1, currentRow.get(currentRow.size()-1) + previousRow.get(previousRow.size()-1));
			previousRow = currentRow;
			
		}
		
		return Collections.min(previousRow);
		
	}
	
	public static void main(String[] args) {
		
		
		
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(new Integer[] {2}));
		triangle.add(Arrays.asList(new Integer[] {4,4}));
		triangle.add(Arrays.asList(new Integer[] {8,5,6}));
		triangle.add(Arrays.asList(new Integer[] {4,2,6,2}));
		triangle.add(Arrays.asList(new Integer[] {1,5,2,3,4}));
		
		System.out.println(triangle);
		
		
		int minWeightPath = minimumWeightPath(triangle);
		System.out.println(minWeightPath);
		
	}

}
