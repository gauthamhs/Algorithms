package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;


public class DeleteDuplicateFromSortedArray {
	
	// Deletes duplicate elements in O(n) space and O(n) time complexity;
	public static List<Integer> deleteDuplicateElements1(List<Integer> integerArray){
		List<Integer> uniqueArray = new ArrayList<>();
		
		for(int i = 0;i<integerArray.size()-1;i++) {
			if(integerArray.get(i) != integerArray.get(i+1)) {
				uniqueArray.add(integerArray.get(i));
			}
		}
		uniqueArray.add(integerArray.get(integerArray.size()-1));
		
		return uniqueArray;
	}
	
	// Deletes duplicate elements in O(1) space and O(n) time complexity;
	public static List<Integer> deleteDuplicateElements2(List<Integer> integerArray){

		int j = 0;
		for(int i = 0;i<integerArray.size()-1;i++) {
			if(integerArray.get(i) != integerArray.get(i+1)) {
				integerArray.set(j, integerArray.get(i));
				j++;
			}
		}

		integerArray.set(j, integerArray.get(integerArray.size()-1));
		return integerArray.subList(0, j+1);
	}
	
	public static List<Integer> deleteElementBasedOnKey(List<Integer> integerArray, int key){

		int j = 0;
		for(int i = 0;i<integerArray.size();i++) {
			if(integerArray.get(i) != key) {
				integerArray.set(j, integerArray.get(i));
				j++;
			}
		}

		return integerArray.subList(0, j+1);
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray1 = new ArrayList<>();
		integerArray1.add(0);
		integerArray1.add(1);
		integerArray1.add(2);
		integerArray1.add(2);
		integerArray1.add(3);
		integerArray1.add(4);
		integerArray1.add(4);
		integerArray1.add(4);
		integerArray1.add(5);
		integerArray1.add(5);
		
		List<Integer> integerArray2 = new ArrayList<>();
		integerArray2.add(0);
		integerArray2.add(1);
		integerArray2.add(2);
		integerArray2.add(2);
		integerArray2.add(3);
		integerArray2.add(4);
		integerArray2.add(4);
		integerArray2.add(4);
		integerArray2.add(5);
		integerArray2.add(5);
		integerArray2.add(6);
		integerArray2.add(6);
		
		List<Integer> uniqueArray1 = deleteDuplicateElements1(integerArray1);
		System.out.println(printArray(uniqueArray1));
		
/*		List<Integer> uniqueArray2 = deleteDuplicateElements2(integerArray1);
		System.out.println(printArray(uniqueArray2));*/
		
		List<Integer> uniqueArray3 = deleteElementBasedOnKey(integerArray2, 2);
		System.out.println(printArray(uniqueArray3));
		
		}
	
	public static String printArray(List<Integer> sortedList){

		StringBuilder sb = new StringBuilder("");
		for(Integer i: sortedList){
		sb.append(i);
		}
		return sb.toString();

		}

}
