package algorithms.datastructures.string;

public class SpreadsheetEncoding {
	
	// If A-Z(1-26) AA- Returns 1+26 = 27
	public static int spreadsheetEncoding(String column) {
		return column.chars().reduce(0, (result, c) -> result*26 + c - 'A' + 1);
	}
	
	// If A-Z(0-26) AA- Returns 0+26 = 26
	public static int spreadsheetEncodingA0(String column) {
		int result = 0;
		for(int i=0;i<column.length();i++) {
			if(i>0) {
				result += 1;
			}
			result = result*26 + column.charAt(i) - 'A';
		}
		
		return result;
	}
	// A-Z 65-90
	//For spreadSheet decoding, A starts from 1. That's the reason
	// we subtract 1 from current value to get the right modulo.
	public static String spreadsheetDecoding(int decodeValue) {
		StringBuilder sb = new StringBuilder();
		int remainder = 0;
		int div = 0;
		while(decodeValue>0) {
			div = (decodeValue-1)/26;
			remainder = (decodeValue-1)%26;
			sb.append((char)( 'A' + remainder));
			decodeValue = div;
			
		}
		return sb.reverse().toString();
	}	
	
	
	public static void main(String[] args) {
		String column = "BZ";
		int spreadsheetEncodedValue = spreadsheetEncoding(column);
		System.out.println(spreadsheetEncodedValue);
		
		String column2 = "ZZ";
		
		int spreadsheetEncodedValueA0 = spreadsheetEncodingA0(column2);
		System.out.println(spreadsheetEncodedValueA0);
		
		int decodeVal = 701;
		String stringVal = spreadsheetDecoding(decodeVal);
		System.out.println(stringVal);
		
	}

}
