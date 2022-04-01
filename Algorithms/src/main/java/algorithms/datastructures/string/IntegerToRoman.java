package algorithms.datastructures.string;

import java.util.Map.Entry;
import java.util.TreeMap;

public class IntegerToRoman {
	
	public static String integerToRoman(int num) {
		
		int[] arabicNumbers =     {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] romanSymbols =   {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<arabicNumbers.length;i++) {
			while(num - arabicNumbers[i] >=0) {
				sb.append(romanSymbols[i]);
				num = num - arabicNumbers[i];
			}
		}
		
		return sb.toString();
		
	}
	
	public static String integerToRomanTreeMap(Integer num) {
		
		StringBuilder sb = new StringBuilder("");
		
		TreeMap<Integer, String> romanMap = new TreeMap<>();
		romanMap.put(1, "I");
		romanMap.put(4, "IV");
		romanMap.put(5, "V");
		romanMap.put(9, "IX");
		romanMap.put(10, "X");
		romanMap.put(40, "XL");
		romanMap.put(50, "L");
		romanMap.put(90, "XC");
		romanMap.put(100, "C");
		romanMap.put(400, "CD");
		romanMap.put(500, "D");
		romanMap.put(900, "CM");
		romanMap.put(1000, "M");

		while(num!=0) {
			Entry<Integer, String> entry = romanMap.floorEntry(num);
			Integer val = entry.getKey();
			String roman = entry.getValue();
			
			sb.append(roman);
			num = num-val;
		}
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		int number = 3549;
		String romanNumber = integerToRoman(number);
		System.out.println(romanNumber);
		System.out.println(integerToRomanTreeMap(number));
	}

}
