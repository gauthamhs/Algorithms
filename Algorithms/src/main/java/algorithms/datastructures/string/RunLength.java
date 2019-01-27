package algorithms.datastructures.string;

public class RunLength {
	
	
	public static String encodeString(String sequence) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<sequence.length();i++) {
			int count=1;
			while(i+1<sequence.length() && sequence.charAt(i)==sequence.charAt(i+1)){
				count++;
				i++;
			}
			sb.append(count).append(sequence.charAt(i));
		}
		return sb.toString();
		
	}
	
	public static String decodeString(String sequence) {
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		for(int i=0;i<sequence.length();i++) {
			char c = sequence.charAt(i);
			if(Character.isDigit(c)) {
				count = count*10 + c - '0'; 
			} else { 
				while(count>0) {
					sb.append(c);
					count--;
				}
			}
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		String encodeSequence = "4a2b1c1a12k";
		String decodeSequence = "ccccjjjwaaoo";
	    String encodedString = encodeString(decodeSequence);
		String decodedString = decodeString(encodeSequence);
		System.out.println(encodedString);
		System.out.println(decodedString);
		
		
	}
	
	

}
