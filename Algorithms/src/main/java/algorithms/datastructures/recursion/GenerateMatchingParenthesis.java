package algorithms.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateMatchingParenthesis {
	
	public static List<String> matchedParenthesis(int n){
		List<String> result = new ArrayList<>();
		matchedParenthesisHelper(n,n,"", result);
		return result;
	}
	
	
	public static void matchedParenthesisHelper(int leftParenthesisRequired, int rightParenthesisRequired, String suffix, List<String> result) {
		if(rightParenthesisRequired == 0) {
			result.add(new String(suffix));
		}
		
		if(leftParenthesisRequired > 0) {
			matchedParenthesisHelper(leftParenthesisRequired-1, rightParenthesisRequired, suffix + "(", result);
		}
		
		if(rightParenthesisRequired>leftParenthesisRequired) {
			matchedParenthesisHelper(leftParenthesisRequired, rightParenthesisRequired-1, suffix + ")", result);
		}
	}
	
	public static void main(String[] args) {
		List<String> generatedParenthesis = matchedParenthesis(2);
		System.out.println(generatedParenthesis);
	}

}
