package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeHierarchy2 {
	
	public static void printHierarchy(List<String> employees) {
		Map<Integer, List<Integer>> hierarchyMap = new HashMap<>();
		Map<Integer, String> nameMap = new HashMap<>();
		
		
		for(String employee:employees) {
			String[] splits = employee.split("\\:");
			Integer id = Integer.valueOf(splits[0]);
			String name = splits[1];
			Integer reportsTo = Integer.valueOf(splits[2]);
			
			hierarchyMap.putIfAbsent(reportsTo, new ArrayList<>());
			hierarchyMap.get(reportsTo).add(id);
			nameMap.put(id,  name);
			
		}
		
		
		Integer primaryId = hierarchyMap.get(0).get(0);
		dfs(hierarchyMap,nameMap,primaryId,0);
		
	}
	
	public static void dfs(Map<Integer, List<Integer>> hierarchyMap, Map<Integer, String> nameMap, Integer id, Integer level) {
		
		
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0;i<level;i++) {
			sb.append("-");
		}
		
		if(level>0) sb.append(" ");
		
		sb.append(nameMap.get(id));
		System.out.println(sb.toString());
		
		if(!hierarchyMap.containsKey(id)) return;
		
		List<Integer> ids = hierarchyMap.get(id);
		
		for(Integer val : ids) {
			dfs(hierarchyMap, nameMap, val, level+1);
		}
		
	}
	
	public static void main(String[] args) {
		List<String> employees = Arrays.asList("2:Anne:0","1:Max:2","4:Jim:3","3:Theraus:2","5:Hose:1");
		printHierarchy(employees);
	}

}
