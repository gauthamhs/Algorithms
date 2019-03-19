package algorithms.datastructures.hashtables;

import java.util.Arrays;

public class FindStringWeight {
	
	public static Integer findStringWeight(String s) {
		
		char[] arr = new char[26];
		for(int i=0;i<s.length();i++) {
			 arr[s.charAt(i)-'a']++;
		}
		
		int id = Arrays.hashCode(arr);
		
		return id;
	}
	
	public static void main(String[] args) {
		String s= "abacadaa";
		Integer val = findStringWeight(s);
		System.out.println(val);
		
		
	}

}
