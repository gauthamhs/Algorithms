package algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation {
	
	// Permutation with Duplicates.
	
	public static List<List<Integer>> permutationWithDuplicates(List<Integer> nums){
		Collections.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		if(nums==null || nums.size()==0) {
			return result;
		}
		
		boolean[] visited = new boolean[nums.size()];
		permuteListWithDuplicates(nums, result, visited, tempList);
		return result;
	}
	
	public static void permuteListWithDuplicates(List<Integer> nums, List<List<Integer>> result, boolean[] visited, List<Integer> tempList) {
		if(tempList.size()==nums.size()) {
			result.add(new ArrayList<>(tempList));
			return;
		}
		
		
		for(int j=0;j<nums.size();j++) {
			if(visited[j]) continue;
			if(j>0 && !visited[j-1] && nums.get(j)==nums.get(j-1)) continue;
			visited[j]=true;
			tempList.add(nums.get(j));
			permuteListWithDuplicates(nums, result, visited, tempList);
			visited[j]=false;
			tempList.remove(tempList.size()-1);
			
			
		}
	}
	
	// Permutation without Duplicates.
	
	public static List<List<Integer>> permutationWithoutDuplicates(List<Integer> nums){
		List<List<Integer>> result = new ArrayList<>();
		if(nums==null || nums.size()==0) {
			return result;
		}
		permuteListWithoutDuplicates(0, nums, result);
		return result;
	}
	
	public static void permuteListWithoutDuplicates(int i, List<Integer> nums, List<List<Integer>> result) {
		if(i==nums.size()) {
			result.add(new ArrayList<>(nums));
			return;
		}
		
		for(int j=i;j<nums.size();j++) {
			Collections.swap(nums, i, j);
			permuteListWithoutDuplicates(i+1, nums, result);
			Collections.swap(nums, i, j);
			
		}
	}
	
	// Permute a String.
	
	public static List<String> permuteString(String s){
		List<String> result = new ArrayList<>();
		permuteStringHelper("", s, result);
		return result;
		
	}
	
	public static void permuteStringHelper(String prefix, String suffix, List<String> result) {
		if(suffix.length()==0) {
			result.add(new String(prefix));
			return;
		}
		
		for(int i=0;i<suffix.length();i++) {
			permuteStringHelper(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1), result);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[] {1,2,3})) ;
		List<List<Integer>> permutedListWithoutDuplicates = permutationWithoutDuplicates(nums);
		System.out.println(permutedListWithoutDuplicates);
		
		String s = "ABC";
		List<String> permutedString = permuteString(s);
		System.out.println(permutedString);
		
		List<Integer> nums1 = new ArrayList<>(Arrays.asList(new Integer[] {1,1,2})) ;
		List<List<Integer>> permutedListwithDuplicates = permutationWithDuplicates(nums1);
		System.out.println(permutedListwithDuplicates);
		
	}

}
