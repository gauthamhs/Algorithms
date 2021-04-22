package algorithms.datastructures.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithUtmost2Characters {
	
	/* In this method, we are trying to determine the longest substring which has 
	 *  at most 2 distinct characters.
	 * 
	 * This could be done in O(n) time complexity and O(1) space.*/
	
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
    	
    	int n = s.length();
    	
    	if(n<3) {
    		return n;
    	}
    	
    	int leftWindow = 0;
    	int rightWindow = 0;
    	
    	int longestSubString = 2;
    	
    	Map<Character, Integer> charMap = new HashMap<>();
    	
    	
    	
    	while(rightWindow<n) {
    		
    		charMap.put(s.charAt(rightWindow), rightWindow);
    		++rightWindow;
    		
    		if(charMap.size()>2) {
    			int deleteIndex = Collections.min(charMap.values());
    			charMap.remove(s.charAt(deleteIndex));
    			leftWindow = deleteIndex + 1;
    		}else {
        		longestSubString = Math.max(longestSubString, rightWindow-leftWindow);
    		}
    		
    		
    	}
    	
        return longestSubString;
    }
	
	public static void main(String[] args) {
		
		String sequence = "freeeeeereeeeends";
		int longestSubStringLength = lengthOfLongestSubstringTwoDistinct(sequence);
		System.out.println(longestSubStringLength);
		
	}

}
