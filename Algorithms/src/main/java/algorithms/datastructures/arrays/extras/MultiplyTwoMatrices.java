package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiplyTwoMatrices {
	
	public static int[][] multiplyTwoMatrices(int[][] A, int[][] B) {
		
		int row1 = A.length;
		int col1 = A[0].length;
		
		int row2 = B.length;
		int col2 = B[0].length;
		
		// For matrix multiplication, The column of first matrix must equal row of second matrix;
		
		int[][] multipliedMatrix = new int[row1][col2];
		
		for(int i=0;i<row1;i++) {
			for(int j=0;j<col2;j++) {
				for(int k=0;k<col1;k++) {
					multipliedMatrix[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		
		return multipliedMatrix;
		
	}
	
	public static int[][] matrixMultiplicationForSparseMatrices(int[][] mat1, int[][] mat2){
		Map<Integer, List<List<Integer>>> compressedA = compressedMatrix(mat1);
		Map<Integer, List<List<Integer>>> compressedB = compressedMatrix(mat2);
		
		int rows = mat1.length;
		int cols = mat2[0].length;
		int k= mat1[0].length;
		
		int[][] result = new int[rows][cols];
		
		for(int r1=0;r1<rows;r1++) {
			
			for(List<Integer> pairs: compressedA.get(r1)) {
				int e1 = pairs.get(0);
				int c1 = pairs.get(1);
				
				for(List<Integer> pairs2 : compressedB.get(c1)) {
					int e2 = pairs2.get(0);
					int c2 = pairs2.get(1);
					
					result[r1][c2]+=e1*e2;
				}
			}
			
		}
		
		return result;
		
		
		
	}
	
	public static Map<Integer, List<List<Integer>>> compressedMatrix(int[][] A){
		Map<Integer, List<List<Integer>>> matrixMap = new HashMap<>();
		int row = A.length;
		int col = A[0].length;
		
		for(int i=0;i<row;i++) {
			matrixMap.putIfAbsent(i, new ArrayList<>());
			for(int j=0;j<col;j++) {
				if(A[i][j]!=0) {
					matrixMap.get(i).add(List.of(A[i][j],j));
				}
			}
			
		}
		
		return matrixMap;
	}
	
	public static void main(String[] args) {
		
		int[][] A = {{1,0,0},{-1,0,3}}; //2,3
		int[][] B = {{7,0,0},{0,0,0},{0,0,1}};//3,3
		
		int[][] multipliedMatrix = multiplyTwoMatrices(A, B);
		System.out.println(Arrays.deepToString(multipliedMatrix));
		
		int[][] C = {{1,5,9},{5,1,2}};
		int[][] D = {{3,4},{7,1},{0,2}};
		
		int[][] multipliedMatrix2 = multiplyTwoMatrices(C, D);
		System.out.println(Arrays.deepToString(multipliedMatrix2));
		
	
		int[][] E = {{1,0},{0,0}, {4,0}};
		int[][] F = {{1,0,1},{2,0,0}};
		
		int[][] multipliedSparseMatrix = matrixMultiplicationForSparseMatrices(E, F);
		System.out.println(Arrays.deepToString(multipliedSparseMatrix));
		
		
		
	}

}
