package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.List;

public class Leader {
	
	
/*	For this method, We return the first leader that we find in the array,
	Leader is the element that is greater than all the elements succeeding it.
	In that context, the right most element is always the leader because it 
	does not have any elements succeeding it.*/
	
	/*Complexity: O(n^2)*/
	public static int findFirstLeader(List<Integer> integerArray) {
		
		int leader = 0;
		int lastIndex = integerArray.size()-1;
		
		for(int i=0;i<integerArray.size();i++) {
			for(int j=i+1;j<integerArray.size();j++) {
				if(integerArray.get(j)>integerArray.get(i)) {
					break;
				}
				if(j==lastIndex) {
					return integerArray.get(i);
				}
			}
		}
		leader=integerArray.get(lastIndex);
		return leader;
		
	}
	
	/*Complexity: O(n^2)*/
	public static List<Integer> findLeaders(List<Integer> integerArray) {
		List<Integer> leaders = new ArrayList<>();
		int lastIndex = integerArray.size()-1;
		
		for(int i=0;i<integerArray.size();i++) {
			for(int j=i+1;j<integerArray.size();j++) {
				if(integerArray.get(j)>integerArray.get(i)) {
					break;
				}
				if(j==lastIndex) {
					leaders.add(integerArray.get(i));
				}
			}
		}
		leaders.add(integerArray.get(lastIndex));
		return leaders;
	}
	
	public static List<Integer> findLeadersFromMax(List<Integer> integerArray) {
		List<Integer> leaders = new ArrayList<>();
		int lastIndex = integerArray.size() - 1;
		int maxValue = integerArray.get(lastIndex);
		
		leaders.add(maxValue);
		for(int i=lastIndex-1;i>=0;i--) {
			if(integerArray.get(i)>maxValue) {
				leaders.add(integerArray.get(i));
				maxValue = integerArray.get(i);
			}
		}
		return leaders;
	}
	
	public static void main(String[] args) {
		List<Integer> integerArray = new ArrayList<>();
		integerArray.add(15);
		integerArray.add(16);
		integerArray.add(3);
		integerArray.add(2);
		integerArray.add(6);
		integerArray.add(1);
		integerArray.add(4);
		
		System.out.println(integerArray);
		int findFirstLeader = findFirstLeader(integerArray);
		System.out.println(findFirstLeader);
		List<Integer> leaders = findLeaders(integerArray);
		System.out.println(leaders);
		List<Integer> leaders2 = findLeadersFromMax(integerArray);
		System.out.println(leaders2);
		
		
		
	}

}
