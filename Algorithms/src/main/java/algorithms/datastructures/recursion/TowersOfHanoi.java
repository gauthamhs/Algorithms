package algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowersOfHanoi {
	
	public static List<List<Integer>> towersOfHanoi(int noOfRings){
		List<List<Integer>> result = new ArrayList<>();
	    towersOfHanoiHelper(noOfRings, 0, 1, 2, result);
	    return result;
			
		}
	
	public static void towersOfHanoiHelper(int noOfRings, int fromRod, int toRod, int spareRod, List<List<Integer>> result){
		
		if(noOfRings == 0) {
			return;
		}
		towersOfHanoiHelper(noOfRings-1, fromRod, spareRod, toRod, result);
		result.add(Arrays.asList(noOfRings, fromRod, toRod));
		towersOfHanoiHelper(noOfRings-1, spareRod, toRod, fromRod, result);
	}
	
	public static void main(String[] args) {
		
		int noOfRings = 2;
		List<List<Integer>> sequence =  towersOfHanoi(noOfRings);
		System.out.println(sequence);
	}

}
