package algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {
	
	public static List<List<Integer>> generateSubsetsWithoutDuplicates(List<Integer> nums){
		List<List<Integer>> result = new ArrayList<>();
		generateSubsetsWithoutDuplicatesHelper(0, nums, new ArrayList<>(), result);
		return result;
	}
	
	public static void generateSubsetsWithoutDuplicatesHelper(int currentIndex,List<Integer> nums,  List<Integer> elementList, List<List<Integer>> result) {
		if(currentIndex == nums.size()) {
			result.add(new ArrayList<>(elementList));
			return;
		}
		
		elementList.add(nums.get(currentIndex));
		generateSubsetsWithoutDuplicatesHelper(currentIndex+1, nums, elementList, result);
		elementList.remove(elementList.size()-1);
		generateSubsetsWithoutDuplicatesHelper(currentIndex+1, nums, elementList, result);
		
	}
	
	public static List<List<Integer>> generateSubsetsWithDuplicates(List<Integer> nums){
		Collections.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		generateSubsetsWithDuplicateHelper(0, nums, result, new ArrayList<>());
		return result;
	}
	
	public static void generateSubsetsWithDuplicateHelper(int currentIndex, List<Integer> nums,List<List<Integer>> result, List<Integer> tempList) {
		result.add(new ArrayList<>(tempList));
		
		for(int i=currentIndex; i<nums.size();i++) {
			if(i != currentIndex && nums.get(i)==nums.get(i-1)) continue;
			tempList.add(nums.get(i));
			generateSubsetsWithDuplicateHelper(i+1, nums, result, tempList);
			tempList.remove(tempList.size()-1);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[] {1,2,3}));
		List<List<Integer>> subsetsWithoutDuplicates = generateSubsetsWithoutDuplicates(nums);
		System.out.println(subsetsWithoutDuplicates);
		
		List<Integer> nums1 = new ArrayList<>(Arrays.asList(new Integer[] {1,2,1}));
		
		List<List<Integer>> subsetsWithDuplicates = generateSubsetsWithDuplicates(nums1);
		System.out.println(subsetsWithDuplicates);
		
		
		
	}

}
