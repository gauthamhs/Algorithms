package algorithms.sort.extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NonConstructibleValue {
	
	public static int nonConstructibleValue(List<Integer> coins) {
		
		Collections.sort(coins);
		int minNonConstructibleValue = 0;
		
		for(Integer coin: coins) {
			if(coin>minNonConstructibleValue+1) {
				break;
			} 
			
			minNonConstructibleValue += coin;
		}
		
		return minNonConstructibleValue+1;
	}
	
	public static void main(String[] args) {
		
		List<Integer> coins = new ArrayList<>(Arrays.asList(new Integer[] {12,2,1,15,2,4}));
		int nonDestructibleValue = nonConstructibleValue(coins);
		System.out.println(nonDestructibleValue);
	}

}
