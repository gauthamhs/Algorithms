package algorithms.datastructures.arrays.extras;

/* For License key formatting: The algorithm is as follows: 
	
	1) Iterate through the whole loop from the end
    2) If its a dash, skip it and decrement i
    3) If count does not exceed k, decrement i and increment counter
    4) Once we have reached count, and count!=0, Append a '-' and make counter=0
    
    Time Complexity: O(n) since we iterate through the loop just once
    */
class LicenseKeyFormatting {
    public static String licenseKeyFormatting(String S, int K) {
        
        StringBuilder sb = new StringBuilder("");
        int i = S.length()-1;
        int counter = 0;
        
        while(i>=0) {
        	char c = Character.toUpperCase(S.charAt(i));
        	if(S.charAt(i)=='-') {
        		--i;
        	} else if(counter!=0 && counter%K==0) {
        		sb.insert(0, '-');
        		counter=0;
        	} else {
        		sb.insert(0, c);
        		--i;
        		++counter;
        	}
        }

        
        return sb.toString();
        
    }
    
    public static void main(String[] args) {
		String licenseKeyFormatting = licenseKeyFormatting("2-4A0r7-4k", 4);
		System.out.println(licenseKeyFormatting);
	}
}
