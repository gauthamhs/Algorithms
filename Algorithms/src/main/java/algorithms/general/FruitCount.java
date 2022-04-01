package algorithms.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitCount {
	
	public static String getFruitCount(List<String> fruits) {
		
		if(fruits.isEmpty()) {
			return "Fruit Basket is Empty";
		}
		
		StringBuilder sb = new StringBuilder();
		Map<String, Long> fruitMap = fruits.stream()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		for(Map.Entry<String, Long> entries: fruitMap.entrySet() ) {
			String fruit = entries.getKey();
			Long count = entries.getValue();
			
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
