package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneMnemonics {
	
	/*Recursion Approach:
	 * To find the phone Mnemonics, we start with the left most digit and progress to the right. 
	 * 
	 * For example, if the digit is 23. We start with 2, add AD,AE,AF. then move to B.
	 * In this case, the digit must be equal to phone number length to add a partial pnemonic to a pnemonic.
	 * */
	 public static List<String> phoneMnemonic(String phoneNumber) {
		 List<String> mnemonics = new ArrayList<>();
		 phoneMnemonicHelper(phoneNumber, 0, new char[phoneNumber.length()], mnemonics);
		 return mnemonics;
	 }
	 
	 private static final String[] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO",
			                                  "PQRS","TUV","WXYZ"};
	 
	 public static void phoneMnemonicHelper(String phoneNumber, int digit, char[] partialMnemonic, List<String> mnemonics) {
		 if(digit==phoneNumber.length()) {
			 mnemonics.add(new String(partialMnemonic));
		 }
		 else {
			 for(int i=0;i<MAPPING[phoneNumber.charAt(digit) - '0'].length();i++) {
				 char c = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
				 partialMnemonic[digit]=c;
				 phoneMnemonicHelper(phoneNumber, digit+1, partialMnemonic, mnemonics);
			 }
		 }
	 }
	 
	 public static List<String> phoneMnemonicIteration(String phoneNumber){
		 
		 if(phoneNumber==null) {
			 return Collections.emptyList();
		 }
		 List<String> mnemonics = new ArrayList<>();
		 mnemonics.add("");
		 
		 for(int i=0;i<phoneNumber.length();i++) {
			String letter = MAPPING[phoneNumber.charAt(i) -'0'];
			List<String> partialMnemonics = new ArrayList<>();
			for(int j=0;j<letter.length();j++) {
				
				for (String string : mnemonics) {
					StringBuilder sb = new StringBuilder();
					sb.append(string).append(letter.charAt(j));
					partialMnemonics.add(sb.toString());
				}	
				}
			mnemonics = partialMnemonics;
			}
				
		 return mnemonics;
	 }
	 

		
	
	public static void main(String[] args) {
		String phoneNumber = "23";
		List<String> combinations = phoneMnemonic(phoneNumber);
		System.out.println(combinations);
		List<String> combinations2 = phoneMnemonicIteration(phoneNumber);
		System.out.println(combinations2);
	}

}
