package algorithms.datastructures.string;

import java.util.Arrays;

public class StringCompression {
	
	public static void main(String[] args) {
		//char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		char[] chars1 = {'a','b'};
		char[] charArray = compress(chars1);
		System.out.println(charArray);
	}
	
	 public static char[] compress(char[] chars) {
	        
	        if(chars.length==1){
	            return new char[] {'1'};
	        }
	        
	        int j = 0;
	        for(int i=0;i<chars.length;i++){
	            int count = 1;
	            j=0;
	            while((i+1)<chars.length && chars[i]==chars[i+1]){
	                count++;
	                i++;
	            }
	            
	            if(count>1){
	                j = j+1;
	        }
	            
/*	            if(count>10){
	                chars[j] = (char) (count/10);
	                chars[j+1] =(char) (count%10);
	                j=j+1;
	            } else{
	                chars[j] = (char) count;
	            }
	            j++;*/
	    }
	        
	        return Arrays.copyOfRange(chars, 0,j);
	}

}
