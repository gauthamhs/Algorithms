package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// In wordbreak1, we were trying to identify if its possible to break a word
// based on the dictionary provided. 

// In wordbreak2, we would provide list of all possible wordbreaks for a given
// string.

//Time complexity: O(2^n*n)
// Space complexity: O(n) to hold the cache.



public class WordBreak2 {
	
	static Map<String, List<String>> cache = new HashMap<>();
	
	static List<String> wordBreak2(String s, List<String> dict){
		
		if(cache.containsKey(s)) {
			return cache.get(s);
		}
		
		Set<String> dictionary = new HashSet<>(dict);
		
		List<String> result = new ArrayList<>();
		if(dictionary.contains(s)) {
			result.add(s);
		}
		
		for(int i=1;i<s.length();i++) {
			String prefix = s.substring(0,i);
			if(dictionary.contains(prefix)) {
				List<String> suffixList = wordBreak2(s.substring(i), dict);
				for(String suffix: suffixList) {
					result.add(prefix + " " + suffix);
				}
			}
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> dict = List.of("cat","cats","and","dog","sand");
		List<String> result = wordBreak2(s, dict);
		System.out.println(result);
		
		List<String> animalList = List.of("cat","cats","catsdogcats",
				"dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat");
		
		List<List<String>> filt = new ArrayList<>();

		for(String animal: animalList) {
			filt.add(wordBreak2(animal, animalList));
		}
		
		// WordBreak3
		// For wordBreak3. We can calculate WordBreak2 for all words and then filter out
		// words who have size greater than 1 because these words can be broken down.
		// For the filtered words, we get the first word.
		
		// Second approach is to sort these words, and then see if word break is possible
		// and keep adding the prewords iteratively.
		
		 List<String> finalResult = filt.stream()
				 .filter(a -> a.size()>1)
				 .map(b -> b.get(0))
				 .collect(Collectors.toList());
		 System.out.println(finalResult);
	}

}
