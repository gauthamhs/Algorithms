package algorithms.datastructures.arrays.extras;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountSmallerNumbersAfterSelf {
	
    public static List<Integer> countSmaller(int[] nums) {
        
        if(nums.length==0){
            return Collections.emptyList();
        }
        int N = nums.length;
        int[] counts = new int[N];
        counts[N-1] = 0;
        
        
        for(int i=N-2;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    counts[i]=1+counts[i];
                }
            }
        }
        
        List<Integer> countsArray = Arrays.stream(counts).boxed().collect(Collectors.toList());
        return countsArray;
}
	
	public static void main(String[] args) {
		int[] nums= {0,2,1};
		System.out.println(countSmaller(nums));
	}

}
