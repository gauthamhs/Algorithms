package algorithms.datastructures.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringDecompositions {
	
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> wCount = new HashMap<>();
        
        for(String word: words) wCount.put(word, wCount.getOrDefault(word, 0) + 1);
        int start = 0, end = 0, step = words[0].length(), len = step * words.length;
        if(s.length() < len) return ans;

        while(end <= s.length()){
            if(end - start == len){
                if(findString(s.substring(start, end), wCount, step)) ans.add(start);
                start++;
            }
            end++;
        }
        return ans;
    }

    private static boolean findString(String s, HashMap<String, Integer> wCount, int step){
        HashMap<String, Integer> sCount = new HashMap<>();
        int i = 0;
        while(i + step <= s.length()){
            String current = s.substring(i, i + step);
            if(!wCount.containsKey(current)) return false;
            sCount.put(current, sCount.getOrDefault(current, 0) + 1);
            i += step;
        }
        if(wCount.equals(sCount)) return true;
        return false;
    }
    
    public static void main(String[] args) {
    	String s = "barfoofoobarthefoobarman";
    	String[] words = {"bar","foo","the"};
		List<Integer> vals = findSubstring(s, words);
		System.out.println(vals);
	}

}
