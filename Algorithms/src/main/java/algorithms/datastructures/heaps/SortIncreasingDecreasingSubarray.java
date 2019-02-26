package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortIncreasingDecreasingSubarray {
	
	public enum SubArrayType{
		INCREASING, DECREASING;
	}
	
	public static List<Integer> sortIncreasingDecreasingSubArray(List<Integer> arrayList){
		List<List<Integer>> sortedSubArrays = new ArrayList<>();
		int size = arrayList.size();
		SubArrayType subArrayType = SubArrayType.INCREASING;
		int startIndex = 0;
		for(int i=1;i<=size;i++) {
			if(i==size ||
			   arrayList.get(i-1)<arrayList.get(i) && subArrayType == SubArrayType.DECREASING ||
			   arrayList.get(i-1)>arrayList.get(i) && subArrayType == SubArrayType.INCREASING) {
				List<Integer> subList = arrayList.subList(startIndex, i);
				if(subArrayType==SubArrayType.DECREASING) {
					Collections.reverse(subList);
				}
				sortedSubArrays.add(subList);
				startIndex = i;
				subArrayType = (subArrayType==SubArrayType.INCREASING) ? SubArrayType.DECREASING : SubArrayType.INCREASING;
			}
				
		}
		
		return MergeKSortedArrays.mergeKSortedLists(sortedSubArrays);
	}
	
	public static void main(String[] args) {
		
		Integer[] array = {57,131,493,493,294,221,339,339,418,452,442,190};
		List<Integer> arrayList = Arrays.asList(array);
		System.out.println(arrayList);
		List<Integer> sortedArray = sortIncreasingDecreasingSubArray(arrayList);
		System.out.println(sortedArray);
	}

}
