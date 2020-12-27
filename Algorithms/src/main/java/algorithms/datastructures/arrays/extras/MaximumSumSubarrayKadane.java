package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.List;

class Elements{
	private List<Integer> subarray;
	private int maximumSum;
	
	public List<Integer> getSubarray() {
		return subarray;
	}
	
	public void setSubarray(List<Integer> subarray) {
		this.subarray = subarray;
	}
	
	public int getMaximumSum() {
		return maximumSum;
	}
	
	public void setMaximumSum(int maximumSum) {
		this.maximumSum = maximumSum;
	}
	
}

public class MaximumSumSubarrayKadane {
	
	/*Complexity: O(n)*/
	
	// https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
	/*
	 * For getting the maximum Sum in Subarray: Lets follow an example: [-2] -> If
	 * there is only one element, current sum: -2 and maximum sum: -2 [-2,3] -> The
	 * maximum sum is 3 because the current subarray [3] is greater than [-2,3] so we use
	 * that as our total sum. In each iteration, we see if current sum>0, then we keep adding
	 * it to our max sum, if not, we use the current max sum
	 */
	
	public static Integer getMaximumSubArray(int[] nums){
		
		int currentSum = Integer.MIN_VALUE;
		int maximumSum = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			currentSum = Math.max(currentSum, 0) + nums[i];
			maximumSum = Math.max(currentSum, maximumSum);
		}
		
		return maximumSum;
	}
	public static Elements getMaximumSumSubArray(List<Integer> integerArray) {
		
		Elements elements = new Elements();
		int maximumSoFar = integerArray.get(0);
		int currentMaximum = 0;
		int startIndex = 0;
		int lastIndex = 0;
		int searchIndex = 0;
		
		for(int i=0;i<integerArray.size();i++) {
			currentMaximum = currentMaximum + integerArray.get(i);
			
			if(currentMaximum>maximumSoFar) {
				maximumSoFar = currentMaximum;
				startIndex = searchIndex; 
				lastIndex = i;
			}
			
			if(currentMaximum<0) {
				currentMaximum = 0;
				searchIndex =  i + 1;
			}
			
		}
		elements.setMaximumSum(maximumSoFar);
		elements.setSubarray(integerArray.subList(startIndex, lastIndex+1));
		return elements;
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		/*
		 * integerArray.add(4); integerArray.add(-3);
		 */
		integerArray.add(-2);
		/*
		 * integerArray.add(2); integerArray.add(3); integerArray.add(1);
		 * integerArray.add(-2); integerArray.add(-3); integerArray.add(4);
		 * integerArray.add(2); integerArray.add(-6); integerArray.add(-3);
		 * integerArray.add(-1); integerArray.add(3);
		 */
		integerArray.add(1);
		//integerArray.add(2);
		System.out.println(integerArray);
		
		Elements elements = getMaximumSumSubArray(integerArray);
		System.out.println(elements.getMaximumSum());
		System.out.println(elements.getSubarray());
	
	}

}
