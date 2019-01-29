package algorithms.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;

public class DeliveryTrucks
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
   public static List<List<Integer>> ClosestXdestinations(int numDestinations, 
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
	{
        
        List<List<Integer>> closestXdestinations = new ArrayList<>();
        Map<List<Integer>, Integer> squareRootMap = new HashMap<>();
        LinkedHashMap<List<Integer>, Integer> squareRootMapSorted = new LinkedHashMap<>();
        
        
        
        for(int i=0;i<allLocations.size();i++){
            List<Integer> singleLocation = allLocations.get(i);
            int x = singleLocation.get(0);
            int y = singleLocation.get(1);
            int distance = distance(x, y);
            squareRootMap.put(singleLocation, distance);
        }
        
        squareRootMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(
            x -> squareRootMapSorted.put(x.getKey(), x.getValue()));

            
           for(HashMap.Entry<List<Integer>, Integer> entry: squareRootMapSorted.entrySet()){
               List<Integer> key = entry.getKey();
               closestXdestinations.add(key);
               System.out.println(entry);
           }
           
        return closestXdestinations.subList(0,numDeliveries);
    }
    
    public static int distance(int x, int y){
        return Math.abs(x^2) + Math.abs(y^2);
    }

   public static void main(String[] args) {
	   int numDeliveries = 2;
	   int numDestinations = 3;
	   List<List<Integer>> allLocations = new ArrayList<>();
	   List<Integer> location1 = new ArrayList<>();
	   location1.add(-2);
	   location1.add(3);
	   List<Integer> location2 = new ArrayList<>();
	   location2.add(1);
	   location2.add(2);
	   List<Integer> location3 = new ArrayList<>();
	   location3.add(2);
	   location3.add(4);
	   allLocations.add(location1);
	   allLocations.add(location2);
	   allLocations.add(location3);
	   
	List<List<Integer>> cDest = ClosestXdestinations(numDestinations, allLocations, numDeliveries);
	System.out.println(cDest);
}
    
}