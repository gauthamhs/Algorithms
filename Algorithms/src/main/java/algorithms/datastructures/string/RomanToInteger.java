package algorithms.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	public static int romanIntValue(String romanValue) {
		int romanIntegerValue = 0;
		
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		romanIntegerValue = romanMap.get(romanValue.charAt(romanValue.length()-1));
		for(int i = romanValue.length()-2;i>=0;i--) {
			if(romanMap.get(romanValue.charAt(i))<romanMap.get(romanValue.charAt(i+1))){
				romanIntegerValue -= romanMap.get(romanValue.charAt(i));
			} else {
				romanIntegerValue += romanMap.get(romanValue.charAt(i));
			}
		}
		
		return romanIntegerValue;
	}
	
	public static void main(String[] args) {
		String romanValue = "IIIIV";
		int romanIntVal = romanIntValue(romanValue);
		System.out.println(romanIntVal);
	}
}
