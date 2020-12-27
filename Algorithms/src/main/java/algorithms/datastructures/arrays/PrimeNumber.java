package algorithms.datastructures.arrays;

public class PrimeNumber {

	// All numbers greater than 1 are prime if it is only divisible
	// by one and itself. Check if a number is a prime number or not. A number is prime if 
	
	// Least efficient method. In this method, we are checking all numbers from from 2 to n 
	// to see that if its a prime number.
	
	//Time Complexity: O(sqrt(n))
	
	public static boolean isPrime(int n) {
		
		if(n==0 || n==1) {
			return false;
		}
		
		for(int i = 2;i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}
	// Since we know that if a number divisible by 2 is not prime, the numbers divisible by multiple of 2 
	// will also not be prime. Therefore we can reduce the no. of iterations.

	public static boolean isPrimeEfficient(int n) {
		
		if(n==0 || n==1) {
			return false;
		}
		
		for(int i = 2; 2*i<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	// In this method, we only iterate through square root of n
	public static boolean isPrimeMostEfficient(int n) {
		
		if(n==0 || n==1 || (n!=2 && n%2==0)) {
			return false;
		}
		
		
		// Just check for odd values
		for(int i = 3; (i*i)<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int number = 10;
		boolean isPrimeNumber = isPrime(number);
		//boolean isPrimeNumber = isPrimeMostEfficient(number);
		System.out.println(isPrimeNumber);
		
	}
}
