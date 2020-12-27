package algorithms.datastructures.utils;

public class MathOperations {
	
	/*
	 * Getting a product, lets say 2*3 is nothing but 2+2+2 or 3+3. So we need to
	 * iterate over one and add the other. Time Complexity: O(a) or O(b)
	 */
	
	public static int product(int a, int b) {
		int sum=0;
		for(int i=0;i<a;i++) {
			sum+=b;
		}
		return sum;
	}
	
	/*
	 * Power of something is nothing but multiplying a times over b. For example 2*3
	 * = 2*2*2 Time Complexity: O(n) since we recurse through n
	 */
	public static int power(int a, int b) {
		if(b<=0) {
			return 1;
		}
		
		return a*power(a, b-1);
	}
	
	/*
	 * For modulo, both 1%4 and 5%4 should return 1. Therefore a=1 or 5 and b = 4,
	 * We divide a/b and subtract a-div*b Time Complexity: O(1) as we do constant
	 * operations
	 */
	public static int modulo(int a,int b) {
		int div = a/b;
		return a - div*b;
	}
	
	/*
	 * For division, we just need to subtract the b from a and get the count Time
	 * Complexity: O(b);
	 */
	
	public static int division(int a, int b) {
		
		int count = 0;
		while(a>=b) {
			++count;
			a = a-b;
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		System.out.println(product(2,3));
		System.out.println(power(2,3));
		System.out.println(division(6,2));

	}

}
