package algorithms.datastructures.arrays.extras;

import java.util.Arrays;

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
	
	public static void main(String[] args) {
		
		int[][] A = {{1,0,0},{-1,0,3}}; //2,3
		int[][] B = {{7,0,0},{0,0,0},{0,0,1}};//3,3
		
		int[][] multipliedMatrix = multiplyTwoMatrices(A, B);
		System.out.println(Arrays.deepToString(multipliedMatrix));
		
	}

}
