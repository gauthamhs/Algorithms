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
	
    public int strStr(String haystack, String needle) {
        
        int n = haystack.length();
        int p = needle.length();
        
        if(n==0&&p==0 || p==0){
            return 0;
        }
        
        if(n==0){
            return -1;
        }
        
        
        for(int i=0;i<n-p+1;i++){
            int j=0;
            while(j<p){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                ++j;
            }
            
            if(j==p) return i;
        
        }
        
        return -1;
        
    }
	
	public static void main(String[] args) {
		String text = "gauzzy";
		String pattern = "auz";
		
		boolean isString = isStr(text, pattern);
		System.out.println(isString);
	}

}
