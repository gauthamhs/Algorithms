package algorithms.datastructures.arrays.extras;

import java.util.HashSet;
import java.util.Set;

public class CommonElementsTwoArrays {
	
	public static Set<Integer> commonElements(int[] list1, int[] list2){
		Set<Integer> distinctSet = new HashSet<>();
		int list1Length = list1.length;
		int list2Length = list2.length;
		int p = 0;
		int q = 0;
		
		while(p<list1Length && q<list2Length) {
			
			if(list1[p]==list2[q]) {
				distinctSet.add(list1[p]);
				++p;
				++q;
			} else if(list1[p]<list2[q]) {
				++p;
			} else {
				++q;
			}
		}
		return distinctSet;
	}
	
	public static void main(String[] args) {
		int[] list1 = {1,4,6,8,11,13,18};
		int[] list2 = {5,6,7,8,14,18,20};
		
		Set<Integer> commonElements = commonElements(list1, list2);
		System.out.println(commonElements);
		
	}

}
