package algorithms.sort.extras;

public class SearchInSortedRotatedArray {
	
	//Note if there are duplicates, then we need to add an additional condition for a[start]==a[mid]==a[length], where we either increment ++left or --right;
	
	public static int searchInRotatedArray(int[] nums, int target) {
		
		int low = 0;
		int high = nums.length-1;
		
		while(low<=high) {
			
			int mid = low + (high-low)/2;
			
			if(nums[mid] == target) {
				return mid;
			}
			
			// Check if Low and mid are sorted
			if(nums[low]<=nums[mid]) {
				
				if(target>=nums[low] && target<nums[mid]) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			
				// If that is not sorted, then right half is sorted.
			} else { 
				if(target>=nums[mid] && target<=nums[high]) {
					low = mid+1;
				} else {
					high = mid-1;
				}
			}
		}
		
		return -1;
		
	}
	
	public static int searchPivotIndex(int[] array) {
		int low = 0;
		int high = array.length-1;
		
		while(low<high) {
			int mid = low + (high-low)/2;
			
			if(array[mid]>array[high]) {
				low = mid+1;
			} else {
				high = mid;
			}
			
		}
		
		return low;
	}
	
	public static void main(String[] args) {
		
		int[] array = {378,478,550,631,103,203,220,234,279,368};
		int rotatedPivotIndex = searchPivotIndex(array);
		System.out.println(rotatedPivotIndex);
		
		int searchElementInRotatedArray = searchInRotatedArray(array, 378);
		System.out.println(searchElementInRotatedArray);
		
		int[] array2 = {3,4,5,1,2};
		int rotatedPivotIndex2 = searchPivotIndex(array2);
		System.out.println(rotatedPivotIndex2);
		
	}

}
