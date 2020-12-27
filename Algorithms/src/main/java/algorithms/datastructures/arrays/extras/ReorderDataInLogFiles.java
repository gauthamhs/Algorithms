package algorithms.datastructures.arrays.extras;

import java.util.Arrays;
import java.util.Comparator;

/*In this Algorithm, we are given a Set of logs that needs to be ordered as such: 
 * 
 * 1) First word in the log is always an alphanumeric identifier
 * 2) The second word in the log either consists of all digits or all letters
 * 3) Letter logs come before digit logs
 * 4) Digit logs are in their original order
 * 5) In case of a tie, return letter identifiers in sorted order
*/

public class ReorderDataInLogFiles {
	
	public static String[] reorderedLogs(String[] log) {
		
		Comparator<String> logComparator = (a, b) -> {
			String[] log1 = a.split(" ", 2);
			String[] log2 = b.split(" ", 2);
			
			String identifier1 = log1[0];
			String identifier2 = log2[0];
			
			String log1Chunk = log1[1];
			String log2Chunk = log2[1];
			
			Boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
			Boolean isDigit2 = Character.isDigit(log2[1].charAt(0));
			
			/*
			 * We have 4 conditions: 
			 * 1) If both are digits, retain the sorting order, return 0
			 * 2) If first one is digit, second one is letter, digit<letter, return 1 or the
			 * letter first 
			 * 3) If first one is letter, second one is digit, letter>digit return
			 * -1 
			 * 4) If both are letters, check if they are same.a If both are same, sort by
			 * identifier, if not sort by letters
			 */
			
			if(!isDigit1&&!isDigit2) {
				if(log1[1].equals(log2[1])) {
					return identifier1.compareTo(identifier2);
				}else {
					return log1Chunk.compareTo(log2Chunk);
				}
				
			}
			
			return isDigit1 ? (isDigit2?0:1): -1;
			
		};
		
		Arrays.sort(log, logComparator);
		return log;
		
	}
	
	public static void main(String[] args) {
		String[] log = {"dig1 8 1 5 1",
				        "let1 art can",
				        "dig2 3 6",
				        "let2 own kit dig",
				        "let3 art zero"};
		
		String[] reorderedLog = reorderedLogs(log);
		System.out.println(Arrays.deepToString(reorderedLog));
		
		
	}

}
