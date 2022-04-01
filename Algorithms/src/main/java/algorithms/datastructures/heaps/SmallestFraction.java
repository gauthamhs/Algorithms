package algorithms.datastructures.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestFraction {
	
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        if(arr==null ||arr.length==0){
            return new int[0];
        }
        
        
        Map<String, Double> fractionMap = new HashMap<>();
        
        Comparator<String> cmp = (a,b) -> {
          return Double.compare(fractionMap.get(b), fractionMap.get(a));
        };
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                StringBuilder sb = new StringBuilder("");
                sb.append(arr[i]).append("/").append(arr[j]);
                fractionMap.putIfAbsent(sb.toString(), (double)arr[i]/(double)arr[j]);
            }
        }
        
        
        PriorityQueue<String> maxHeap = new PriorityQueue<>(k, cmp);
        
        maxHeap.addAll(fractionMap.keySet());
        
        while(k>0){
             maxHeap.remove();
            --k;
        }
        String val = maxHeap.peek();
        String[] split = val.split("\\/");
        int[] result = new int[2];
        result[0] = Integer.valueOf(split[0]);
        result[1] = Integer.valueOf(split[1]);
        
        return result;
        
    }
    
    public static void main(String[] args) {
		int[] arr = {1,7};
		int k=1;
		System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
	}

}
