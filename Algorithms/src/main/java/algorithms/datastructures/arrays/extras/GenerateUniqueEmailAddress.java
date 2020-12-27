package algorithms.datastructures.arrays.extras;

import java.util.HashSet;
import java.util.Set;

class GenerateUniqueEmailAddress {
    public static int numUniqueEmails(String[] emails) {
        
        Set<String> emailSet = new HashSet<>();
        
        for(String s : emails ){
            String[] splitString = s.split("@", 2);
            String localName = splitString[0];
            String domainName = splitString[1];
            StringBuilder sb = new StringBuilder("");

            for(char c: localName.toCharArray()) {
            	if(c=='.') {
            		continue;
            	} else if(c=='+') {
            		break;
            	}
            	sb.append(c);
            }
            sb.append(domainName);
            System.out.println(sb.toString());
            
            emailSet.add(sb.append(domainName).toString());
        }
        
        return emailSet.size();
    }
    
    public static void main(String[] args) {
    	
    	String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
    	
    	Integer numUniqueMails = numUniqueEmails(emails);
    	System.out.println(numUniqueMails);
		
	}
}
