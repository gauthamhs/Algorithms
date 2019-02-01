package algorithms.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class BuildingWithHeight{
	public int id;
	public int height;
	
	public BuildingWithHeight(int id, int height) {
		this.id = id;
		this.height = height;
	}
}

public class SunsetBuilding {
	
	public static List<Integer> buildingsWithSunsetWtoE(List<Integer> buildings){
		
		List<Integer> buildingsWithaViewList = new ArrayList<>();
		
		if(buildings.isEmpty() || buildings == null) {
			return null;
		}
		
		
		int maximum = buildings.get(0);
		buildingsWithaViewList.add(maximum);
		
		for(int i=1;i<buildings.size();i++) {
			if(buildings.get(i)>maximum) {
				maximum = buildings.get(i);
				buildingsWithaViewList.add(maximum);
			}
		}
		
		return buildingsWithaViewList;
		
	}
	//EAST TO WEST
	
	public  static List<Integer> buildingWithASunsetEtoWStack(Iterator<Integer> sequence){
		
		Deque<BuildingWithHeight> heights = new ArrayDeque<>();
		int id = 0;
		
		while(sequence.hasNext()) {
			Integer buildingHeight = sequence.next();
			
			while(!heights.isEmpty() && Integer.compare(buildingHeight, heights.peekFirst().height)>=0) {
				heights.removeFirst();
			}
			
			heights.addFirst(new BuildingWithHeight(id++, buildingHeight));
			
		}
		
		return heights.stream().map(c -> c.id).collect(Collectors.toList());
		
		
	}
	
	public  static List<Integer> buildingWithASunsetWtoEStack(Iterator<Integer> sequence){
		
		Deque<BuildingWithHeight> heights = new ArrayDeque<>();
		int id = 0;
		
		if(!sequence.hasNext()) {
			return null;
		}
		
		Integer maximum = sequence.next();
		heights.addFirst(new BuildingWithHeight(id, maximum));
		
		while(sequence.hasNext()) {
			++id;
			
			Integer buildingHeight = sequence.next();
			if(buildingHeight>maximum) {
				maximum = buildingHeight;
				heights.addFirst(new BuildingWithHeight(id, maximum));
			}
			
		}
		return heights.stream().map(c -> c.id).collect(Collectors.toList());
		
		
	}
	
	public static void main(String[] args) {
		List<Integer> buildings = new ArrayList<>();
		buildings.add(3);
		buildings.add(6);
		buildings.add(5);
		buildings.add(4);
		buildings.add(10);
		buildings.add(9);
		buildings.add(11);
		
		List<Integer> buildingWithaView = buildingsWithSunsetWtoE(buildings); //WEST to EAST
		System.out.println(buildingWithaView);
		
		Iterator<Integer> sequence = buildings.iterator();
		
		List<Integer> sunsetViewEtoW = buildingWithASunsetEtoWStack(sequence);
		System.out.println(sunsetViewEtoW);
		
		Iterator<Integer> sequence2 = buildings.iterator();
		
		List<Integer> sunsetViewWtoE = buildingWithASunsetWtoEStack(sequence2);
		System.out.println(sunsetViewWtoE);
		
	}
	

}
