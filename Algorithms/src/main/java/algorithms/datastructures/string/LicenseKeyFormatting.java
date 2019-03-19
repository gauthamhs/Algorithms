package algorithms.datastructures.string;

public class LicenseKeyFormatting {
	
	public static String licenseKeyFormatting(String S, int K) {
		
		if(S==null || S.length()==0) {
			return S;
		}
		
		StringBuilder sb = new StringBuilder();
		
		int i=S.length()-1;
		int count = 0;
		
		while(i>=0) {
			if(S.charAt(i)=='-') {
				i--;
				} else if (count!=0 && count%K==0) {
					sb.append('-');
					count = 0;
				} else {
					char c = Character.toUpperCase(S.charAt(i));
					sb.append(c );
					count++;
					i--;
				}
			
		}
		
		return sb.reverse().toString();
		
	}
	
	public static void main(String[] args) {
		String S = "2-5g-3-J";
		int K = 2;
		
		String licensedKey = licenseKeyFormatting(S, K);
		System.out.println(licensedKey);
	}

}
