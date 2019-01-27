package algorithms.datastructures.string;

public class FirstOccurrenceRabinKarp {
	
	// Rabin-Karp Algorithm searches for the string pattern in the text.
	// It works on a rolling hashing algorithm where it gets the hash value 
	// of string pattern and the hash value comparison and checks if they are similar.
	public static int rabinKarp(String text, String pattern) {

	    if (pattern.length() > text.length()) {
	      return -1; // s is not a substring of t.
	    }

	    final int BASE = 26;
	    int textHash = 0, patternHash = 0; // Hash codes for the substring of text and pattern.
	    int power = 1;           // BASE^|s-1|.
	    for (int i = 0; i < pattern.length(); i++) {
	      power = i > 0 ? power * BASE : 1;
	      textHash = textHash * BASE + text.charAt(i);
	      patternHash = patternHash * BASE + pattern.charAt(i);
	    }

	    for (int i = pattern.length(); i < text.length(); i++) {
	      // Checks the two substrings are actually equal or not, to protect
	      // against hash collision.
	      if (textHash == patternHash && text.substring(i - pattern.length(), i).equals(pattern)) {
	        return i - pattern.length(); // Found a match.
	      }

	      // Uses rolling hash to compute the new hash code.
	      textHash -= text.charAt(i - pattern.length()) * power;
	      textHash = textHash * BASE + text.charAt(i);
	    }
	    // Tries to match s and t.substring(t.length() - s.length()).
	    if (textHash == patternHash && text.substring(text.length() - pattern.length()).equals(pattern)) {
	      return text.length() - pattern.length();
	    }
	    return -1; // s is not a substring of t.
	  }
	
	public static void main(String[] args) {
		
		String text = "JBDCABCRDRJLWSIES";
		String pattern = "IES";
		int firstOccurrence = rabinKarp(text, pattern);
		System.out.println(firstOccurrence);
		
	}

}
