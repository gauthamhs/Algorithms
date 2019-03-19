package algorithms.datastructures.arrays.extras;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	/*Time Complexity: O(n^2)*/
	
	public static int[] twoSumBruteForce(int[] nums, int target) {
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(target-nums[j]==nums[i]) {
					result[0]=i;
					result[1]=j;
					return result;
				}
			}
		}
		
		return result;
		
	}
	
	/*Time Complexity: O(n)
	 * One Pass*/
	
	public static int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> sumMap = new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			int complement = target-nums[i];
			if(sumMap.containsKey(complement)) {
				return new int[] {sumMap.get(complement), i};
			}
			sumMap.put(nums[i], i);
		}
		
		return new int[2];
	}
	

	public static void main(String[] args) {
		int[] nums = {11,2,7,15};
		int target = 9;
		int[] arrayIndicesBrute = twoSumBruteForce(nums, target);
		System.out.println(Arrays.toString(arrayIndicesBrute));
		
		int[] arrayIndices = twoSum(nums, target);
		System.out.println(Arrays.toString(arrayIndices));

		
	}
}
