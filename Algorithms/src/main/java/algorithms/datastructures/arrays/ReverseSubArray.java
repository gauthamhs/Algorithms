package algorithms.datastructures.arrays;

import java.util.Arrays;

public class ReverseSubArray {
	
    public static void reverseArray(int[] nums, int startIndex, int endIndex){
        while(startIndex<endIndex){
            if(nums[startIndex]!=nums[endIndex]){
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;  
            }
            startIndex++;
            endIndex--;
            
        }
    }
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5,6};
		System.out.println(Arrays.toString(array));
		reverseArray(array, 0, 3);
		System.out.println(Arrays.toString(array));
		
	}

}
