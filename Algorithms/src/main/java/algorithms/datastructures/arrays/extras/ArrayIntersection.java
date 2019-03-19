
package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayIntersection {
	
	//BruteForce
	// In this method, we are trying to find the common elements between two arrays. 
	// First method is a brute force method we are joining the two loops.
	
	public static List<Integer> intersectionOfTwoArrays(List<Integer> list1, List<Integer> list2){
		
		List<Integer> intersectedList = new ArrayList<>();
		
		for(int i=0;i<list1.size();i++) {
			if((i==0 || list1.get(i)!=list1.get(i-1)) && list2.contains(list1.get(i))) {
				intersectedList.add(list1.get(i));
			}
		}
		
		return intersectedList;
		
	}
	
	//Efficient O(m+n) 
	public static List<Integer> intersectionOfTwoArraysEfficient(List<Integer> list1, List<Integer> list2){
		
		List<Integer> intersectedList = new ArrayList<>();
		int n1 = list1.size();
		int n2 = list2.size();
		
		int i=0;
		int j=0;
		
		while(i<n1 && j<n2) {
			if((i==0 || list1.get(i)!=list1.get(i-1)) && list1.get(i)==list2.get(j)) {
				intersectedList.add(list1.get(i));
				i++;
				j++;
			} else if(list1.get(i)<list2.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		
		return intersectedList;
		
	}
	
	
	// Using Set.
	
	public static Set<Integer> commonElements(int[] list1, int[] list2){
		Set<Integer> distinctSet = new HashSet<>();
		int list1Length = list1.length;
		int list2Length = list2.length;
		int p = 0;
		int q = 0;
		
		while(p<list1Length && q<list2Length) {
			
			if(list1[p]==list2[q]) {
				distinctSet.add(list1[p]);
				++p;
				++q;
			} else if(list1[p]<list2[q]) {
				++p;
			} else {
				++q;
			}
		}
		return distinctSet;
	}
	
	
	
	public static void main(String[] args) {
		int[] list1 = {1,4,6,8,11,13,18};
		int[] list2 = {5,6,7,8,14,18,20};
		
		Set<Integer> commonElements = commonElements(list1, list2);
		System.out.println(commonElements);
		
		List<Integer> list1Array = Arrays.stream(list1).boxed().collect(Collectors.toList());
		List<Integer> list2Array = Arrays.stream(list2).boxed().collect(Collectors.toList());
		
		List<Integer> intersectedListBrute = intersectionOfTwoArrays(list1Array, list2Array);
		System.out.println(intersectedListBrute);
		
		List<Integer> intersectedListEfficient = intersectionOfTwoArraysEfficient(list1Array, list2Array);
		System.out.println(intersectedListEfficient);
		
		
	}

}
