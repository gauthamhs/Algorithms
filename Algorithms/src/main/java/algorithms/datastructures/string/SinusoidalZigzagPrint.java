package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SinusoidalZigzagPrint {
	
/*	Input: Hello World
	Output:
		   E   L   W   R   D
 		H    L   O   O   L
 		
 		* For the zig-zag pattern we consider a new string and append to
 		* it based on the down or up indicator.
 		*/
	
	public static String printSinusoidalWave(String word, int rows) {
		
		boolean down = false;
		int length = rows - 1;
		int row = 1;
		
		List<String> stringList = new ArrayList<>(Collections.nCopies(word.length(), ""));
		
		
		if (rows == 1) {
			return word;
		}
		
		for(int i=0;i<word.length();i++) {
			stringList.set(row, stringList.get(row) + word.charAt(i));
			
			
			if(row == length) {
				down = false;
			} else if(row == 0) {
				down = true;
			}
			
			if(down) {
				row++;
			} else {
				row--;
			}
			
		}
		
		String reconstructedWord = stringList.stream().collect(Collectors.joining());
		return reconstructedWord;
			
	}
	
	public static void main(String[] args) {
		String word = "Hello World !";
		String zigzag = printSinusoidalWave(word, 5);
		System.out.println(zigzag);
	}

}
