package algorithms.datastructures.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Point{
	char c;
	int index;
	
Point(char c, int index){
	this.c = c;
	this.index = index;
}

}

public class MinimumWindowSubstringPoints {
	
	public static int minimumWindowSubstringPoints(List<Point> points) {
		
		int start = 0;
		int end = 0;
		int left = 0;
		int right = 0;
		
		int remainingToCover = 3;
		
		int length = Integer.MAX_VALUE;
		
		Map<Character, Integer> charMap = new HashMap<>();
		charMap.put('a', 1);
		charMap.put('b', 1);
		charMap.put('c', 1);
		
		while(end<points.size()) {
			
			right = points.get(end).index;
			char rightChar = points.get(end).c;
			
			if(charMap.containsKey(rightChar) && charMap.put(rightChar, charMap.get(rightChar)-1)>=1) {
				--remainingToCover;
			}
			
			while(remainingToCover==0) {
				
				left = points.get(start).index;
				char leftChar = points.get(start).c;
				
				length = Math.min(length, right-left);
				
				if(charMap.containsKey(leftChar) && charMap.put(leftChar, charMap.get(leftChar)+1)>=0) {
					++remainingToCover;
				}
				
				++start;
			}
			
			++end;
		}
		
		return length == Integer.MAX_VALUE ? 0 : length;
		
	}

	public static void main(String[] args) {
		
		List<Point> points = Arrays.asList(new Point('a',1), new Point('b',5), new Point('e',7), new Point('c',9),
				new Point('a',10), new Point('b',14), new Point('a',16), new Point('c',18), new Point('b',19));
		
		int length = minimumWindowSubstringPoints(points);
		System.out.println(length);
		
	}
}
