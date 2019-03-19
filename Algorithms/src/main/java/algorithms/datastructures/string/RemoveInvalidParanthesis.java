package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParanthesis {
	
    public static List<String> removeInvalidParentheses(String s) {
    	
    	if(s==null || s.length()==0) {
    		return Collections.emptyList();
    	}
    	
    	List<String> result = new ArrayList<>();
    	
    	Set<String> visited = new HashSet<>();
    	Queue<String> stringQueue = new LinkedList<>();
    	
    	visited.add(s);
    	stringQueue.add(s);
    	
    	boolean found = false;
    	
    	while(!stringQueue.isEmpty()) {
    		
    		s = stringQueue.poll();
    		
    		if(isValidParenthesis(s)) {
    			found = true;
    			result.add(s);
    		}
    		
    		if(found) {
    			continue; // If we have found a valid parenthesis pattern,
                          // we dont need to process the other patterns since other BFS would
		                  // return a smaller length;
    		}
    		
    		for(int i=0;i<s.length();i++) {
    			if(s.charAt(i)!='(' && s.charAt(i)!=')') {
    				continue;
    			}
    			
    			StringBuilder sb = new StringBuilder();
    			sb.append(s.substring(0, i)).append(s.substring(i+1));
    			String t = sb.toString();
    			
    			if(!visited.contains(t)){
    				stringQueue.add(t);
    				visited.add(t);
    			}
    		}
    		
    	}
    	
    	return result;
    	
      }
    
    public static boolean isValidParenthesis(String s) {
    	
    	int count = 0;
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		
    		if(c=='(') {
    			++count;
    		}
    		
    		else if(c==')') {
    			--count;
    			
        		if(count<0) {
        			return false;
        		}
    		}
    		
    	}
 	
    	return count==0;
    }
  
	
	public static void main(String[] args) {
		String s = "(a)())()";
		List<String> validStrings = removeInvalidParentheses(s);
		System.out.println(validStrings);
		
		
	}

}
