package algorithms.general;

public class FibonacciNumber {
	
	// Fibonacci Series looks something like this 0,1,1,2,3,5,8.
	// In short, A fibonacci number is a sum of previous two numbers.
	
	public static int fibonacciNumber(int n) {
		int fibonacciNumber = 0;
		int previousTwo = 0;
		int previousOne = 1;
		
		if(n==1) {
			return 1;
		}
		
		for(int i=2;i<=n;i++) {
			fibonacciNumber = previousOne + previousTwo;
			previousTwo = previousOne;
			previousOne = fibonacciNumber;	
		}
		
		return fibonacciNumber;
	}
	
	public static int fibonacciNumberRecursion(int n) {
		if(n<=1) {
			return n;
		}else {
			return fibonacciNumber(n-1) + fibonacciNumber(n-2);
		}
	}
	
	public static void main(String[] args) {
		int fibonacciNumber = fibonacciNumber(9);
		int fibonacciNumberRecursion = fibonacciNumberRecursion(9);
		System.out.println(fibonacciNumber);
		System.out.println(fibonacciNumberRecursion);
	}

}
