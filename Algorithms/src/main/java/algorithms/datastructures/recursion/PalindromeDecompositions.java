package algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecompositions {
	
	public static List<List<String>> palindromicDecompositions(String s){
		List<List<String>> result = new ArrayList<>();
		decomposePalindrome(0, s, result, new ArrayList<>());
		return result;
	}
	
	public static void decomposePalindrome(int currentIndex, String s, List<List<String>> result, List<String> stringList) {
		if(currentIndex == s.length()) {
			result.add(new ArrayList<>(stringList));
			return;
		}
		
		for(int i=currentIndex;i<s.length();i++) {
			String prefix = s.substring(currentIndex, i+1);
			if(isValidPalindrome(prefix)) {
				stringList.add(prefix);
				decomposePalindrome(i+1, s, result, stringList);
				stringList.remove(stringList.size()-1);
			}
		}
	}
	
	public static boolean isValidPalindrome(String prefix) {
		for(int i=0,j=prefix.length()-1;i<j;++i,--j) {
			if(prefix.charAt(i)!=prefix.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> decomposedPalindrome = palindromicDecompositions(s);
		System.out.println(decomposedPalindrome);
	}

}
