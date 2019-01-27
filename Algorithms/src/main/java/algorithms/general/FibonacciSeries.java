package algorithms.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FibonacciSeries {
	
	public static List<Integer> fibonacciSeries(int n){
		List<Integer> fibonacciSeries = new ArrayList<>();
		int fibonacciNumber = 1;
		int previousOne = 1;
		int previousTwo = 0;
		
		if(n==0) {
			return Collections.emptyList();
		}
		
		fibonacciSeries.add(fibonacciNumber);
		
		for(int i=2;i<=n;i++) {
			fibonacciNumber = previousOne + previousTwo;
			fibonacciSeries.add(fibonacciNumber);
			previousTwo = previousOne;
			previousOne = fibonacciNumber;
		}
		
		return fibonacciSeries;
		
	}
	
	public static void main(String[] args) {
		int n = 9;
		List<Integer> fibonacciSeries = fibonacciSeries(n);
		System.out.println(fibonacciSeries);
		
	}

}
