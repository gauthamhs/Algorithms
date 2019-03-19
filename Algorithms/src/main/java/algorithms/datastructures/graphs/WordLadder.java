package algorithms.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class StringFeature{
	String word;
	int distance;
	
	StringFeature(String word, int distance){
		this.word = word;
		this.distance = distance;
	}
}

public class WordLadder {
	
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
    	Set<String> visitedString = new HashSet<>(wordList);
    	Deque<StringFeature> stringQueue = new ArrayDeque<>();
    	visitedString.remove(beginWord);
    	stringQueue.add(new StringFeature(beginWord, 0));
    	
    	while(!stringQueue.isEmpty()) {
    		StringFeature currentStringFeature = stringQueue.pop();
    		
    		if(currentStringFeature.word.equals(endWord)) {
    			return currentStringFeature.distance;
    		}
    		
    		String currentString = currentStringFeature.word;
    		
    		for(int i=0;i<currentString.length();i++) {
    			String startString = (i==0) ? "": currentString.substring(0, i);
    			String endString = (i+1<currentString.length()) ? currentString.substring(i+1) : "";
    			
    			for(int j=0;j<26;j++) {
    				String totalString = startString + (char)('a' + j) + endString;
    				if(visitedString.contains(totalString)) {
    					visitedString.remove(totalString);
    					stringQueue.add(new StringFeature(totalString, currentStringFeature.distance + 1));
    				}
    				
    			}
    		}
    		
    		
    	}
    	
    	return 0;
    	
    	
    }
	
	public static void main(String[] args) {
		String beginWord = "bat"; 
		String endWord = "cop";
		
		List<String> wordList = Arrays.asList(new String[]{"bit","cot","met","cit","cop","lot"});
		
		int transformLength =  ladderLength(beginWord, endWord, wordList);
	}

}
