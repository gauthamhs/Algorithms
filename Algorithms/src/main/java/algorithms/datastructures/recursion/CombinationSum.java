package algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        
	        Arrays.sort(candidates);
	        List<List<Integer>> result = new ArrayList<>();
	        combinationSumHelper(0, new ArrayList<>(), candidates, target, result);
	        return result;
	        
	    }
	    
	    public static void combinationSumHelper(int currentIndex, List<Integer> combinationList, int[] candidates, 
	                                     int target, List<List<Integer>> result){
	        
	        
	        if(target<0){
	            return;
	        }
	        
	        else if(target == 0){
	            result.add(new ArrayList<>(combinationList));
	            return;
	        }
	        
	        for(int i=currentIndex; i<candidates.length;i++){
	            
	            if(candidates[i]>target){
	                break;
	            }
	            
	            if(i!=currentIndex && candidates[i]==candidates[i-1])continue;
	            
	            combinationList.add(candidates[i]);
	            combinationSumHelper(i, combinationList, candidates, target - candidates[i], result);
	            combinationList.remove(combinationList.size()-1);
	        }
	    }
	
	    public static void main(String[] args) {
			int[] nums = {2,2,3,7};
			int target = 7;
			List<List<Integer>> combinationSum = combinationSum(nums, target);
			System.out.println(combinationSum);
			
		}
}
