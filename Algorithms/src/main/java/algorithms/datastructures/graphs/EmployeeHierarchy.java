package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee{
	
	Integer employeeId;
	String employeeName;
	Integer reportsTo;
	
	public Employee() {
		
	}
	
	public Employee(Integer employeeId, String employeeName, Integer reportsTo) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.reportsTo = reportsTo;
	}
	
}


public class EmployeeHierarchy {
	
	
	public static void printHierarchy(List<String> employees) {
		
		Map<Integer, String> nameMap = new HashMap<>();
		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
		List<Employee> employeeList = new ArrayList<>();
	
		for(String employee : employees) {
			String[] splits = employee.split("\\:");
			Employee user = new Employee(Integer.valueOf(splits[0]),splits[1],Integer.valueOf(splits[2]));
			employeeList.add(user);
		}
		
		for(Employee emp : employeeList) {
			nameMap.put(emp.employeeId, emp.employeeName);
			adjacencyList.putIfAbsent(emp.reportsTo, new ArrayList<>());
			adjacencyList.get(emp.reportsTo).add(emp.employeeId);
		}
		
		Integer primaryUser = adjacencyList.get(0).get(0);
		dfs(adjacencyList, nameMap, 0, primaryUser);
		
	}
	
	public static void dfs(Map<Integer, List<Integer>> adjacencyList, Map<Integer, String> nameMap, Integer level, Integer userId) {
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<level;i++) {
			sb.append("-");
		}
		
		sb.append(" ").append(nameMap.get(userId));
		System.out.println(sb.toString());
		
		if(!adjacencyList.containsKey(userId)) {
			return ;
		}
		
		for(Integer user : adjacencyList.get(userId)) {
			dfs(adjacencyList, nameMap, level + 1, user);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		List<String> employees = Arrays.asList("2:Anne:0","1:Max:2","4:Jim:3","3:Theraus:2","5:Hose:1");
		printHierarchy(employees);
		
	}

}
