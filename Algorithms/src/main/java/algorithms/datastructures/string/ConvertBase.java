package algorithms.datastructures.string;

public class ConvertBase {
	
	public static String convertBase(String numString, int b1, int b2) {
	
		return Integer.toString(b1, b2);
		
	}
	
	public static void main(String[] args) {
		
		int b1 = 10;
		int b2 = 2;
		String numString = "25";
		
		String base10to2 = convertBase(numString, b1, b2);
		System.out.println(base10to2);
	}

}
