package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*For Array Rotations, We have to keep in mind the following things: 
	
	How many layers are there
	How many transformations we have to do per layer
	
	If we consider a 4*4 or 5*5 matrix, the no of layers = 2. We have an outermost and an innermost layer
	
	Lets use this as example: 
	
	A = [ 1   2   3   4           A = [ 13  9  5  1
	      5   6   7   8                 14  10 6  2
	      9  10  11  12    -->          15  11 7  3
	      13 14  15  16]                16  12 8  4]
	      
	      In the first layer, we do 3 transformations 1,2,3 etc
	      In the second layer, we do just one
	      
	      Algorithm: 
	      Find the layers for the array
	      Find the transformations for each layer
	      Use first layer, 2nd transformation(2) as example
	      Calculate, i' and j' which is n-i and n-j. Where n is matrix.size - 1
	      See what the values correspond to.
	*
	*/

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
