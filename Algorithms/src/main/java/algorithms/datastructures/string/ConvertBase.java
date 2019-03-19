package algorithms.datastructures.string;

public class ConvertBase {
	
	public static String convertBase(int numString, int base) {
	
		return Integer.toString(numString, base);
		
	}
	
	public static void main(String[] args) {
		
		int b1 = 10;
		int b2 = 2;
		String numString = "25";
		
		String base10to2 = convertBase(Integer.parseInt(numString), b2);
		System.out.println(base10to2);
	}

}
