package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {
	
	    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
	        ArrayList<Worker> list = new ArrayList<>();
	        for(int i=0; i<wage.length; i++){
	            list.add(new Worker(quality[i], wage[i]));
	        }
	        Comparator<Worker> comp = Comparator.comparing((Worker w) -> w.ratio);
	        Collections.sort(list, comp);
	 
	        PriorityQueue<Integer> q = new PriorityQueue<>();
	        int sum = 0;
	        double result = Integer.MAX_VALUE;
	 
	        for(int i=0; i<list.size(); i++){
	            Worker w = list.get(i);
	            sum += w.quality;
	            q.offer(-w.quality);
	 
	            if(q.size()>K){
	                int extra = q.poll();
	                sum += extra;
	            }
	 
	            if(q.size() == K){
	                result = Math.min(result, sum * w.ratio);        
	            }
	        }
	 
	        return result;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	int[] quality = {10,20,5};
	    	int K =2;
	    	int[] wage = {70,50,30};
			double val = mincostToHireWorkers(quality, wage, K);
			System.out.println(val);
		}
	}


	 
	class Worker{
	    int quality;
	    int wage;
	    double ratio;
	 
	    public Worker(int q, int w){
	        this.quality = q;
	        this.wage = w;
	        this.ratio = (double)w/q;
	    }
	}


