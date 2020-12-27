package algorithms.datastructures.arrays.extras;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*In this problem, we need to identify the total number of jumps possible in order to each end of Array. 
There are two types of jumps: Odd numbered jumps and even numbered jumps
We start with odd jumps and alternate later on. In this method, we use ceilingEntry for odd jumps because that gives us the smallest key that is greater than current key
and floorEntry that gives us the largest key that is lesser than current key

Time Complexity: O(nLogn)
Space Complexity: O(n)

*/

public class OddEvenJump {

	
	public static int totalOddEvenJumps(int[] A) {
		
		int totalJumps=1;
		int N = A.length;
		boolean[] oddJumps = new boolean[N];
		boolean[] evenJumps = new boolean[N];
		
		oddJumps[N-1] = true;
		evenJumps[N-1] = true;
		
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(A[N-1], N-1);
		
		for(int i=N-2;i>=0;--i) {
		Map.Entry<Integer, Integer> odd = treeMap.ceilingEntry(A[i]);
		Map.Entry<Integer, Integer> even = treeMap.floorEntry(A[i]);
		
		if(odd!=null) oddJumps[i] = evenJumps[(int)odd.getValue()];
			
		if(even!=null) evenJumps[i] = oddJumps[(int)even.getValue()];
		
		if(oddJumps[i]) ++totalJumps;
		
		treeMap.put(A[i], i);
		}
		
		return totalJumps;
		

	}


	
	public static void main(String[] args) {
		int[] A = {10,13,12,14,15};
		int totalJumps = totalOddEvenJumps(A);
		System.out.println(totalJumps);


	}

}
