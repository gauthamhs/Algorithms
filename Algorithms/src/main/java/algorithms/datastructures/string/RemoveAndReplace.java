package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.List;

public class RemoveAndReplace {
	
	public static List<Character> removeAndReplace(int size, List<Character> charList) {
		int writeIndex = 0;
		int aCount = 0;
		
		// Forward Iteration: Remove: B's and count A's
		for(int i=0;i<size;i++) {
			if(charList.get(i)!='b') {
				charList.set(writeIndex++, charList.get(i));
			}
			if(charList.get(i)=='a') {
				aCount++;
			}
		}
		
		//Backward Iteration: Add d's in place of A's.
		int currentIndex = writeIndex - 1;
		writeIndex = writeIndex + aCount - 1;
		
		while(currentIndex>=0) {
			if(charList.get(currentIndex)=='a') {
			 	charList.set(writeIndex--, 'd');
			 	charList.set(writeIndex--, 'd');
			} else {
				charList.set(writeIndex--, charList.get(currentIndex));
			}
			currentIndex--;
		}
		return charList;
		
	}
	
	public static void main(String[] args) {
		List<Character> charList = new ArrayList<>();
		charList.add('a');
		charList.add('c');
		charList.add('c');
		charList.add('b');
		charList.add('b');
		charList.add('a');
		charList.add('a');
		charList.add('b');
		charList.add('b');
		charList.add('c');
		int size = 10;
		List<Character> finalList = removeAndReplace(size, charList);
		System.out.println(finalList);
		
		
		
	}

}
