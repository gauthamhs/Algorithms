package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	
	public static List<List<Integer>> pascalTriangle(int numOfRows){
		List<List<Integer>> pascalTriangle = new ArrayList<>();
	
		for(int i=0;i<numOfRows;i++) {
			List<Integer> currentRow = new ArrayList<>();
			for(int j=0;j<=i;j++) {
			int	value = (j>0 && i>j) ? pascalTriangle.get(i-1).get(j) + pascalTriangle.get(i-1).get(j-1):1;
				currentRow.add(value);
			}
			pascalTriangle.add(currentRow);
		}
		

		return pascalTriangle;
	}
	
	public static void main(String[] args) {
		int numOfRows = 7;
		List<List<Integer>> pascalTriangle = pascalTriangle(numOfRows);
		System.out.println(pascalTriangle);
		
	}

}
