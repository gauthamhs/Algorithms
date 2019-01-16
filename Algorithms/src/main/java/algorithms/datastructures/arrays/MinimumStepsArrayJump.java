package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumStepsArrayJump {
	
	public static int minNumberOfSteps(List<Integer> integerArray) {
		
		if(integerArray.isEmpty() || integerArray.get(0) == 0){
		return 0;	
		}
		
		List<Integer> minPathArray = new ArrayList<>(Collections.nCopies(integerArray.size(), Integer.MAX_VALUE));
		List<Integer> jumpPathArray = new ArrayList<>(Collections.nCopies(integerArray.size(), Integer.MAX_VALUE));
		
		minPathArray.set(0, 0);
		jumpPathArray.set(0, 0);
		
		for(int i = 1;i<integerArray.size();i++) {
			for(int j = 0;j<i;j++) {
				if((integerArray.get(j) + j)>=i ) {
					minPathArray.set(i, Math.min(minPathArray.get(i), minPathArray.get(j) + 1));
					jumpPathArray.set(i, Math.min(jumpPathArray.get(i), j));
				}
			}
		}
		return minPathArray.get(integerArray.size()-1);
		
	}
	
	public static void main(String[] args) {
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

		
		int minSteps = minNumberOfSteps(integerArray);
		System.out.println("Min Steps to reach last index is: " + minSteps);
		
	}

}

