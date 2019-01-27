package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class CanJump {
	
	public static void main(String[] args) {
		
		List<Integer> array1 = new ArrayList<>();
		array1.add(2);
		array1.add(1);
		
		boolean canJump = canJump(array1);
		System.out.println(canJump);
		
	}
	
	public static boolean canJump(List<Integer> steps) {
		
		int maximum = 0;
		int lastIndex = steps.size() - 1;
		
		for (int i = 0; i < steps.size(); i++) {
			//Check if a hop to last index is possible
			if(maximum<=i && steps.get(i) == 0) {
				return false;
			}
			// Find the maximum
			maximum = Math.max(maximum, i + steps.get(i));
			
			// If maximum>=lastIndex, It can reach last index.
			if(maximum>=lastIndex) {
				return true;
			}
		}
			
		return false;
		
	}

}
