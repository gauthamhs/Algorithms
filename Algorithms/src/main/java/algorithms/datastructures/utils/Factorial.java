package algorithms.datastructures.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Factorial {
	
	public static int factorialRecursive(int n) {
		if(n==1 || n==0) {
			return n;
		}
		
		return n*factorialRecursive(n-1);
	}
	
	public static int factorialIterative(int n) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.addFirst(n);
		int factorial = 1;
		while(!stack.isEmpty()) {
			Integer value = stack.pop();
			if(value==1 || value == 0) {
				return factorial;
			}
			
			factorial*=value;
			stack.addFirst(value-1);
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		System.out.println(factorialRecursive(5));
		System.out.println(factorialIterative(5));
		
	}

}
