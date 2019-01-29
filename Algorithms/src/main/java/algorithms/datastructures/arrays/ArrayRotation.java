package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayRotation {
	
	public static List<Integer> rightRotatedArray(List<Integer> integerArray, int rotateBy){
		
		
		int arrayLength = integerArray.size();
		
		rotateBy %= arrayLength; 
		if(rotateBy==0) {
			return integerArray;
		}
		Collections.reverse(integerArray.subList(0, arrayLength-rotateBy));
		Collections.reverse(integerArray.subList(arrayLength-rotateBy, arrayLength));
		Collections.reverse(integerArray);
		
		return integerArray;
		
	}
	
	public static List<Integer> leftRotatedArray(List<Integer> integerArray, int rotateBy){
		
		
		int arrayLength = integerArray.size();
		
		rotateBy %= arrayLength; 
		if(rotateBy==0) {
			return integerArray;
		}
		Collections.reverse(integerArray.subList(0, rotateBy));
		Collections.reverse(integerArray.subList(rotateBy, arrayLength));
		Collections.reverse(integerArray);
		
		return integerArray;
		
	}
	
	public static boolean isArrayRotated(List<Integer> originalArray, List<Integer> rotatedArray) {
		
		int size = originalArray.size();
		int rotatedArraySize = rotatedArray.size();
		int i;
		int j;
		
		if(size!=rotatedArraySize) {
			return false;
		}
		int firstElement = originalArray.get(0);
		int rotatedElementIndex = -1;
		
		for( i=0;i<size;i++) {
			if(firstElement == rotatedArray.get(i)) {
				rotatedElementIndex = i;
				break;
			}
		}
		if(rotatedElementIndex == -1) {
			return false;
		}
		

		
		for( j=0;j<size;j++) {
			if(originalArray.get(j)!=rotatedArray.get(rotatedElementIndex)) {
				return false;
			}
			rotatedElementIndex = (rotatedElementIndex +1)%size;

			
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(5);
		integerArray.add(6);
		integerArray.add(8);
		integerArray.add(9);
		integerArray.add(11);
		integerArray.add(12);
		System.out.println(integerArray);
		List<Integer> rightRotatedResult  = rightRotatedArray(integerArray, 2);
		System.out.println(rightRotatedResult);
		List<Integer> leftRotatedResult  = leftRotatedArray(integerArray, 2);
		System.out.println(leftRotatedResult);
		
		List<Integer> rotatedArray = new ArrayList<>();
		rotatedArray.add(8);
		rotatedArray.add(9);
		rotatedArray.add(11);
		rotatedArray.add(12);
		rotatedArray.add(5);
		rotatedArray.add(6);
		
		boolean isArrayRotated = isArrayRotated(integerArray, rotatedArray);
		System.out.println(isArrayRotated);
		
		
		
	}
}
