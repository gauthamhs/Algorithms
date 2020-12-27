package algorithms.datastructures.arrays.extras;

import java.util.Arrays;

public class SpiralArrayGenerator {
	
	/*Given a size, generate a spiral array of that size*/
	
	public static int[][] generateSpiralArray(int size){
		int[][] spiralArray = new int[size][size];
		int[][] MASK = {{0,1}, {1,0},{0,-1},{-1,0}};
		
		boolean[][] isVisitedArray = new boolean[size][size];
		
		int x = 0,y=0,dir = 0;
		int val = 1;
		
		for(int i=0;i<size*size;i++) {
		spiralArray[x][y] = val;
		isVisitedArray[x][y] = true;
		
		int nextX = x + MASK[dir][0];
		int nextY = y + MASK[dir][1];
		
		if(nextX<0 || nextX>=size || nextY<0 || nextY>=size || isVisitedArray[nextX][nextY]) {
			dir = (dir+1)%4;
			nextX = x + MASK[dir][0];
			nextY = y + MASK[dir][1];
		}
		
		x= nextX;
		y= nextY;
		++val;
		
		}
		
		return spiralArray;
		
	}
	
	
	public static void main(String[] args) {
		
		int size = 3;
		
		int[][] spiralArray = generateSpiralArray(size);
		//System.out.println(Arrays.deepToString(spiralArray));
		System.out.println(Arrays.deepToString(spiralArray).replace("], ", "]\n"));
		
	
		
	}

}
