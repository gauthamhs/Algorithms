package algorithms.datastructures.hashtables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class JunctionBox{
 
 String identifier;
 String version;
 
 JunctionBox(String identifier, String version){
     this.identifier = identifier;
     this.version = version;
 }

}

public class Junction
{ 
 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 public List<String> orderedJunctionBoxes(int numberOfBoxes, 
	                                         List<String> boxList) 
	{
	   
	   List<String> result = new ArrayList<>();
	   List<JunctionBox> oldGenerationBoxes = new ArrayList<>();
	   List<JunctionBox> newGenerationBoxes = new ArrayList<>();
	   
	   Comparator<JunctionBox> compString = (a,b) ->{
			
			 if(!a.version.equals(b.version)){
		            return a.version.compareTo(b.version) ;
		        }
		        
		        return a.identifier.compareTo(b.identifier);
		};

	    
	     for(int i=0;i<boxList.size();i++){
	         String[] placeholder = boxList.get(i).split(" ", 2);
	         String id = placeholder[0];
	         String version = placeholder[1];
	         
	         if(!Character.isDigit(version.charAt(0))){
	             oldGenerationBoxes.add(new JunctionBox(id, version));
	         } else{
	             newGenerationBoxes.add(new JunctionBox(id, version));
	         }
	        
	   }
	     
			Collections.sort(oldGenerationBoxes, compString);
			
			
			for(JunctionBox junctionBox: oldGenerationBoxes) {
				String s = junctionBox.identifier + " " + junctionBox.version;
				result.add(s);
			}
			
			for(JunctionBox junctionBox: newGenerationBoxes) {
				String s = junctionBox.identifier + " " + junctionBox.version;
				result.add(s);
			}
			
		return result;

	}
 
 public static void main(String[] args) {
	
}
}
