package test.algorithms.primitivetypes;

import org.junit.Before;
import org.junit.Test;

import algorithms.primitivetypes.BitwiseOperations;

public class BitwiseOperationsTest {
	
	private BitwiseOperations bitwiseOperations;
	
	@Before
	public void setup(){
	bitwiseOperations = new BitwiseOperations();
	}

	@Test
	public void testCountNoOfBits(){
		Integer val = 3;
		System.out.println("Value of the Integer: " + val);
		short countBits = bitwiseOperations.countNoOfBits(val);
		System.out.println("Total no. of 1's: " + countBits);
	}
	
	@Test
	public void testCheckParityBrute(){
		Integer val = 2; //010

		short parityVal = bitwiseOperations.checkParityBrute(val);
		System.out.println("Parity Val: " + parityVal);
	}
	
	@Test
	public void testCheckParityFiddle(){
		Integer val = 4; //0100

		short parityVal = bitwiseOperations.checkParityFiddle(val);
		System.out.println("Parity Val: " + parityVal);
	}
	
	@Test
	public void testCheckParityAssociativity(){
		Integer val = 4; //0100

		short parityVal = bitwiseOperations.checkParityAssociativity(val);
		System.out.println("Parity Val: " + parityVal);
	}
	
	@Test
	public void testSwapBits(){
		Integer val = 50; 
		long swappedInteger = bitwiseOperations.swapBits(2, 4, val);
		System.out.println("Integer with replaced Bits: " + swappedInteger);
	}
	
	@Test
	public void testReverseBits(){
		Integer val =43261596; 
		int swappedInteger = bitwiseOperations.reverseBits(val);
		System.out.println("Reversed Integer: " + swappedInteger);
	}
	
	@Test
	public void testFindClosestInteger() {
		Integer val = 7; 
		long closestInteger = bitwiseOperations.findClosestIntegerwithSameWeight(val);
		System.out.println("Closest Integer: " + closestInteger);
	}
	
	@Test
	public void testAddTwoNumbers() {
		Integer val1 = 21; 
		Integer val2 = 3;
		long result = bitwiseOperations.sum(val1, val2);
		System.out.println("Added result: " + result);
	}
	
	@Test
	public void testMultiplyTwoNumbers() {
		Integer val1 = 21; 
		Integer val2 = 3;

		long result = bitwiseOperations.multiply(val1, val2);
		System.out.println("Multiplied result: " + result);
	}
	
	@Test
	public void testDivideTwoNumbers() {
		Integer val1 = 21; 
		Integer val2 = 4;

		long result = bitwiseOperations.division(val1, val2);
		System.out.println("divided result: " + result);
	}
	
	@Test
	public void testPowerofTwoNumbers() {
		Integer value = 4;
		Integer power = 2;
		long result = bitwiseOperations.power(value, power);
		System.out.println("The result after power is: " + result);
	}
	
	@Test
	public void testReversedNumber() {
		int value = 12319213;
		
		long result = bitwiseOperations.reverseNumber(value);
		System.out.println("The reversed Number is: " + result);
	}
	
	@Test
	public void testIsPalindrome() {
		int value = 123321;
		System.out.println(value%100000);
		
		boolean result = bitwiseOperations.isPalindrome(value);
		System.out.println("Is the number a palindrome? : " + result);
	}
	
	@Test
	public void testIsPalindromeDigit() {
		int value = 23132;
		
		boolean result = bitwiseOperations.isPalindromedigit(value);
		System.out.println("Is the number a palindrome? : " + result);
	}
	
	}
	


