package algorithms.datastructures.string;


/*For this algorithm, we need to look at the previous sequence and need to count out loud.
*/

public class LookAndSay {
	
	public static String lookAndSay(int n) {
		String sequence = "1";
		for(int i=1;i<n;++i) {
			sequence = nextNumber(sequence);
		}
		
		return sequence;
	}
	
	public static String nextNumber(String sequence) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<sequence.length();i++) {
			int count = 1;
			
			while(i+1<sequence.length() && sequence.charAt(i) == sequence.charAt(i+1)) {
				++count;
				++i;
				
			}
			sb.append(count).append(sequence.charAt(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int n = 6;
		String lookAndSay = lookAndSay(n);
		System.out.println(lookAndSay);
	}

}
