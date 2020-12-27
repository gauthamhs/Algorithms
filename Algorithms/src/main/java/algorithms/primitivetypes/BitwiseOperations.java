package algorithms.primitivetypes;

public class BitwiseOperations {
	
	/*
	 * ConvertBitsToNum: Lets say, we have a string of bits, we need to get its
	 * integer number 101:5
	 * 
	 * Here we need to use the 2's formula: 2^0*1 + 2^2*1 = 5
	 * 2^0,2^1,2^2 is constant. Since its multiplication we use left shift, if we find 1, we multiply by 1 and move on.
	 */
	public int convertBitsToNum(String num) {
		int val=0;
		for(char n : num.toCharArray()) {
			val = val<<1;
			if(n=='1') {
				val+=1;
			}
		}
		
		return val;
	}
	
	
	/*
	 * Here we keep processing the bits until there are no longer any bits to process,
	 * We use right shift to divide the number. we check the state of the lsb and keep processing until we recorded all bits
	 */	
	public String convertNumtoBits(int number) {
		StringBuilder result =  new StringBuilder("");
		while(number!=0) {
			result.insert(0, number&1);
			number = number>>>1;
		}
		
		return result.toString();
	}
	

	/*BitCount: Count total number of 1's 
	 * This process is done by masking:- AND operation with the integer value
	 * and shifting:- Shifting the bit to the right after the masking is performed
	 * Input: Integer
	 * Output: Total occurrences of 1
	 * Example: Lets say we input an integer of 3 having binary value of 011, we must get total occurrences of 1 as 2.
	 * Complexity: O(N) since we perform O(1) computation for each bit in the integer
*/	
	
	public short countNoOfBits(int val) {
		
		short numOfBits = 0;
		while(val!=0) {
			numOfBits += (val&1);
			val >>>= 1;
		}

		return numOfBits;
	}
	
	/*Check Parity of an Integer: If an integer has odd bits, return 1, else if integer has even bits return 0
	 * Example: For 3 that has bits (011), the output should return 0, and for 1, the output should return 1
	 * 
	 * */
	
/*	Method 1: This is a brute force method where we iterate through each bit in the integer and apply XOR, AND operators
	to see if they have even or odd no of 1 bits.
	Example: (011) has two 1's. we mask the least significant bit with 1 by doing and operation and XOR the result.
	This would return 1 in the first instance. Next, we shift digits to right (001) and XOR this with 1 which would return 0.
	
	*/

	public short checkParityBrute(int val) {
		short parityVal = 0;
		while(val!=0) {
			parityVal ^= (val & 1);
			val>>>=1;
		}
		return parityVal;
		
	}
	
	/*Method 2: In this method, we add a little hack to reduce the no of computations/iterations to check the parity of a given integer
	 * We reduce the computations by turning off the 1's in each iteration
	 * For example, if we have a bit value of (01010100000101010), instead of iterating through each bit, we iterated only when 1 is present
	 * thereby switching it off and xoring the result to 1
	 * Time Complexity: O(k) where k: no of 1 bits;
	 * This would be efficient if the integer has lesser number of 1 bits.
	 * */
	
	public short checkParityFiddle(int value){
		short parityVal = 0;
		while(value!=0) {
			parityVal ^= 1;
			value &= (value-1);
		}
		return parityVal;
	}
	
	/*Method 3: Most Efficient method would be to use the commutativity and associative property of XOR. We can cache the parity
	 * of different X-OR results and combine them to obtain parity.
	 * O(log(n): Complexity. We are scraping half of the bits.
	 * 
	 * */
	
	public short checkParityAssociativity(long val){
		val ^= val>>>32;
		val ^= val>>>16;
		val ^= val>>>8;
		val ^= val>>>4;
		val ^= val>>>2;
		val ^= val>>>1;
		
		return (short)(val & 1);
		}
	
	/* Swap Bits: In this method, we replace the bits at ith and jth place for the integer value
	 * We first check if the bits have the same value. If not, we create a mask at ith and jth positions
	 * and then perform an XOR operation with the mask and the actual integer.
	 * Complexity: O(1).
	 * */
	
	public long swapBits(int i,int j,long value ) {
		if((value>>i&1) != (value>>j&1)) {
			long mask = (1L<<i | 1L<<j);
			value ^= mask;
		}
		return value;
	}
	
