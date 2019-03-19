package algorithms.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithDistinctEntries {
	
	public static int longestSubarrayWithDistinctEntries(char[] charList) {
		
		Map<Character, Integer> charMap = new HashMap<>();
		
		int i=0;
		int j=0;
		int maxLength = 1;
		
		while(j<charList.length) {
			if(charMap.containsKey(charList[j])) {
				int iIdx = charMap.get(charList[i]);
				charMap.remove(charList[i]);
				maxLength = Math.max(maxLength, j-i);
				i = iIdx+1;
				
			} else {
				charMap.put(charList[j], j);
				j++;
			}
		}
		
		return maxLength;
		
	}
	
	public static void main(String[] args) {
		char[] charList = {'f','s','f','e','t','w','e','n','w','e'};
		int length = longestSubarrayWithDistinctEntries(charList);
		System.out.println(length);
		
		
		}
	}

