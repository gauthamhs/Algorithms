package algorithms.datastructures.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {
	
    public static List<Integer> partitionLabels(String S) {
        
        Map<Character, Integer> charMap = new HashMap<>();
        List<Integer> partitions = new ArrayList<>();
        
        for(int i=0;i<S.length();i++){
            charMap.put(S.charAt(i), i);
        }
        
        int counter = 0;

        for(int j=0;j<S.length();){
            int end = charMap.get(S.charAt(j));
            while(counter!=end){
                end = Math.max(end, charMap.get(S.charAt(counter)));
                ++counter;
            }
            partitions.add(counter-j+1);
            j=counter+1;
        }
        
        return partitions;

            
        }
	
	public static void main(String[] args) {
		String label = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(label));
		
	}

}
