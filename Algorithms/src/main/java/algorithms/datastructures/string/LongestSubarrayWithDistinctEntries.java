package algorithms.datastructures.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubarrayWithDistinctEntries {
	
	public static int longestSubarrayWithDistinctEntries(char[] charList) {
		
		if(charList.length==0) {
			return 0;
		}
		
		int lw=0;
		int rw=0;
		int maxLength = 1;
		Set<Character> charSet = new HashSet<>();
	
		while(rw<charList.length) {
			if(!charSet.contains(charList[rw])) {
				charSet.add(charList[rw]);
				++rw;
				maxLength = Math.max(maxLength, rw-lw);
			}else {
				charSet.remove(charList[lw]);
				++lw;
			}
		}
		
		return maxLength;
		
	}
	
	public static void main(String[] args) {
		char[] charList = {'f','s','f','t','e','t','w','e','n','w','e'};
		int length = longestSubarrayWithDistinctEntries(charList);
		System.out.println(length);
		
		
		}
	}

