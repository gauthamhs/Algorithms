package algorithms.datastructures.string;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {
	
	
	// Complexity: O(n) Time and O(1) Space Complexity.
	// In this method, We are reversing words in a sentence.
	public static String reverseWords(String sentence) {
	
		StringBuilder reversedString = new StringBuilder(sentence).reverse();
		List<Character> sentenceToChar = reversedString.chars().mapToObj(i->(char)i).collect(Collectors.toList());
		
		int size = sentenceToChar.size();
		
		int start = 0;
		int finish = 0;
		
		while(start<size) {
			while(start<finish || start<size && sentenceToChar.get(start) == ' ') { // Skip spaces
				start++;
			}
			
			while(finish<start || finish<size && sentenceToChar.get(finish)!=' ') { //Skip non-spaces
				
				finish++;
			}
			
			int swapStart = start;
			int swapFinish = finish-1;

			while(swapStart<swapFinish) {
				
				Collections.swap(sentenceToChar, swapStart++, swapFinish--);	
			}
		}
		
		String reconstructedSentence = sentenceToChar.stream().map(i->i.toString()).collect(Collectors.joining());
		return reconstructedSentence;
	}
	
	//Using regex and tokenizer
	public static String reverseWordsSplit(String sentence) {
		String[] tokenizer = sentence.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i = tokenizer.length-1;i>=0;i--) {
			sb.append(tokenizer[i]);
			if(i!=0) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
    public static String reverseWordsWithSpaces(String s) {
        
        if(s==null || s.isEmpty()){
            return null;
        }
        
        String[] tokens = s.split("\\s+");
        Deque<String> wordStack = new ArrayDeque<>();
        
        for(String token: tokens){
            wordStack.addFirst(token);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!wordStack.isEmpty()){
            sb.append(wordStack.removeFirst()).append(" ");
        }
        
        return sb.toString().trim();
        
    }
	
	
	public static void main(String[] args) {
		String sentence = "Rams are Empty";
		String reversedString = reverseWords(sentence);
		System.out.println(reversedString);
		String reversedString2 = reverseWordsSplit(sentence);
		System.out.println(reversedString2);
		
		String wordWithSpaces = "a good   example";
		String reversedWord = reverseWordsWithSpaces(wordWithSpaces);
		System.out.println(reversedWord);
	}
}
