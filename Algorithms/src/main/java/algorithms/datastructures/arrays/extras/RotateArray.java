package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateArray {
	
	public static List<Integer> rotateArrayToRight(List<Integer> integerArray, int rotateBy) {
		int size = integerArray.size();
		
		if(rotateBy==0 || rotateBy==size) {
			return integerArray;
		}
		
		if(rotateBy>size) {
			rotateBy %= size;
		}
		
		if(rotateBy<0) {
			rotateBy = size - Math.abs(rotateBy)%size;
		}
		
		Collections.reverse(integerArray.subList(0, size-rotateBy));
		Collections.reverse(integerArray.subList(size-rotateBy, size));
		Collections.reverse(integerArray);
		
		return integerArray;
	}
	
	public static List<Integer> rotateArrayToLeft(List<Integer> integerArray, int rotateBy) {
		int size = integerArray.size();
		
		if(rotateBy==0 || rotateBy==size) {
			return integerArray;
		}
		
		if(rotateBy>size) {
			rotateBy %= size;
		}
		
		if(rotateBy<0) {
			rotateBy = size - Math.abs(rotateBy)%size;
		}
		
		Collections.reverse(integerArray.subList(0, rotateBy));
		Collections.reverse(integerArray.subList(rotateBy, size));
		Collections.reverse(integerArray);
		
		return integerArray;
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(5);
		integerArray.add(7);
		integerArray.add(8);
		integerArray.add(9);
		integerArray.add(10);
		integerArray.add(11);
		integerArray.add(12);
		
		System.out.println(integerArray);
		List<Integer> rotatedArrayToRight = rotateArrayToRight(integerArray, -18);
		System.out.println(rotatedArrayToRight);
/*		List<Integer> rotatedArrayToLeft = rotateArrayToLeft(integerArray, 13);
		System.out.println(rotatedArrayToLeft);*/
		
	}

}
