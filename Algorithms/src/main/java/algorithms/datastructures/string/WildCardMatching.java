package algorithms.datastructures.string;

public class WildCardMatching {
	
	/*	For wild Card matching, here is the algorithm: 
		
	* - can have 0 or more occurrences between any two characters. Eg: a*b
	? - can be used to substitute any character.*/
		
    public static boolean isMatch(String s, String p) {
    	
        boolean[][] wildcardMatrix = new boolean[s.length()+1][p.length()+1];
        wildcardMatrix[0][0]=true;
        
        if(p.charAt(0)=='*') {
        	wildcardMatrix[0][1] = true;
        }
        
        for(int i=1;i<=s.length();i++) {
        	for(int j=1;j<=p.length();j++) {
        		if(p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
        			wildcardMatrix[i][j] = wildcardMatrix[i-1][j-1];
        		} else if(p.charAt(j-1)=='*') {
        			wildcardMatrix[i][j] = wildcardMatrix[i-1][j] || wildcardMatrix[i][j-1];
        		}
        	}
        }
        
        return wildcardMatrix[s.length()][p.length()];
    }
	
	public static void main(String[] args) {
		
		boolean isMatch = isMatch("xlypmsz", "x?y*z");
		System.out.println(isMatch);
		
	}

}
