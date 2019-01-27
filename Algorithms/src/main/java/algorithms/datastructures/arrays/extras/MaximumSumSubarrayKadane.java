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
		integerArray.add(4);
		integerArray.add(-3);
		integerArray.add(-2);
		integerArray.add(2);
		integerArray.add(3);
		integerArray.add(1);
		integerArray.add(-2);
		integerArray.add(-3);
		integerArray.add(4);
		integerArray.add(2);
		integerArray.add(-6);
		integerArray.add(-3);
		integerArray.add(-1);
		integerArray.add(3);
		integerArray.add(1);
		integerArray.add(2);
		System.out.println(integerArray);
		
		Elements elements = getMaximumSumSubArray(integerArray);
		System.out.println(elements.getMaximumSum());
		System.out.println(elements.getSubarray());
	
	}

}
