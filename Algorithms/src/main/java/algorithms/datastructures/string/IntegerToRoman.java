package algorithms.datastructures.string;

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
	
	public static void main(String[] args) {
		int number = 3549;
		String romanNumber = integerToRoman(number);
		System.out.println(romanNumber);
	}

}
