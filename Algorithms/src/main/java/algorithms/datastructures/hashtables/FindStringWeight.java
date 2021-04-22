package algorithms.datastructures.hashtables;

public class FindStringWeight {
	
	public static String findStringWeight(String s) {
		
		char[] arr = new char[26];
		for(int i=0;i<s.length();i++) {
			 arr[s.charAt(i)-'a']++;
		}
		
		String id = String.valueOf(arr);
		
		return id;
	}
	
	public static void main(String[] args) {
		String s= "abacadaa";
		String val = findStringWeight(s);
		System.out.println(val);
		
		
	}

}
