package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.List;

public class NextGreatestElement {
	
/*	For this program, we fill each array slot with the next greatest element. 
	For example, if we have an array of A= {3,4,20,6,15,2,1,7}, we should return
	{20,20,20,15,15,7,7,7}. In short, we are filling each array slot with the
	next greatest element	*/
	
	/*Complexity: O(n^2)*/
	public static List<Integer> nextGreatestElement(List<Integer> integerArray){
		

		for (int i =0;i<integerArray.size()-1;i++) {
			int maximum = integerArray.get(i);
			for(int j=i+1;j<integerArray.size();j++) {
				maximum = Math.max(maximum, integerArray.get(j));
			}
			integerArray.set(i, maximum);
		}
		return integerArray;
	}
	
	/*Complexity: O(n)*/
	public static List<Integer> nextGreatestElementEfficient(List<Integer> integerArray){
		
		int lastIndex = integerArray.size()-1;
			int maximum = integerArray.get(lastIndex);
			for(int i=lastIndex-1;i>=0;i--) {
				if(integerArray.get(i)>maximum) {
					maximum = integerArray.get(i);
			} else {
				integerArray.set(i, maximum);
			}
		}
		return integerArray;
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(3);
		integerArray.add(4);
		integerArray.add(20);
		integerArray.add(6);
		integerArray.add(15);
		integerArray.add(2);
		integerArray.add(1);
		integerArray.add(7);
		
		System.out.println(integerArray);
		List<Integer> nextGreatestElementArray = nextGreatestElement(integerArray);
		List<Integer> nextGreatestElementArrayEfficient = nextGreatestElementEfficient(integerArray);
		System.out.println(nextGreatestElementArray);
		System.out.println(nextGreatestElementArrayEfficient);
		
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
