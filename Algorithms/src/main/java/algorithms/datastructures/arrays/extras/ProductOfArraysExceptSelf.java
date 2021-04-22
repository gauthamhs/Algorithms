package algorithms.datastructures.arrays.extras;

import java.util.Arrays;

public class ProductOfArraysExceptSelf {
	
	public static int[] productExceptSelf(int[] nums) {
		
		int[] productArray = new int[nums.length];
		Arrays.fill(productArray, 1);
		
		int left = 1;
		
		for(int i=0;i<nums.length;i++) {
			productArray[i] = productArray[i]*left;
			left = left*nums[i];
		}
		
		int right = 1;
		for(int j=nums.length-1;j>=0;j--) {
			productArray[j] = productArray[j]*right;
			right = nums[j]*right;
		}
		
		return productArray;
		
	}
	
	public static void main(String[] args) {
		int[] array = {3,4,5,6};
		
		int[] productArray = productExceptSelf(array);
		System.out.println(Arrays.toString(productArray));
	}

}
