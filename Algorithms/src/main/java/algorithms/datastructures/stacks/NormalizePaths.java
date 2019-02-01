package algorithms.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class NormalizePaths {
	
/*	In this method, We normalize Unix Directory Path, Here is the logic:
		
	If there is a "/" at the start, we add that to the stack.
	If there is a ".." followed by /, we throw an error because, we cannot go up root.
	If there is no . or .., then it must be a word.
	
	We use a stack, 
	
	Input: "../abc//..//bca//..//def//.//pbka"
	Stack: {pbka,def,..}
	Output: ../def/pbka
	*/
	public static String normalizePath(String path) {
		
		Deque<String> pathValues= new ArrayDeque<>();
		if(path=="") {
			throw new IllegalArgumentException("Path is empty");
		}
		
		if(path.startsWith("/")) {
			pathValues.addFirst("/");
		}
		
		String[] tokens = path.split("/");
		
		for(String token: tokens) {
			if(token.equals("..")) {
				if(pathValues.isEmpty() || pathValues.peekFirst().equals("..")){
					pathValues.addFirst(token);
				} else { 
					if(pathValues.peekFirst().equals("/")) {
						throw new IllegalArgumentException("Path error trying to go up root: " + path);
					}
					pathValues.removeFirst();
				}
			} else if(!token.equals(".") && !token.isEmpty()) {
				pathValues.addFirst(token);
				
			}
		}
		StringBuilder sb = new StringBuilder();
		
		if(!pathValues.isEmpty()) {
		
		Iterator<String> iterator = pathValues.descendingIterator();
		String next = iterator.next();
		sb.append(next);
		
		while(iterator.hasNext()) {
			if(!next.equals("/")) {
				sb.append("/");
			}
			
			next = iterator.next();
			sb.append(next);
			
		}
		
		}
		return sb.toString();
		
		
	}
	
	public static void main(String[] args) {
		
		String path = "../abc//..//bca//..//def//.//pbka";
		String pathVal = normalizePath(path);
		System.out.println(pathVal);
		
	}

}
