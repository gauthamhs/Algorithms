package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumberSieve {

	public static List<Integer> generatePrimeNumbers(int n){
		
		List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n+1, true));
		List<Integer> primeNumberList = new ArrayList<>();
		
		isPrime.set(0, false);
		isPrime.set(1, false);
		
		for(int i=2;i<=n;i++) {
			if(isPrime.get(i)) {
				primeNumberList.add(i);
			
			for(int k = i; k<=n;k+=i) {
				isPrime.set(k, false);
			}
			}
		}
		
		return primeNumberList;
	}
	public static void main(String[] args) {
		List<Integer> primeNumberList = generatePrimeNumbers(100);
		System.out.println(printArray(primeNumberList));
	}
	
	public static String printArray(List<Integer> sortedList){

		StringBuilder sb = new StringBuilder("");
		for(Integer i: sortedList){
		sb.append(i +", ");
		}
		return sb.toString();

		}
}
