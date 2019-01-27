package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.List;

public class TelexEncoding {
	
	public static List<Object> telexEncoding(List<Object> charList){
		
		for(int i=0;i<charList.size();i++) {
			switch((char)charList.get(i)) {
			case '.' : charList.set(i, "DOT");
			           break;
			case ',' : charList.set(i, "COMMA");
				       break;
			case '?' : charList.set(i, "QUESTION MARK");
				       break;
			case '!' : charList.set(i, "EXCLAMATION MARK");
				       break;
			default : break;
			}
		}
		return charList;
	}
	
	public static void main(String[] args) {
		List<Object> charList = new ArrayList<>();
		charList.add('c');
		charList.add('9');
		charList.add('4');
		charList.add('.');
		charList.add('a');
		charList.add(',');
		charList.add('?');
		charList.add('2');
		charList.add('!');
		charList.add('2');
		
		List<Object> charListTelex = telexEncoding(charList);
		System.out.println(charListTelex);
		
	}

}
