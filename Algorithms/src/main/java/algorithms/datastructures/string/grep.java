package algorithms.datastructures.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class grep {
	
	public static void grepContext(String[] tokens, int context, String searchText) {
		final Queue<String> queue = new LinkedList<String>();
		int count = 0;
		for (String token : tokens) {
			boolean exist = token.startsWith(searchText);
			
			// once search text found then reset or initialize the parameter
			if (exist) {
				// traverse the element from queue for previous context time
				while (!queue.isEmpty()) {
					System.out.println(queue.poll());
				}
				count = 0;
			}
			
			// once match found then repeat the activity to context times
			if ((exist || count != 0) && count <= context) {
				System.out.println(token);
				count++;
			} else {
				queue.offer(token);
				// if size cross from context length then remove it initial entry
				if (queue.size() > context) {
					queue.poll();
				}
			}
		}
	}
	
	public static void grepContextIndices(String[] tokens, int context, String searchText) {
		
		List<Integer> idxList = new ArrayList<>();
		
		for(int i=0;i<tokens.length;i++) {
			Boolean exists = tokens[i].startsWith(searchText);
			if(exists) {
				idxList.add(i);
			}
		}
		
		Set<Integer> numSet = new HashSet<>();
	   for(int num : idxList) {
		   numSet.add(num);
		   int bounds = context; 
		   while(bounds>0) {
			   int lb = num - bounds;
			   int rb = num + bounds;
			   if(lb>=0) {
				   numSet.add(lb);
			   }
			   if(rb<tokens.length) {
				   numSet.add(rb);
			   }
			   --bounds;
		   }
		   
	   }
	   
	   for(int i: numSet) {
		   System.out.println(tokens[i]);
	   }
	}
	
	public static void main(String[] args) {
		String[] tokens = { "apple", "cake", "bat", "bomb", "cat", "boredom", "dog", "dear"};
		Integer context = 1;
		String searchText = "bo";
		
		grepContext(tokens,context,searchText);
		System.out.println("---");
		System.out.println("---");
		grepContextIndices(tokens, context, searchText);
	}

}
