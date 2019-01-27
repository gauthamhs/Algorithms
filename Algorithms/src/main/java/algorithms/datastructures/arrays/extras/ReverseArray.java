package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseArray {
	
/*	In this method, we will reverse an array */
	
	   /*Time Complexity: O(n^2)
		Space Complexity: O(1)*/
		public static List<Integer> reverseArrayLeastEfficient(List<Integer> integerArray){
			
			for(int i=0;i<integerArray.size();i++) {
				for(int j = integerArray.size()-1;j>=0;j--) {
					if(i>=j) {
						break;
					}
					Collections.swap(integerArray, i, j);
					
				}
			}
			
			return integerArray;
		}
    
	
   /*Time Complexity: O(n)
	Space Complexity: O(n)*/
	public static List<Integer> reverseArrayExtraSpace(List<Integer> integerArray){
		List<Integer> reversedArray = new ArrayList<>();
		
		for(int i=integerArray.size()-1;i>=0;i--) {
			reversedArray.add(integerArray.get(i));
		}
		
		return reversedArray;
	}
	
	/* Time Complexity: O(n)
       Space Complexity: O(1)*/
     public static List<Integer> reverseArrayConstantSpace(List<Integer> integerArray){
			
    	 int firstIndex = 0;
    	 int lastIndex = integerArray.size()-1;
    	 
    	 while(firstIndex<lastIndex) {
    		Collections.swap(integerArray, firstIndex, lastIndex);
    		firstIndex++;
    		lastIndex--;
    	 }
			
			return integerArray;
		}
		
	
	public static void main(String[] args) {
		List<Integer> originalArray = new ArrayList<>();
		originalArray.add(8);
		originalArray.add(2);
		originalArray.add(6);
		originalArray.add(5);
		originalArray.add(9);
		originalArray.add(4);
		originalArray.add(3);
		originalArray.add(2);
		originalArray.add(1);
		System.out.println(originalArray);
		
		//List<Integer> reversedArray1 = reverseArrayExtraSpace(originalArray);
		//List<Integer> reversedArray2 = reverseArrayConstantSpace(originalArray);
		List<Integer> reversedArray3 = reverseArrayConstantSpace(originalArray);
		//System.out.println(reversedArray1);
		//System.out.println(reversedArray2);
		
		System.out.println(reversedArray3);
		
		
	}

}
