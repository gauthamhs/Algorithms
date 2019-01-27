package algorithms.datastructures.string;

public class PrintSinusoidally {
	
	public static String printSinusoidally(String word) {
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<word.length();i+=4) {
			sb.append(word.charAt(i));
		}
		
		for(int j=0;j<word.length();j+=2) {
			sb.append(word.charAt(j));
		}
		
		for(int k=3;k<word.length();k+=4) {
			sb.append(word.charAt(k));
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String word = "Hello There";
		String sinusoidalWord = printSinusoidally(word);
		System.out.println(sinusoidalWord);
	}
}
