package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {
	
	public static List<Integer> mergeTwoSortedArrays(List<Integer> sortedArray1, List<Integer> sortedArray2){
		List<Integer> mergedArray = new ArrayList<>();
		int sortedArray1Size = sortedArray1.size();
		int sortedArray2Size = sortedArray2.size();
		
		int i=0;
		int j=0;
		
		while(i<sortedArray1Size && j<sortedArray2Size) {
			if(sortedArray1.get(i)<=sortedArray2.get(j)) {
				mergedArray.add(sortedArray1.get(i));
				++i;
			} else {
				mergedArray.add(sortedArray2.get(j));
				++j;
			}
		}
		
		while(i<sortedArray1Size) {
			mergedArray.add(sortedArray1.get(i));
			++i;
		}
		
		while(j<sortedArray2Size) {
			mergedArray.add(sortedArray2.get(j));
			++j;
		}
		
		return mergedArray;	
	}
	
	public static void main(String[] args) {
		List<Integer> sortedArray1 = new ArrayList<>();
		sortedArray1.add(1);
		sortedArray1.add(3);
		sortedArray1.add(5);
		sortedArray1.add(7);
		sortedArray1.add(9);
		
		List<Integer> sortedArray2 = new ArrayList<>();
		sortedArray2.add(2);
		sortedArray2.add(4);
		sortedArray2.add(8);
		sortedArray2.add(10);
		sortedArray2.add(11);
		sortedArray2.add(12);
		sortedArray2.add(16);
		
		List<Integer> mergedArray = mergeTwoSortedArrays(sortedArray1, sortedArray2);
		System.out.println(mergedArray);
	}

}
