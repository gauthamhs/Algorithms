package algorithms.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class WellFormedParenthesis {
	
	public static boolean isWellFormed(String expression) {
		
		Deque<Character> symbolList = new ArrayDeque<>();
		Map<Character, Character> SYMBOLS = new HashMap<>();
		
		SYMBOLS.put('(', ')');
		SYMBOLS.put('[', ']');
		SYMBOLS.put('{', '}');
		
		for(int i =0;i<expression.length();i++) {
			if(SYMBOLS.get(expression.charAt(i))!=null) {
				symbolList.addFirst(expression.charAt(i));
			} else if(symbolList.isEmpty() || expression.charAt(i) != SYMBOLS.get(symbolList.removeFirst())) {
				return false;
			}
		}

		return symbolList.isEmpty();
	}
	
	public static void main(String[] args) {
		String expression = "({})";
		boolean isWellFormed = isWellFormed(expression);
		System.out.println(isWellFormed);
	}

}
