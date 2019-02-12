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
	
	public static List<Integer> nthRowPascal(int row) {
		List<Integer> pascalRow = new ArrayList<>();
		pascalRow.set(0, 1);
		for(int i=0;i<row;i++) {
		pascalRow.add(pascalRow.get(i)*(row-i)/(i+1));	
		}
		
		return pascalRow;
	}
	
	public static void main(String[] args) {
		int numOfRows = 4;
		List<List<Integer>> pascalTriangle = pascalTriangle(numOfRows);
		System.out.println(pascalTriangle);
		
		System.out.println(nthRowPascal(numOfRows));
		
	}

}
