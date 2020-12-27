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
		precedence.put("*", (y,x) -> x*y);
		precedence.put("/", (y,x) -> x/y);
		precedence.put("+", (y,x) -> x+y);
		precedence.put("-", (y,x) -> x-y);
		
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
	
	public static int polishNotation(String pnExpression) {
		
		String delimiter = ",";
		String[] tokens = pnExpression.split(delimiter);
		
		Deque<Integer> valStack = new ArrayDeque<>();
		
		Map<String, ToIntBiFunction<Integer, Integer>> symbolMap = new HashMap<>();
		
		symbolMap.put("+", (x,y)->x+y);
		symbolMap.put("*", (x,y)->x*y);
		symbolMap.put("-", (x,y)->x-y);
		symbolMap.put("/", (x,y)->x/y);
		
		for(int i=tokens.length-1;i>=0;i--) {
			if(symbolMap.get(tokens[i])!=null) {
				valStack.addFirst(symbolMap.get(tokens[i]).applyAsInt(valStack.removeFirst(), valStack.removeFirst()));
			} else {
				valStack.addFirst(Integer.parseInt(tokens[i]));
			}
		}
		
		return valStack.removeFirst();
	}
	
	public static void main(String[] args) {
		String rpnexpression = "2,3,*,5,4,*,+,9,-";
		//String rpnexpression =  "3,4,+,2,*,1,+";
		int rpn = reversePolishNotation(rpnexpression);
		System.out.println(rpn);
		
		String pnExpression = "-,+,*,2,3,*,5,4,9";
		int pn = polishNotation(pnExpression);
		System.out.println(pn);
	}
	

}