	/*Reverse Bits: Reverse bits with O(n) complexity. 
	 * Like (0010) reverses to (0100)
	 * */
	 public int reverseBits(int n) {
	        int result = 0;
	        while(n!=0) {
	        	result = result<<1;
	        	if((n&1)==1) {
	        		result+=1;
	        	}
	        	n = n>>1;
	        }
	        
	        return result;
	    }
	
/*	Find Closest integer with same weight(traverses forwards and backwards): 
 * For example. If we type in an integer 6 (110), it would return 5( 101) since that is the closest integer to 6 and has
 * the same weight(No of 1's). Another example would be 7 (111) which would return 11 (1011). Therefore, this method
 * traverses forwards and backwards to find the closest integer with the same weight.
 * 
 * Since in this method, we are using non-negative integers, we can overlook the leading bit.
 * Also, if all bits are 0 or 1, we can throw an error.
 * */
	
	public int findClosestIntegerwithSameWeight(int val) {
		int UNSIGNED_BIT = 63;
		for(int i=0;i<UNSIGNED_BIT-1;++i) {
			if(((val>>i)&1) != (val>>(i+1)&1)) {
				val ^= (1L<<i) | (1L<<i+1);
				return val;
			}
		}
	
		throw new IllegalArgumentException("All Bits are 0 or 1. Please check the Integer value");
		
	}

/*	Sum of two integers: In this method, We are calculating sum of two integers using bit operations.
	Complexity: O(n) since we define 'n' no of bits needed to represent the operands.*/
	
	public long sum(long a, long b) {
		long carryBits = 0;
		
		while(b!=0) { // If there is no carry propagated to the left, end loop
			carryBits = (a&b) ; // Determine the bits that needs to be carried over
			a = a ^ b; //Add a and b without the carry
			b = carryBits<<1; // Propagate the carry if any
		}
		
		return a;
		
	}
	/* Multiplication of two integers: In this method, we are multiplying two integers by adding and shifting. 
	 * For example, 3*5 = 0 + 5 + 10
	 * Complexity: O(n^2) since we perform n additions and n sums under each multiplications
	 * */
	public long multiply(long a, long b) {
		long sumVal = 0;
		while(a != 0) {
			if((a&1) != 0) {
				sumVal = sum(sumVal, b);
			}
			a >>= 1;
			b <<= 1;
		}
		return sumVal;	
	}
	
/*	Division of two numbers: The quotient will be equal to no of times the dividend is subtracted by the divisor
	Complexity: O(n)*/
	
	public long division(int dividend, int divisor) {
		long quotient = 0;
		int sign = (dividend<0) ^ (divisor<0) ? -1:1;
		while(dividend>=divisor) {
			dividend-=divisor;
			quotient++;
		}
		return sign*quotient;
		
	}
	
/*	If power is 0 then the result is 1
	Complexity: O(n)
	*/
	public long power(int value, int power) {
		long result = 1;
		if(power==0) {
			return result;
		}
		if(power<0) {
			value = (1/value);
			power = -power;
		}
		
		while(power>0) {
			if((power&1) == 1) {
				result *= value;
			}
			
			value *= value;
			power >>>=1;
		}

		return result;
		
	}
	//4321 should return 1234
	public int reverseNumber(int val) {
		int reversedNumber = 0;
		int lastDigit = 0;
		while(val>0) {
			lastDigit = val%10;
			reversedNumber = reversedNumber*10 + lastDigit;
			val = val/10;
		}
		return reversedNumber;
	}
	
/*	Brute force approach is to convert the digit to string, reverse the string and compare the string
	to original one to see if they are equal. If so, the value is a palindrome.
	Complexity: Increases as digit value increases.
	*/
	
	public boolean isPalindrome(int val) {
		boolean isPalindrome = false;
		String valString = Integer.toString(val);
		StringBuilder sb = new StringBuilder();
		sb.append(valString);
		String reversedString = sb.reverse().toString();
		if(valString.equals(reversedString)) {
			isPalindrome = true;
		}
		return isPalindrome;
	}
	
	/*Second method to check if a digit is a palindrome or not is to use bitwise operations on the Digit
	 * 123321
	 * */
	
	public boolean isPalindromedigit(int val) {
		boolean isPalindrome = false;
		int NoOfDigits = (int)Math.floor(Math.log10(val)) + 1; // This is used to calculate total no of digits
		int mask = (int) Math.pow(10, NoOfDigits-1); // We use this mask to extract the MSB.
		while(val>0) {
			if((val/mask) != (val%10)) {
				return false;
			}
			val %= mask; //Remove the most significant Bit
			val /= 10;  //Remove the least significant bit
			mask /= 100;
		}
		isPalindrome = true;
		return isPalindrome;
	}
}
