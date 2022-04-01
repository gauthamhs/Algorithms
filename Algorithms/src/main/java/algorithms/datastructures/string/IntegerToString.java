package algorithms.datastructures.string;

public class IntegerToString {
	
	public static String integerToString(int x) {
		boolean isNegative = false;
		if(x<0) {
			isNegative = true;
			x = -x;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(x!=0) {
			sb.append(x%10);
			x/=10;
		}
		
		if(isNegative)sb.append("-");
		
		return sb.reverse().toString();
	}
	
	public static Integer stringToInteger(String val) {
		if(val==null || val.length()==0) {
			return -1;
		}
		
		int sign =val.charAt(0)=='-' ? -1: 1;
		int intValue = val.substring((sign==-1) ? 1: 0).chars().reduce(0, (runningSum, c)->runningSum*10 + c - '0');
		
		int result = sign*intValue;
		return result;
	}

	
	public static void main(String[] args) {
		int x = -123;
		String xString = integerToString(x);
		System.out.println(xString);
		Integer xVal = stringToInteger(xString);
		System.out.println(xVal);
	}
}
