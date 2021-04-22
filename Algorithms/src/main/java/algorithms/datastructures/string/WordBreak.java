package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public static boolean isWordBreakPossible(String str, List<String> dictionary) {
		
		if(str==null || str.isEmpty()) {
			return false;
		}
		
		Set<String> dict = new HashSet<>();
		dict.addAll(dictionary);
		
		boolean[] isWordPossible = new boolean[str.length()];
		
		for(int i=0;i<str.length();i++) {
			
			if(dict.contains(str.substring(0, i+1))) {
				isWordPossible[i] = true;
			}
			
			if(!isWordPossible[i]) {
			for(int j=0;j<i;j++) {
				if(isWordPossible[j] && dict.contains(str.substring(j+1,i+1))) {
					isWordPossible[i] = true;
					break;
				}
			}
			}
		}
		
		return isWordPossible[str.length()-1];
	}
	
	public static void main(String[] args) {
		List<String> dictionary = new ArrayList<>();
		dictionary.add("I");
		dictionary.add("LIKE");
		dictionary.add("TO");
		dictionary.add("PLAY");
		dictionary.add("FOOTBALL");
		
		String str = "PLAYILIKETOFOOTBALL";
		
		boolean isWordPossible = isWordBreakPossible(str, dictionary);
		System.out.println(isWordPossible);
		
		
	}

}
