package algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
	
	public static List<List<Integer>> nQueens(int n){
		List<List<Integer>> result = new ArrayList<>();
		solveNQueens(n, 0, new ArrayList<Integer>(), result);
		return result;
	}
	
	public static void solveNQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> result){
		
		if(row==n) {
			result.add(new ArrayList<>(colPlacement));
		}
		
		for(int i=0;i<n;i++) {
			colPlacement.add(i);
			if(isValidPlacement(colPlacement)) {
				solveNQueens(n, row+1, colPlacement, result);
			}
			colPlacement.remove(colPlacement.size()-1);
		}
	}
	
	public static boolean isValidPlacement(List<Integer> colPlacement) {
		int rowId = colPlacement.size() - 1;
		for(int j=0;j<rowId;j++) {
			int difference = Math.abs(colPlacement.get(j)-colPlacement.get(rowId));
			if(difference==0 || difference == rowId-j) {
				return false;
			}
		}
		
		return true;
	}
	
	public static List<List<String>> getMatrix(List<List<Integer>> colPlacements){
		List<List<String>> queens = new ArrayList<>();
		
		int rows = colPlacements.size();
		int col = colPlacements.get(0).size();
		
		for (int i = 0; i < rows; i++) {
			List<String> queen = new ArrayList<>();
			for (int j = 0; j < col; j++) {
				int value = colPlacements.get(i).get(j);
				StringBuilder sb = new StringBuilder();
				
				int k = 0;
				
				while(k<col) {
					
					if(value==k) {
						sb.append("Q");
					} else {
						sb.append(".");
					}
					++k;
				}
				queen.add(sb.toString());
			}
			queens.add(queen);
			
		}

		return queens;
	}
	
	public static void main(String[] args) {
		int n = 5;

		List<List<Integer>> nQueensList = nQueens(n);
		
		System.out.println(nQueensList);
		
		System.out.println(getMatrix(nQueensList));
	}

}
