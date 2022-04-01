package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DeleteDuplicateFromSortedArray {
	
	// Deletes duplicate elements in O(n) space and O(n) time complexity;
	public static List<Integer> deleteDuplicateElements1(List<Integer> integerArray){
		List<Integer> uniqueArray = new ArrayList<>();
		
		for(int i = 0;i<integerArray.size() - 1;i++) {
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
				integerArray.set(j++, integerArray.get(i));
			}
		}

		integerArray.set(j++, integerArray.get(integerArray.size()-1));
		return integerArray.subList(0, j);
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
	
    public static int removeDuplicates(int[] nums) {
        
        int j = 0;
        int lastIndex = nums.length - 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
               nums[j] = nums[i];
                j++;
            }
            
        }
        nums[j] =  nums[lastIndex];
        return Arrays.copyOfRange(nums,0,j+1).length;
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
		
		int[] arraya= {1,2,3};
		
		int length = removeDuplicates(arraya);
		System.out.println(length);
		
		
		List<Integer> uniqueArray1 = deleteDuplicateElements1(integerArray1);
		System.out.println(printArray(uniqueArray1));
		
/*		List<Integer> uniqueArray2 = deleteDuplicateElements2(integerArray1);
		System.out.println(printArray(uniqueArray2));*/
		
		List<Integer> uniqueArray3 = deleteElementBasedOnKey(integerArray2, 2);
		System.out.println(printArray(uniqueArray3));
		
		int[] nums = {3,2,2,3};
		int val =3;
		int lengths = removeElement(nums, val);
		System.out.println(lengths);
		
		System.out.println(deleteDuplicateElementsJava8(List.of(1,2,2,3,3,4,5,5,6,7,7)));
		
		
		}
	
    public static int removeElement(int[] nums, int val) {
        
        int j = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        
        nums = Arrays.copyOfRange(nums, 0, j);
        return nums.length;
    }
    
    public static List<Integer> deleteDuplicateElementsJava8(List<Integer> arrayOfIntegers) {
    	return arrayOfIntegers.stream().distinct().collect(Collectors.toList());
    }
	
	public static String printArray(List<Integer> arrayOfIntegers){

		StringBuilder sb = new StringBuilder("");
		for(int i = 0;i<=arrayOfIntegers.size()-1;i++){
		sb.append(arrayOfIntegers.get(i));
		if(i<arrayOfIntegers.size() - 1){
		sb.append(", ");
		}
		}
		return sb.toString();

		}

}
