package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Elements{
	int minSteps;
	List<Integer> minPathArray;
	List<Integer> jumpPathArray;
	
	public int getMinSteps() {
		return minSteps;
	}
	
	public void setMinSteps(int minSteps) {
		this.minSteps = minSteps;
	}
	
	public List<Integer> getMinPathArray() {
		return minPathArray;
	}
	
	public void setMinPathArray(List<Integer> minPathArray) {
		this.minPathArray = minPathArray;
	}
	
	public List<Integer> getJumpPathArray() {
		return jumpPathArray;
	}
	
	public void setJumpPathArray(List<Integer> jumpPathArray) {
		this.jumpPathArray = jumpPathArray;
	}
	
}

public class MinPathJumpPath {
	
public static Elements minNumberOfSteps(List<Integer> integerArray) {
	
	Elements elements = new Elements();
	List<Integer> minPathArray = new ArrayList<>(Collections.nCopies(integerArray.size(), Integer.MAX_VALUE));
	List<Integer> jumpPathArray = new ArrayList<>(Collections.nCopies(integerArray.size(), Integer.MAX_VALUE));
	
	minPathArray.set(0, 0);
	jumpPathArray.set(0, 0);
	
		
		if(integerArray.isEmpty() || integerArray.get(0) == 0){
			elements.setMinSteps(0);
		return elements;	
		}

		
		for(int i = 1;i<integerArray.size();i++) {
			for(int j = 0;j<i;j++) {
				if((integerArray.get(j) + j)>=i ) {
					minPathArray.set(i, Math.min(minPathArray.get(i), minPathArray.get(j) + 1));
					jumpPathArray.set(i, Math.min(jumpPathArray.get(i), j));
				}
			}
		}
		int minSteps = minPathArray.get(integerArray.size()-1);
		elements.setJumpPathArray(jumpPathArray);
		elements.setMinPathArray(minPathArray);
		elements.setMinSteps(minSteps);
		return elements;
		
	}
	
	public static void main(String[] args) {
		Elements elements = new Elements();
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(2);
		integerArray.add(1);
		integerArray.add(3);
		integerArray.add(2);
		integerArray.add(3);
		integerArray.add(4);
		integerArray.add(5);
		integerArray.add(1);
		integerArray.add(2);
		integerArray.add(8);
		
		System.out.println("Original Array: " + integerArray);

		elements = minNumberOfSteps(integerArray);
		System.out.println("Min Steps to reach last index is: " + elements.getMinSteps());
		System.out.println("MinPathArray: " + printArray(elements.getMinPathArray()));
		System.out.println("JumpPathArray: " + printArray(elements.getJumpPathArray()));
		System.out.println("JumpPathTrace: " + printArray(jumpPathTrace(elements.getJumpPathArray())));
		System.out.println();
	}
	
	public static List<Integer> jumpPathTrace(List<Integer> intArr) {
		List<Integer> arr = new ArrayList<>();
		int i = intArr.size()-1;
		
		arr.add(i);
		
		while(i>0) {
			arr.add(intArr.get(i));
			i = intArr.get(i);
		}
		
		Collections.reverse(arr);
		
		return  arr;
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
