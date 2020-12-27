package algorithms.datastructures.string;

/*For URLIFy program, we need to make use of the extra string buffer at the end so that we can modify it in place
 * In this method, we need to count the no. of spaces, that needs to be replaced. We also need a readIndex(the string index)
 * we will be reading from, and write index(where we will be updating the values)
 * Time Complexity(O(n): When n is the totalChar. Space Complexity: O(1) in place.
 * */

public class URLify {
	
	public static String urlify(char[] name, int totalChar) {
		int n = name.length;
		int spaces=0;
		
for(int j=0;j<totalChar;j++) {
	if(name[j]==' ') {
		++spaces;
	}
}

		int writeIndex=totalChar-spaces+(spaces*3)-1;
		System.out.println(writeIndex);
		
		for(int i=totalChar-1;i>=0;i--) {
			if(name[i]==' ') {
				name[writeIndex--]='0';
				name[writeIndex--]='2';
				name[writeIndex--]='%';
			}else {
				name[writeIndex--]=name[i];
			}
		}
		
		return new String(name);
	}
	
	public static void main(String[] args) {
		String name = "Mr John Smith    ";
		char[] nameChar = name.toCharArray();
		String urlify = urlify(nameChar, 13);
		System.out.println(urlify);
	}

}
