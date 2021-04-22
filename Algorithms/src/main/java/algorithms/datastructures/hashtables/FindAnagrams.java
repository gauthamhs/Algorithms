package algorithms.datastructures.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAnagrams {
	
	// In this algorithm, we are grouping all the words which are anagram of each other and collecting the entire collection.
	// Time Complexity: O(mnLogm);
	
	public static List<List<String>> findAnagrams(String[] strs){
		
		Map<String, List<String>> anagramMap = new HashMap<>();
		for(String word: strs) {
			String sortedString = Stream.of(word.split("")).sorted().collect(Collectors.joining());
			anagramMap.putIfAbsent(sortedString, new ArrayList<String>());
			anagramMap.get(sortedString).add(word);
		}
		
		return anagramMap.values().stream().filter((group)->group.size()>=2).collect(Collectors.toList());
		
	}
	
	// Using Hashing Weight
	public static List<List<String>> findAnagramsUsingHashing(String[] words){
		Map<String, List<String>> anagramMap = new HashMap<>();
		
		for(String word: words) {
			String id = FindStringWeight.findStringWeight(word);
			anagramMap.putIfAbsent(id, new ArrayList<>());
			anagramMap.get(id).add(word);
		}
		
		return anagramMap.values().stream().filter((group)-> group.size()>=2).collect(Collectors.toList());
		
	}
	
	public static void main(String[] args) {
		String[] words = {"debitcard","elvis","levis","lives","silent","listen","money","harbinger"};;
		List<List<String>> anagrams1 = findAnagrams(words);
		System.out.println(anagrams1);
		
		List<List<String>> anagrams2 = findAnagramsUsingHashing(words);
		System.out.println(anagrams2);
	}

}
