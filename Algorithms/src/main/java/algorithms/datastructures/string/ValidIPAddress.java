package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress {
	
	public static List<String> validIPAddresses(String ipWord){
		List<String> ipAddressList = new ArrayList<>();
		for(int i=1;i<4&&i<ipWord.length();i++) {
			String first = ipWord.substring(0, i);
			if(isValidIP(first)) {
				for(int j=1; j<4 && i+j<ipWord.length();j++) {
					String second = ipWord.substring(i,i+j);
					if(isValidIP(second)) {
						for(int k=1; k<4 && i+j+k<ipWord.length();k++) {
							String third = ipWord.substring(i+j,i+j+k);
							String fourth = ipWord.substring(i+j+k);
							if(isValidIP(third)&&isValidIP(fourth)) {
								ipAddressList.add(first+"." + second+"."+ third+"."+fourth);
							}
						}
					}
				}
			}
		}
		return ipAddressList;
	}
	
	public static boolean isValidIP(String ip) {
		if(ip.length()>3) {
			return false;
		}
		
		if(ip.startsWith("0") && ip.length()>1) {
			return false;
		}
		
		int ipInt = Integer.parseInt(ip);
		return ipInt>=0 && ipInt<=255;
		
	}
	
	public static boolean checkifIPisValid(String ipWord) {
		String[] tokenizer = ipWord.split("\\.");
		for (String token : tokenizer) {
			return isValidIP(token);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String ipWord = "19216811";
		List<String> ipAddressList = validIPAddresses(ipWord);
		System.out.println(ipAddressList);
		
		String ipAddress="00.168.1.1";
		Boolean isValid = checkifIPisValid(ipAddress);
		System.out.println(isValid);
	}

}
