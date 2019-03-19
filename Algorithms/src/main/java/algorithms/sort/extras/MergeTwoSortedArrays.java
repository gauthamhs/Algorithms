package algorithms.sort.extras;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int a=m-1;
        int  b=n-1;
        int writeIndex = m+n-1;
        
        while(a>=0 & b>=0){
            nums1[writeIndex--] = nums1[a]>nums2[b] ? nums1[a--] : nums2[b--];
        }
        
        while(b>=0){
            nums1[writeIndex--] = nums2[b--];
        }
        
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,3,4,0,0,0};
		int[] nums2 = {2,5,6};
		
		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}

}
