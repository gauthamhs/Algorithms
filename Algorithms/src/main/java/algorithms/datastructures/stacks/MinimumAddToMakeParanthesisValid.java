package algorithms.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumAddToMakeParanthesisValid {

	public static int minAddToMakeValid(String sequence) {

		if (sequence == null || sequence.isEmpty()) {
			return 0;
		}

		Deque<Character> paranthesisStack = new ArrayDeque<>();

		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == '(') {
				paranthesisStack.addFirst(sequence.charAt(i));
			} else {
				if (paranthesisStack.isEmpty() || paranthesisStack.peek() != '(') {
					paranthesisStack.addFirst(sequence.charAt(i));
				} else {
					paranthesisStack.removeFirst();
				}
			}
		}

		return paranthesisStack.size();

	}
	
	public static int minAddtoMakeValidBalance(String sequence) {
		
		if(sequence==null || sequence.isEmpty()) {
			return 0;
		}
		
		int balance = 0;
		int result = 0;
		
		for(int i=0;i<sequence.length();i++) {
			balance += sequence.charAt(i)=='(' ? 1:-1;
			
			if(balance==-1) {
				++result;
				++balance;
			}
		}
		
		return result + balance;
	}

	public static void main(String[] args) {
		
		//String sequence = ")()))(()()())))";
		String sequence=")((";
		
		int minParanthesisNeeded = minAddToMakeValid(sequence);
		System.out.println(minParanthesisNeeded);
		
		int minParanthesisNeeded2 = minAddtoMakeValidBalance(sequence);
		System.out.println(minParanthesisNeeded2);

	}

}
