package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrecisionMultiplication {

	
	public static List<Integer> precisionMultiplication(List<Integer> arr1, List<Integer> arr2){
		//12
		//98
		// 1176
		
		if(arr1.isEmpty() || arr1.isEmpty()) {
			return Arrays.asList(0);
		}
		
		int arrayOneLength = arr1.size() - 1;
		int arrayTwoLength = arr2.size() - 1;
		int sign = (arr1.get(0)<0) ^ (arr2.get(0)<0) ? -1:1;
		List<Integer> result = new ArrayList<>(Collections.nCopies(arr1.size() + arr2.size(), 0));
		
		for(int i = arrayOneLength;i>=0;i--) {
			for(int j = arrayTwoLength;j>=0;j--) {
				result.set(i+j+1, result.get(i+j+1) + (arr1.get(i)*arr2.get(j)));
				result.set(i+j, result.get(i+j) + result.get(i+j+1)/10);
				result.set(i+j+1,result.get(i+j+1)%10);
			}
		}
			
		//Remove leading zeros
			
        int noLeadingZeros = 0;
        while(noLeadingZeros<result.size() && result.get(0)==0) {
        	noLeadingZeros++;
        }
        
        result = result.subList(noLeadingZeros, result.size());
        
        if(result.isEmpty()) {
        	return Arrays.asList(0);
        }
		
        result.set(0, sign*result.get(0));
		
		return result;
		
	}
	
	public static void main(String[] args) {
		List<Integer> array1 = new ArrayList<>();
		List<Integer> array2 = new ArrayList<>();
		array1.add(1);
		array1.add(2);
		array2.add(9);
		array2.add(8);
		List<Integer> multiplicatedList = precisionMultiplication(array1, array2);
		System.out.println(printArray(multiplicatedList));
	}
	
	public static String printArray(List<Integer> sortedList){

		StringBuilder sb = new StringBuilder("");
		for(Integer i: sortedList){
		sb.append(i);
		}
		return sb.toString();

		}
}
