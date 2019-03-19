package algorithms.datastructures.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
	
	public static String minimumWindowSubstringWord(String s, String t) {
		
		if(t==null || s==null || t.isEmpty() || s.isEmpty()) {
			return "";
		}
		
		int start=-1;
		int end=-1;
		int left=0;
		int right=0;
		int n=s.length();
		int remainingCover = t.length();
		
		Map<Character, Long> charMap = t.chars().mapToObj(i->(char)(i)).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		while(right<n) {
			
			if(charMap.containsKey(s.charAt(right)) && 
			   charMap.put(s.charAt(right), charMap.get(s.charAt(right))-1) >=1 ) {
				--remainingCover;
			}
			
			while(remainingCover==0) {
				
				if((start==-1 && end==-1) || right-left<end-start) {
					start = left;
					end = right;
				}
				
				if(charMap.containsKey(s.charAt(left)) && 
						   charMap.put(s.charAt(left), charMap.get(s.charAt(left))+1) >=0 ) {
							++remainingCover;
						}

				++left;
			}
			
			++right;
		}
		
		return (start==-1 && end==-1) ? "" : s.substring(start, end+1);
		
		
	}
	
	public static List<String> minimumWindowSubstring(List<String> paragraph, Set<String> keywords) {
		
		Map<String, Long> keywordMap = keywords.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		int remainingCover = keywords.size();
		
		int start = -1;
		int end = -1;
		int left=0;
		int right=0;
		int n = paragraph.size();
		
		while(right<n) {
			if(keywordMap.containsKey(paragraph.get(right))
			&&keywordMap.put(paragraph.get(right), keywordMap.get(paragraph.get(right))-1)>=1) {
				--remainingCover;
			}
		
		while(remainingCover==0) {
			if((start == -1 && end == -1 ) || (right-left<end-start)) {
				start = left;
				end = right;
			}
		
		
		if(keywordMap.containsKey(paragraph.get(left)) && 
           keywordMap.put(paragraph.get(left), keywordMap.get(paragraph.get(left))+1)>=0) {
			++remainingCover;
		}
		++left;
		}
		++right;
		}
		
		return paragraph.subList(start, end+1);
		
	}

	
	public static void main(String[] args) {
		Set<String> keywords = new HashSet<>();
		keywords.add("banana");
		keywords.add("cat");
		
		List<String> paragraph = new ArrayList<>(Arrays.asList(new String[]{"apple","banana","apple","apple","dog","cat","apple","dog","banana","apple","cat","dog"}));
		
		System.out.println(paragraph);
		System.out.println(keywords);
		
		List<String> result = minimumWindowSubstring(paragraph, keywords);
		System.out.println(result);
		
		String word = "ADOBECODEBANC";
		String pattern = "ABC";
		
		String minimumWindowSubStringPattern = minimumWindowSubstringWord(word, pattern);
		System.out.println(minimumWindowSubStringPattern);
		
	}

}
