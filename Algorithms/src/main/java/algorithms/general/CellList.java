package algorithms.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CellList
{        
 public static List<Integer> cellCompete(int[] states, int days)
 {
     int length = states.length;
     List<Integer> cellList = new ArrayList<>(Collections.nCopies(length, 0));
     for(int i=0;i<length;i++) {
    	 cellList.set(i, states[i]);
     }
     while(days-->0){
    	 
    	cellList.set(0, 0^states[1]);
    	cellList.set(length-1, 0^states[length-2]);
        for(int i=1;i<length-1;i++){
                cellList.set(i,states[i+1]^states[i-1]);
            }
        }
     for(int i=0;i<length;i++) {
    	 states[i] = cellList.get(i);
     }
     
     
     return cellList;
     
 }
 
 public static void main (String[] args) {
     int[] states = {0,1,1,0,1,0,0,1};
     int days = 3;
     List<Integer> cells = cellCompete(states, days);
     System.out.println(cells);
 }

}
