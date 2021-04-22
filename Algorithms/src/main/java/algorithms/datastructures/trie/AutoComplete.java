package algorithms.datastructures.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode{
	
	Character label;
	Boolean isWord;
	Map<Character, TrieNode> children;
	
	public TrieNode(Character label) {
		this.label = label;
		this.isWord = false;
		this.children = new HashMap<>();
	}
	
}

class Trie { 
	
	TrieNode root;
	
	public Trie() {
		root = new TrieNode(' ');
	}
	
	public void buildTrie(List<String> words) {
		
		if(words==null || words.isEmpty()) {
			return;
		}
		
		for(String word : words) {
			TrieNode currentNode = root;
			
			for(char c : word.toCharArray()) {
				currentNode.children.putIfAbsent(c, new TrieNode(c));
				currentNode = currentNode.children.get(c);
			}
			currentNode.isWord = true;
		}
		
	}
	
	public Boolean isWord(String word) {
		TrieNode currentNode = root;
		for(char c: word.toCharArray()) {
			if(!currentNode.children.containsKey(c)) {
				return false;
			}
			currentNode = currentNode.children.get(c);
		}
		
		return currentNode.isWord;
	}
	
	public Boolean isPrefix(String word) {
		TrieNode currentNode = root;
		for(char c: word.toCharArray()) {
			if(!currentNode.children.containsKey(c)) {
				return false;
			}
			currentNode = currentNode.children.get(c);
		}
		
		return true;
	}
	
	public List<String> autocompletedWords(String word){
		TrieNode currentNode = root;
		for(char c: word.toCharArray()) {
			if(!currentNode.children.containsKey(c)) {
				return Collections.emptyList();
			}
			currentNode = currentNode.children.get(c);
		}
		List<String> words = new ArrayList<>();
		dfs(currentNode, word, words);
		return words;
		
	}
	
	public void dfs(TrieNode currentNode, String word, List<String> words) {
		if(currentNode.isWord) {
			words.add(word);
		}
		
		for( Character ch : currentNode.children.keySet()) {
			dfs(currentNode.children.get(ch), word + ch, words);
		}
		
	}
	
	
	
}

public class AutoComplete {
	
	
	public static void main(String[] args) {
		List<String> words = Arrays.asList("dog","dark","cat","door","dodge", "doge");
		Trie trie = new Trie();
		trie.buildTrie(words);
		System.out.println(trie.isPrefix("doo"));
		System.out.println(trie.isWord("doo"));
		System.out.println(trie.autocompletedWords("do"));
	
	}

}
