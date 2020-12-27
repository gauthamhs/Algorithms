package algorithms.sort.extras;

import java.util.Arrays;

public class SearchOccurrences {
	
	 public static int[] searchRange(int[] nums, int target) {
	        
	        int[] result = new int[2];
	        result[0] = firstPosition(nums, target) ;
	        result[1] = lastPosition(nums, target);
	        
	        return result;
	        
	    }
	    
	    public static int firstPosition(int[] nums, int target){
	        int low = 0;
	        int high = nums.length-1;
	        int result = -1;
	        
	        while(low<=high){
	            int mid = low + (high-low)/2;
	            
	            if(nums[mid] == target) {
	                result = mid;
	                high = mid-1;
	            }
	            else if(nums[mid]<target){
	                low = mid + 1;
	            } else if(nums[mid]>target){
	                high = mid-1;
	            }
	        }
	        
	        return result;
	    }
	    
	    public static int lastPosition(int[] nums, int target){
	        int low = 0;
	        int high = nums.length-1;
	        int result = -1;
	        
	        while(low<=high){
	            int mid = low + (high-low)/2;
	            
	            if(nums[mid] == target){
	                result = mid;
	                low = mid+1;
	            }
	            else if(nums[mid]<target){
	                low = mid + 1;
	            } else if(nums[mid]>target){
	                high = mid-1;
	            }
	        }
	        
	        return result;
	    }
	    
	    public static void main(String[] args) {
	    	int[] nums = {5,7,7,8,8,10};
	    	int firstPosition = firstPosition(nums, 8);
	    	int secondPosition = lastPosition(nums, 8);
	    	System.out.println(firstPosition);
	    	System.out.println(secondPosition);
			String result = Arrays.toString(searchRange(nums, 8));
			System.out.println(result);
		}

}
