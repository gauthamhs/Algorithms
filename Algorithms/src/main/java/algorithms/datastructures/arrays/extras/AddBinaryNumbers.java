package algorithms.datastructures.arrays.extras;

public class AddBinaryNumbers {
	
	public static String addBinaryNumbers(String a, String b) {
		int i = a.length()-1;
		int j = b.length()-1;
		int carry = 0;
		int sum = 0;
		
		int val1 = 0;
		int val2 = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(i>=0||j>=0 || carry!=0) {
			val1 = (i<0) ? 0 : a.charAt(i)-'0';
			val2 = (j<0) ? 0 : b.charAt(j)-'0';
			
			sum = val1 + val2 + carry;
			
			sb.insert(0, sum%2);
			
			carry = sum/2;
			--i;
			--j;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String a="11";
		String b="1";
		
		String c="1010";
		String d="1011";
		
		String add1 = addBinaryNumbers(a, b);
		String add2 = addBinaryNumbers(c, d);
		
		System.out.println(add1);
		System.out.println(add2);
	}

}
