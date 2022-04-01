package algorithms.datastructures.string;

public class ConvertBase {
	
	public static String convertBase(String numString,int fromBase, int toBase) {
	
		return Integer.toString(Integer.parseInt(numString, fromBase), toBase);
		
	}
	// Questions: Can the number be positive or negative ?
	// Does the number contain Alphabets for Hexadecimal ?
	public static String baseConversion(String numAsString, int b1, int b2) {
        int sign = numAsString.startsWith("-") ? -1 : 1;
        int numAsInt = numAsString.substring( (sign<0 ? 1: 0))
                .chars()
                .reduce(0, (agg,ch) -> agg*b1 +
                        (Character.isDigit(ch) ? ch-'0' : ch-'A'+10));

        return (sign<0 ? "-":"") + (numAsInt==0 ? "0" : constructFromBase(numAsInt, b2));
    }

    public static String constructFromBase(Integer numAsInt, int base){
        return numAsInt==0 ? "" :
                constructFromBase(numAsInt/base, base) +
                        (char)  ((numAsInt%base<10) ? numAsInt%base + '0' : numAsInt%base + 'A' - 10);
    }
	
	public static void main(String[] args) {
		
		int b1 = 10;
		int b2 = 2;
		String numString = "25";
		
		String base10to2 = convertBase(numString, b1, b2);
		System.out.println(base10to2);
	}

}
