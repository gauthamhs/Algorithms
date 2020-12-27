package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DecomposeWords {
	
	public static List<String> decomposedWords(Set<String> dictionary, String sentence){
		
		int[] lengths = new int[sentence.length()];
		Arrays.fill(lengths,-1);
		
		for(int i=0;i<sentence.length();i++) {
			
			if(dictionary.contains(sentence.substring(0, i+1))) {
				lengths[i] = i+1;
			}
			
			if(lengths[i]==-1) {
				for(int j=0;j<i;j++) {
					if(lengths[j]!=-1 && dictionary.contains(sentence.substring(j+1,i+1))) {
						lengths[i] = i-j;
						break;
					}
				}
			}
		}
		
		List<String> decomposedWords = new ArrayList<>();
		if(lengths[lengths.length-1]!=-1) {
		int decompositionIndex = sentence.length()-1;
		while(decompositionIndex>=0) {
			decomposedWords.add(sentence.substring(decompositionIndex+1-lengths[decompositionIndex],decompositionIndex+1));
			decompositionIndex -= lengths[decompositionIndex];
		}
		Collections.reverse(decomposedWords);
		}	
		
		return decomposedWords;
		
	}
	
	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<>();
		dictionary.add("a");
		dictionary.add("man");
		dictionary.add("plan");
		dictionary.add("canal");
		dictionary.add("am");
		
		String sentence = "amanaplanacanal";
		System.out.println(sentence.length());
		List<String> decomposedWords =  decomposedWords(dictionary, sentence);
		System.out.println(decomposedWords);
	}

}
