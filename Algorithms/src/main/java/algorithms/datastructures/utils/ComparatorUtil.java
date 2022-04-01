package algorithms.datastructures.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// For comparator, If we have {C,A}
// If we need to return in descending order -> {C,A}, we need to do Integer.compare(b,a) to return the highest precedence first
// If we need to return {A,C}, we need to do Integer.compare(a,b)
public class ComparatorUtil {
	
	public static void comparatorUtility(List<Character> charList){
		
		
		Comparator<Character> cmp = (a,b) -> {
			System.out.println(a);
			System.out.println(b);
			System.out.println(Integer.compare(b, a));
		return Integer.compare(b, a);	
		};
		
		Collections.sort(charList, cmp);
		
		
	}
	
	public static void main(String[] args) {
		List<Character> charList = new ArrayList<>();
		charList.add('A');
		charList.add('C');
		//charList.add('B');
		
		System.out.println(charList);
		comparatorUtility(charList);
		System.out.println(charList);
		
	}

}
