package algorithms.datastructures.string;


//Given a string, define a function to find the longest streak of a character
//"aabbaaaccccdee" -> "c"
//"aabbbccdeaa" -> "b"
//"aaabbb" -> "a"
public class MaximumConsecutiveRepeatingCharacter {
	
	public static Character maximumConsecutiveCharOccurrence(String sequence) {
		
		if(sequence.length()==0) {
			return null;
		}
		
		int maxCount = 1;
		Character maxChar = sequence.charAt(0);
		
		for(int i=0;i<sequence.length();i++) {
			int currentCount = 1;
			
			while(i+1<sequence.length() && sequence.charAt(i)==sequence.charAt(i+1)) {
				++currentCount;
				++i;
			}
			
			if(currentCount>maxCount) {
				maxCount = currentCount;
				maxChar=sequence.charAt(i);
			}
			
		}
		
		return maxChar;
	}
	
	public static void main(String[] args) {
		String sequence = "aabbaaaaaccccdee";
		Character ch = maximumConsecutiveCharOccurrence(sequence);
		System.out.println(ch);
		
	}

}
