package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++) {
        	for(int j=i+1;j<nums.length;j++) {
        		for(int k=j+1;k<nums.length;k++) {
        			if(nums[i]+nums[j]+nums[k]==0) {
        				result.add(Arrays.asList(nums[i],nums[j],nums[k]));
        			}
        		}
        	}
        }
        
        return result;
    }
    
    public static List<List<Integer>> threeSumEfficient(int[] nums){
    	 
        List<List<Integer>> result = new ArrayList<>();
    	
    	Arrays.sort(nums);
    	
    	for(int i=0;i<nums.length-2;i++) {
    		if(i==0||nums[i]>nums[i-1]) {
    			int start = i+1;
    			int end = nums.length-1;
    			while(start<end) {
    				
    				if(nums[i]+nums[start]+nums[end]==0) {
                        
    				result.add(Arrays.asList(nums[i],nums[start],nums[end]));
    					
                    while(start<end && nums[start]==nums[start+1]) {
    					++start;
    				}
    				
    				while(start<end && nums[end]==nums[end-1]) {
    					--end;
    				}	
                        
                    ++start;
                    --end;
        				
    				} else if(nums[i]+nums[start]+nums[end]<0) {
    					++start;
    				}else {
    					--end;
    				}	
    			}
    		}
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> threeSum = threeSum(nums);
		System.out.println(threeSum);
		
		List<List<Integer>> threeSumEfficient = threeSumEfficient(nums);
		System.out.println(threeSumEfficient);
		
	}

}
