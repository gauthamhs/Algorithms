package algorithms.general;

public class FibonacciNumber {
	
	// Fibonacci Series looks something like this 0,1,1,2,3,5,8.
	// In short, A fibonacci number is a sum of previous two numbers.
	
	//Iteration
	
	public static int fibonacciNumber(int n) {
		int fibonacciNumber = 0;
		int previousTwo = 0;
		int previousOne = 1;
		
		if(n<2) {
			return n;
		}
		
		for(int i=2;i<=n;i++) {
			fibonacciNumber = previousOne + previousTwo;
			previousTwo = previousOne;
			previousOne = fibonacciNumber;	
		}
		
		return fibonacciNumber;
	}
	// Recursion 
	
	public static int fibonacciNumberRecursion(int n) {
		if(n<2) {
			return n;
		}
		
		return fibonacciNumber(n-1) + fibonacciNumber(n-2);
	}
	
	// Dynamic Programming
	// In Dynamic Programming, we have two approaches, Memoization(Top-Down Approach) and Tabulation(Bottom-Up Approach).
	// In Memoization, we solve the top problem first, and then recursively solve the sub problems. 
	// In Bottom up, We solve the sub problems first, save the results and then solve the main problem. 
	
	// Memoization
	
	public static int fibonacciNumbersDynamicMemoize(int n) {
		int[] memoize = new int[n+1];
		return fibonacciNumbersDynamicMemoize(n, memoize);
	}
	
	public static int fibonacciNumbersDynamicMemoize(int n, int[] memoize) {
		if(n<2) {
			return n;
		}
		
		if(memoize[n]!=0) {
			return memoize[n]; // If this subproblem is solved, return the solved subproblem.
		}
		
		memoize[n] = fibonacciNumbersDynamicMemoize(n-1, memoize) + fibonacciNumbersDynamicMemoize(n-2, memoize);
		return memoize[n];
	}
	
	//Bottom Up Approach
	public static int fibonacciBottomUp(int n) {
		int[] bottomUpFibonacci = new int[n+1];
		bottomUpFibonacci[0] = 0;
		bottomUpFibonacci[1] = 1;
		
		for(int i=2;i<=n;i++) {
			bottomUpFibonacci[i] = bottomUpFibonacci[i-1] + bottomUpFibonacci[i-2];
		}
		
		return bottomUpFibonacci[n];
	}
	
	
	
	public static void main(String[] args) {
		int fibonacciNumber = fibonacciNumber(9);
		int fibonacciNumberRecursion = fibonacciNumberRecursion(9);
		
		//Dynamic programming
		
		int fibonacciNumberMemoization = fibonacciNumbersDynamicMemoize(9);
		int fibonacciNumberBottomUp = fibonacciBottomUp(9);
		
		System.out.println("9th Fibonacci is: " + fibonacciNumber);
		System.out.println("Recursive 9th Fibonacci is: " + fibonacciNumberRecursion);
		System.out.println("9th Fibonacci from memoization is: " + fibonacciNumberMemoization);
		System.out.println("9th Fibonacci from BottomUp is: " + fibonacciNumberBottomUp);
	}

}
