package algorithms.datastructures.string;


//Given a string, define a function to find the longest streak of a character
//"aabbaaaccccdee" -> "c"
//"aabbbccdeaa" -> "b"
//"aaabbb" -> "a"
public class MaximumConsecutiveRepeatingCharacter {
	
	public static Character maximumConsecutiveCharOccurrence(String sequence) {
		
		if(sequence==null || sequence.isEmpty()){
			return null;
		}
		int count = 0;
		Character ch = null;
		int currentCount = 1;
		
		for(int i=0;i<sequence.length();i++) {
			if(i<sequence.length()-1 && sequence.charAt(i)==sequence.charAt(i+1)) {
				currentCount++;
			} else {
				if(currentCount>count) {
					count = currentCount;
					ch = sequence.charAt(i);
			    }
			
				currentCount = 1;
			}
		}
		
		return ch;
	}
	
	public static void main(String[] args) {
		String sequence = "aabbaaaccccdee";
		Character ch = maximumConsecutiveCharOccurrence(sequence);
		System.out.println(ch);
		
	}

}
