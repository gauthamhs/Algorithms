package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvenOdd {
	
	public static List<Integer> evenOddFunctional(List<Integer> numList){
		List<Integer> evenNumbers = numList.stream().filter(num -> num%2==0)
				.collect(Collectors.toList());
		List<Integer> oddNumbers = numList.stream().filter(num -> num%2==1)
				.collect(Collectors.toList());
		System.out.println(evenNumbers);
		System.out.println(oddNumbers);
		List<Integer> orderedList = Stream.of(evenNumbers,oddNumbers)
				                    .flatMap(List::stream).collect(Collectors.toList());
		return orderedList;
		
	}
	
	public static List<Integer> evenOddStructured(List<Integer> numList){
		
		int i=0;
		int j=numList.size()-1;
		
		while(i<j) {
			if(numList.get(i)%2==0) {
				++i;
			}else {
				Collections.swap(numList, i, j);
				--j;
			}
		}
		
		return numList;
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(1,3,4,2,7,9,6);
		numbers = new ArrayList<>(numbers);
		System.out.println(evenOddFunctional(numbers));
		System.out.println(evenOddStructured(numbers));
		
		
		
		
	}

}
