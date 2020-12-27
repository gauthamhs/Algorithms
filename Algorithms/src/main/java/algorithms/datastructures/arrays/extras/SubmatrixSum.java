package algorithms.datastructures.arrays.extras;

import java.util.Arrays;

public class SubmatrixSum {
	
	public static int[] submatrixSum(int[][] arr) {
		
		if(arr==null || arr.length==1) {
			return new int[0];
		}
		int counter = 0;
		int sum = 0;
		int[] result = new int[arr[0].length-2];
		
		while(counter<arr[0].length-2) {
		sum = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=counter;j<counter+3 && j<arr[0].length;j++) {
				sum+=arr[i][j];
			}
		}
		result[counter] = sum;
		counter++;
		}
		
		
		return result;
		
	}
	
	public static void main(String[] args) {
		
		int[][] arr = {
				{1,2,4,9,7,4},
				{2,4,5,6,8,3},
				{1,2,9,7,6,7}
		};
		
		int[] sum = submatrixSum(arr);
		System.out.println(Arrays.toString(sum));
		
		
		
	}

}
