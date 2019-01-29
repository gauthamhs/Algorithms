package algorithms.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class ReversePolishNotation {
	
	public static int reversePolishNotation(String expression) {
		
		final String DELIMITER = ",";
		String[] tokens = expression.split(DELIMITER);
		Map<String, ToIntBiFunction<Integer, Integer>> precedence = new HashMap<>();
		Deque<Integer> intermediateResult = new ArrayDeque<>();
		precedence.put("*", (y,x) -> y*x);
		precedence.put("/", (y,x) -> y/x);
		precedence.put("+", (y,x) -> y+x);
		precedence.put("-", (y,x) -> y-x);
		
		for(String token : tokens) {
			if(precedence.get(token)!=null) {
				intermediateResult.addFirst
				(precedence.get(token).applyAsInt(intermediateResult.removeFirst(), intermediateResult.removeFirst()));
			} else { 
				intermediateResult.addFirst(Integer.parseInt(token));
			}
		}
		
		
		
		return intermediateResult.removeFirst();
		
		
		
	}
	
	public static void main(String[] args) {
		String expression = "3,4,+,2,*,1,+";
		int rpn = reversePolishNotation(expression);
		System.out.println(rpn);
	}

}
