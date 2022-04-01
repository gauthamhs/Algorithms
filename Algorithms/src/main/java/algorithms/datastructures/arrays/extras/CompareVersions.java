package algorithms.datastructures.arrays.extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareVersions {
	
	public static int compareVersions(String version1, String version2) {
		
		

		List<String> s1 = new ArrayList<>(Arrays.asList(version1.split("\\.")));
		List<String> s2 = new ArrayList<>(Arrays.asList(version2.split("\\.")));
		Integer n1 = s1.size();
		Integer n2 = s2.size();
		
		if(n2>n1) {
			s1 = padZeros(s1,n2-n1);
		}else if(n2<n1) {
			s2 = padZeros(s2,n1-n2);
		}
		
		for(int i=0;i<Math.max(n1, n2);i++) {
			int compare = helper(s1.get(i),s2.get(i));
			if(compare!=0) {
				return compare;
			}
		}
		
		return 0;
		
		
	}
	
	public static int helper(String s1, String s2) {
		int i1 = Integer.parseInt(removeleadingZeros(s1));
		int i2 = Integer.parseInt(removeleadingZeros(s2));
		
		return Integer.compare(i1, i2);
		
	}
	
	public static String removeleadingZeros(String s) {
		int i=0;
		while(i<s.length() && s.charAt(i)=='0') {
			++i;
		}
		
		return (i==s.length()) ? s.substring(i-1):s.substring(i);
		
	}
	
	public static List<String> padZeros(List<String> s, int length){
		while(length>0) {
			s.add("0");
			--length;
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		
		String version1 = "1.0";
		String version2 = "1.0.0";
		System.out.println(compareVersions(version1, version2));
		
	}

}
