package algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CountNoOfPalindromicSubStrings {
	
	public static boolean isPalindrome(String sequence, int startIndex, int endIndex) {
		while(startIndex<endIndex) {
			if(sequence.charAt(startIndex)!=sequence.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}
		
		return true;
	}

	
	public static int countNoOfPalindromicSubStringNaive(String sequence) {
		
		int count = sequence.length();
		
		for(int startIndex=1;startIndex<sequence.length();startIndex++) {
			for(int endIndex=0;endIndex<startIndex;endIndex++) {
				if(isPalindrome(sequence, startIndex, endIndex)) {
					count++;
				}	
			}
		}
		
		return count;
	}
	
	public static List<List<String>> countPalindromeDecompositions(String sequence) {
		List<List<String>> result = new ArrayList<>();
		countPalindromeDecompositionsHelper(sequence,result, new ArrayList<String>(),0);
		return result;
	}
	
	public static void countPalindromeDecompositionsHelper(String sequence, List<List<String>> result, List<String> count, Integer currentIndex) {
		if(currentIndex==sequence.length()) {
			result.add(new ArrayList<>(count));
			return;
		}
		
		for(int i=currentIndex;i<sequence.length();i++) {
			String prefix = sequence.substring(currentIndex,i+1);
			if(isPalindrome(prefix,0,prefix.length()-1)){
				count.add(prefix);
				countPalindromeDecompositionsHelper(sequence,result, count, i+1);
				count.remove(count.size()-1);
			}
		}
		
	}
	
	public static int countNoOfPalindromicSubStringsBottomUp(String sequence) {
		
		int count = 0;
		
		boolean[][] bottomUpMatrix = new boolean[sequence.length()][sequence.length()];
		for(int k=0;k<sequence.length();k++) {
			bottomUpMatrix[k][k] = true;
			count++;
		}
		
		for(int i=sequence.length()-1;i>=0;i--) {
			for(int j=i+1;j<sequence.length();j++) {
				if(sequence.charAt(i)==sequence.charAt(j)) {
					if(j-i==1 || bottomUpMatrix[i+1][j-1]) {
						bottomUpMatrix[i][j] = true;
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		String sequence = "aab";
		int count = countNoOfPalindromicSubStringsBottomUp(sequence);
		System.out.println(count);
		
		int count2 = countNoOfPalindromicSubStringNaive(sequence);
		System.out.println(count2);
		
		String sequence2 = "aab";
		
		List<List<String>> str = countPalindromeDecompositions(sequence2);
		System.out.println(str);
	}

}
