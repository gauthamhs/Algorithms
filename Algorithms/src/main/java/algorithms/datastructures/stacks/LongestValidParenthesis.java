package algorithms.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParenthesis {
	
	public static int longestValidParenthesis(String s) {
		
		Deque<Integer> parenthesisStack = new ArrayDeque<>();
		int longestParenthesis = 0;
		parenthesisStack.addFirst(-1);
		for(int i=0;i<s.length();i++) {
			if(parenthesisStack.peek()!=-1 && s.charAt(i)==')' && s.charAt(parenthesisStack.peek())=='(') {
				parenthesisStack.remove();
				longestParenthesis = Math.max(longestParenthesis, i-parenthesisStack.peek());
			}else {
				parenthesisStack.addFirst(i);
			}
		}
		
		return longestParenthesis;
		
	}
	
	public static void main(String[] args) {
		//String s = "(())()()())()()((()";
		String s ="()";
		int longestValidPalindrome = longestValidParenthesis(s);
		System.out.println(longestValidPalindrome);
	}

}
