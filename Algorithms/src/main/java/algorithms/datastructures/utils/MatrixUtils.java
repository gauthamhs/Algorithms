package algorithms.datastructures.utils;

import java.util.Arrays;

public class MatrixUtils {
	
	public static int[][] transposeMatrix(int[][] originalMatrix){
		
		for(int i=0;i<originalMatrix.length;i++) {
			for(int j=i+1;j<originalMatrix[i].length;j++) {
				int temp = originalMatrix[i][j];
				originalMatrix[i][j]=originalMatrix[j][i];
				originalMatrix[j][i] = temp;
			}
		}
		
		return originalMatrix;
	}
	
	public static int[][] reverseEachRow(int[][] originalMatrix){
		
		for(int i=0;i<originalMatrix.length;i++) {	
			int start=0;
			int end=originalMatrix[0].length-1;
			
			while(start<end) {

				int temp = originalMatrix[i][start];
				originalMatrix[i][start] = originalMatrix[i][end];
				originalMatrix[i][end] = temp;
				++start;
				--end;
			}
			
		}
		
		return originalMatrix;
	}
	
	public static int[][] reverseEachColumn(int[][] originalMatrix){
		
		for(int i=0;i<originalMatrix[0].length;i++) {	
			int start=0;
			int end=originalMatrix.length-1;
			
			while(start<end) {

				int temp = originalMatrix[start][i];
				originalMatrix[start][i] = originalMatrix[end][i];
				originalMatrix[end][i] = temp;
				++start;
				--end;
			}
			
		}
		
		return originalMatrix;
	}
	
	public static void main(String[] args) {
		int[][] originalMatrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		
		int[][] transposedMatrix = transposeMatrix(originalMatrix);
		System.out.println(Arrays.deepToString(transposedMatrix));
		System.out.println(Arrays.deepToString(reverseEachRow(originalMatrix)));
		System.out.println(Arrays.deepToString(reverseEachColumn(originalMatrix)));
	}

}
