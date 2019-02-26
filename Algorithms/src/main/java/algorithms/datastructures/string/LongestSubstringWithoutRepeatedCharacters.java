package algorithms.datastructures.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters {
	
	public static int lengthOfLongestSubstring(String s) {
		
		 if(s==null||s.length()==0){
		        return 0;
		    }
		 
		 Set<Character> charSet = new HashSet<>();
		 
		 int i=0;
		 int j=0;
		 int maxLength = 0;
		 
		 while(j<s.length()) {
			 if(!charSet.contains(s.charAt(j))) {
				 charSet.add(s.charAt(j));
				 j++;
				 maxLength = Math.max(maxLength, j-i);
			 }else {
				 charSet.remove(s.charAt(i));
				 i++;
			 }
		 }
	
		    return maxLength;
	}
	
	public static void main(String[] args) {
		String s = "dvdfe";
		int length = lengthOfLongestSubstring(s);
		System.out.println(length);
	}

}
