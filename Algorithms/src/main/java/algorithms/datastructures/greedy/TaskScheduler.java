package algorithms.datastructures.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*In this algorithm, we are given a set of tasks that need to run and a cooldown period
For example, If we are given tasks as {A,A,A,B,B,B} and n(cooldown period) =2, 
We can arrange it such that A->B>idle->A->B->idle->A->B
if we have cooldown period of n between tasks, we can greedily pick the largest task along with 2
other tasks. So we can pick n+1 tasks at a time. We have two situations here:
1) Either heap is empty: in which case we return current tasks in list, if not we add n+1 to our total cycle list
*/
public class TaskScheduler {
	
    public static int leastInterval(char[] tasks, int n) {
        
    	// If there is no cooldown, tasks can run without any idle period
        if(n==0){
            return tasks.length;
        }
        
     // Count the total occurrence of individual tasks so that we can add it to max heap
//        Map<Character, Integer> charMap = new HashMap<>();
//        for(char c : tasks) {
//        	charMap.put(c, charMap.getOrDefault(c, 0)+1);
        
 
//        }
        
        Map<Character, Long> charMap =  IntStream.range(0, tasks.length).mapToObj(i-> tasks[i]).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                
     // Get the task with the largest occurrence for greedy pickings
        Comparator<Character> cmp = (a,b)->Long.compare(charMap.get(b), charMap.get(a));
		PriorityQueue<Character> maxHeap = new PriorityQueue<>(cmp);
        maxHeap.addAll(charMap.keySet());
        
        int totalCycles = 0;

     // Run cycle until max heap is empty
        while(!maxHeap.isEmpty()) {
        	
        	List<Character> currentCycle = new ArrayList<>();
        	
        	// Grab n+1 cycles and add it to the processing list
        	for(int i=0;i<n+1;i++) {
        		
        		if(!maxHeap.isEmpty()) {
            		Character c = maxHeap.remove();
            		charMap.put(c, charMap.get(c)-1);
            		currentCycle.add(c);
        		}

        	}
        	
        	//if a task is completely processed, don't add it back to heap
        	for(Character c : currentCycle) {
        		if(charMap.get(c)>0) {
        			maxHeap.add(c);
        		}
        	}
        	
            // Add n+1 cycle if heap is not empty because we still have tasks to process.
            // if its empty, just add the current processed cycle
        	totalCycles+=maxHeap.isEmpty() ? currentCycle.size() : n+1;
        	
        }
        
        return totalCycles;
        
    }
    
    public static void main(String[] args) {
		char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'}; int n = 2;
		Integer interval1 = leastInterval(tasks, n);
		System.out.println(interval1);
	}

}
