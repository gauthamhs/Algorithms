package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;


/*In this algorithm, we are trying to determine if we are able to reach the last index or not.
We iterate through the loop. We need to find two conditions
1) If maximum >=lastIndex. This means that we are able to reach the end. So we can return true
2) If maximum<=i and A[i]==0, this means that we will not be able to jump. So we return false
		
At each point, we track the maximum we have jumped so far.
Time Complexity: O(n)
Space Complexity: O(1)*/

public class CanJump {
	
	public static void main(String[] args) {
		
		List<Integer> array1 = new ArrayList<>();
		array1.add(3);
		array1.add(3);
		array1.add(1);
		array1.add(0);
		array1.add(2);
		array1.add(0);
		array1.add(1);
		
		boolean canJump = canJump(array1);
		System.out.println(canJump);
		
	}
	
	public static boolean canJump(List<Integer> steps) {
		
		int maximum = 0;
		int lastIndex = steps.size() - 1;
		
		for (int i = 0; i < steps.size(); i++) {
			//Check if a hop to last index is possible. If maximum<=i, Check if current val is >0 which means a hop is still possible
			if(maximum<=i && steps.get(i) == 0) {
				return false;
			}
			// Find the maximum
			maximum = Math.max(maximum, i + steps.get(i));
		}
			
		return maximum>=lastIndex;
		
	}

}
