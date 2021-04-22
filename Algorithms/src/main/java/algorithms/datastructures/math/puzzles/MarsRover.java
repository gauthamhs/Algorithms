package algorithms.datastructures.math.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarsRover {
	
	public static List<Object> marsRover(List<Rover> rovers){
		
		List<Object> result = new ArrayList<>();
		
		Map<Character, Character> dirMap = new HashMap<>();
		dirMap.put('N', '0');
		dirMap.put('W', '1');
		dirMap.put('S', '2');
		dirMap.put('E', '3');
		dirMap.put('0', 'N');
		dirMap.put('1', 'W');
		dirMap.put('2', 'S');
		dirMap.put('3', 'E');

		
		
		for(Rover rover : rovers) {
			Integer x = rover.x;
			Integer y = rover.y;
			char dir = rover.direction;
			String commands = rover.commands;
			int index = (int)(dirMap.get(dir)-'0');
			int[][] shiftDir = {{0,1},{-1,0},{0,-1},{1,0}};
					
			for(char c: commands.toCharArray()) {
				switch(c) {
				
				case 'L' : {
					index = (index+1)%4;
					break;
				}
				
				case 'R' : {
					index = (index+3)%4;
					break;
				}
				
				case 'M' : {
					 x = x+shiftDir[index][0];
					 y = y+shiftDir[index][1];
					break;
				}
				
				default: break;
				
				}
			
				
			}
			
			result.add(Arrays.asList(x,y,dirMap.get((char)('0' + index))));
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		
		Rover rover1 = new Rover(1,2,'N',"LMLMLMLMM");
		Rover rover2 = new Rover(3,3,'E',"MMRMMRMRRM");
		List<Rover> rovers = Arrays.asList(rover1, rover2);
		System.out.println(marsRover(rovers));
		
	}

}

class Rover{
	

	
	int x;
	int y;
	char direction;
	String commands;
	
	public Rover() {
		
	}
	
	public Rover(int x, int y, char direction, String commands) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.commands = commands;
	}
	
}


