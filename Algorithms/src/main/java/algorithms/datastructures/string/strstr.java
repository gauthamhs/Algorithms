package algorithms.datastructures.string;

public class strstr {
	
	public static boolean isStr(String text, String pattern) {
		
		int tl = text.length();
		int pl = pattern.length();
		
		if(tl==0 && pl==0) {
			return true;
		}
		if(pl==0) {
			return false;
		}
		
		for(int i=0;i<(tl-pl+1);i++) {
			if(text.substring(i, i+pl).equals(pattern)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String text = "gauzzy";
		String pattern = "auz";
		
		boolean isString = isStr(text, pattern);
		System.out.println(isString);
	}

}
