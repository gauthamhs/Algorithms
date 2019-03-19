package algorithms.datastructures.dynamicProgramming;

public class EditDistance {
	
	// In edit distance program, we are trying to idenfify what are the minimum operations we 
	// need to perform in order to convert one string to another.
	
	public static int editDistanceNaive(String sequence1, String sequence2) {
		
		if(sequence1==null && sequence2==null) {
			return 0;
		}
		
		if(sequence1 == null || sequence1.isEmpty()) {
			return sequence2.length();
		}
		
		if(sequence2==null || sequence1.isEmpty()) {
			return sequence1.length();
		}
		
		int i1 = 0;
		int i2 = 0;
		
		return editDistanceNaiveHelper(sequence1, sequence2, i1, i2);
		
	}
	
	public static int editDistanceNaiveHelper(String sequence1, String sequence2, int i1, int i2) {
		
		if(i1==sequence1.length()) {
			return sequence2.length()-i2;
		}
		
		if(i2==sequence2.length()) {
			return sequence1.length()-i1;
		}
		
		if(sequence1.charAt(i1)==sequence2.charAt(i2)) {
			return editDistanceNaiveHelper(sequence1, sequence2, i1+1, i2+1);
		}
		
		int c1 = 1 + editDistanceNaiveHelper(sequence1, sequence2, i1+1, i2); // Delete operation
		int c2 = 1 + editDistanceNaiveHelper(sequence1, sequence2, i1, i2+1); // Insert operation
		int c3 = 1 + editDistanceNaiveHelper(sequence1, sequence2, i1+1, i2+1); // Replace operation
		
		return Math.min(c1, Math.min(c2, c3));	
		
	}
	
	public static int editDistanceBottomUp(String sequence1, String sequence2) {
		
		if(sequence1==null && sequence2==null) {
			return 0;
		}
		
		if(sequence1 == null) {
			return sequence2.length();
		}
		
		if(sequence2==null) {
			return sequence1.length();
		}
		
		int[][] bottomUpMatrix = new int[sequence1.length()+1][sequence2.length()+1];
		
		for(int i1=0;i1<=sequence1.length();i1++) {
			bottomUpMatrix[i1][0] = i1;
		}
		
		for(int i2=0;i2<=sequence1.length();i2++) {
			bottomUpMatrix[0][i2] = i2;
		}
		
		for(int i1=1;i1<=sequence1.length();i1++) {
			for(int i2=1;i2<=sequence2.length();i2++) {
				if(sequence1.charAt(i1-1)==sequence2.charAt(i2-1)) {
					bottomUpMatrix[i1][i2] = bottomUpMatrix[i1-1][i2-1];
				} else { 
					int c1 = 1 + bottomUpMatrix[i1-1][i2];
					int c2 = 1 + bottomUpMatrix[i1][i2-1];
					int c3 = 1 + bottomUpMatrix[i1-1][i2-1];
					bottomUpMatrix[i1][i2] = Math.min(c1, Math.min(c2, c3));
					
				}
			}
		}
		
		return bottomUpMatrix[sequence1.length()][sequence2.length()];
		
	}
	
	public static boolean isOneEditDistanceAway(String sequence1, String sequence2) {
		
		int s1Length = sequence1.length();
		int s2Length = sequence2.length();
		
		if(Math.abs(s1Length-s2Length)>1) {
			return false;
		}
		
		int i = 0;
		int j = 0;
		int editDistanceCount = 0;
		
		while(i<s1Length && j<s2Length) {
			if(sequence1.charAt(i)==sequence2.charAt(j)) {
				i++;
				j++;
			} else { 
				++editDistanceCount;
				if(editDistanceCount>1) {
					return false;
				}
				
				if(s1Length>s2Length) {
					i++;
				} else if(s2Length>s1Length) {
					j++;
				} else {
					i++;
					j++;
				}
			}
		}
		
		if(i<s1Length || j<s2Length) {
			++editDistanceCount;
		}
		
		if(editDistanceCount==1) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String sequence1 = "passpot";
		String sequence2 = "ppssqrt";
		
		int editDistanceNaive = editDistanceNaive(sequence1, sequence2);
		System.out.println(editDistanceNaive);
		
		int editDistanceBottomUp = editDistanceBottomUp(sequence1, sequence2);
		System.out.println(editDistanceBottomUp);
		
		String sequence3 = "pot";
		String sequence4 = "pots";
		
		boolean isOneEditDistanceAway = isOneEditDistanceAway(sequence3, sequence4);
		System.out.println(isOneEditDistanceAway);
		
	}

}
