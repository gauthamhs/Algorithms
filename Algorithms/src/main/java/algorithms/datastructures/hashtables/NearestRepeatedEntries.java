package algorithms.datastructures.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntries {
	
	public static int findNearestRepeatedEntries(List<String> words) {
		
		int nearestRepeatedWord = Integer.MAX_VALUE;
		
		Map<String, Integer> wordMap = new HashMap<>();
		
		for(int i=0;i<words.size();i++) {
			
			if(wordMap.containsKey(words.get(i))) {
				nearestRepeatedWord = Math.min(nearestRepeatedWord, i-wordMap.get(words.get(i)));
			}
			
			wordMap.put(words.get(i), i);
			
		}
		
		return nearestRepeatedWord==Integer.MAX_VALUE ? -1 : nearestRepeatedWord;
		
	}
	
	public static void main(String[] args) {
		List<String> words = Arrays.asList("All","Work","and","no","play","makes","for","no","work","no","fun","and","no","results");
		int nearestRepeatedWordLength =findNearestRepeatedEntries(words);
		System.out.println(nearestRepeatedWordLength);
		
	}

	
}
