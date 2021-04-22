package algorithms.sort.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankVotes {
	
	public static String rankVotes(String[] votes) {
		
		if(votes==null || votes.length==0) {
			return "";
		}
		
		int n = votes[0].length();
		
		Map<Character, List<Integer>> voteMap = new HashMap<>();
		
		
		for(String vote :  votes) {
			for(int i=0;i<n;i++) {
				Character c = vote.charAt(i);
				voteMap.putIfAbsent(c, new ArrayList<>(Collections.nCopies(n, 0)));
				voteMap.get(c).set(i, voteMap.get(c).get(i) + 1);
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		
		List<Character> charList = new ArrayList<>(voteMap.keySet());
		
		Comparator<Character> comp = (a,b) -> {
		
			List<Integer> rankA = voteMap.get(a);
			List<Integer> rankB = voteMap.get(b);
			
			for(int i=0;i<n;i++) {
				if(rankA.get(i)!=rankB.get(i)) {
					return Integer.compare(rankB.get(i), rankA.get(i));
				}
			}
			
			return Integer.compare(a, b);
			
		};
		
		Collections.sort(charList, comp);
		
		
		for(int i=0;i<n;i++) {
			sb.append(charList.get(i));
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
		String vote = rankVotes(votes);
		System.out.println(vote);
		
	}

}
