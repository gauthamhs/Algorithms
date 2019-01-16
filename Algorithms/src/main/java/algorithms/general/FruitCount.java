package algorithms.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitCount {
	
	public static String getFruitCount(List<String> fruits) {
		
		if(fruits.isEmpty()) {
			return "Fruit Basket is Empty";
		}
		Map<String, Integer> fruitMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(String fruit : fruits) {
			if(fruitMap.containsKey(fruit)) {
				 int fruitCount = fruitMap.get(fruit);
				 fruitMap.put(fruit, ++fruitCount);
			} else { 
				fruitMap.put(fruit, 1);
			}
		}
		
		for(Map.Entry<String, Integer> entries: fruitMap.entrySet() ) {
			String fruit = entries.getKey();
			Integer count = entries.getValue();
			
			sb.append(fruit + ": " + count + "\n");
			
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<String>();
		fruits.add("Oranges");
		fruits.add("Apples");
		fruits.add("Oranges");
		fruits.add("Mangoes");
		fruits.add("Oranges");
		fruits.add("Pineapple");
		fruits.add("Mangoes");
		fruits.add("Plum");
		fruits.add("Plum");
		
		String fruitCount = getFruitCount(fruits);
		System.out.println(fruitCount);
		
	}


} 
