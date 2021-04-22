package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {
	
	public enum COLOR {
		
	RED(0),BLUE(1),WHITE(2);
		
	private final int value;
		
	private COLOR(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	}
	
	public List<COLOR> dutchNationalFlagSort(List<COLOR> color, int pivotIndex){
		int low = 0;
		int mid = 0;
		int high = color.size()-1;
		int pivot = color.get(pivotIndex).getValue();
		
		
		while(mid<high) {
			if(color.get(mid).getValue() < pivot) {
				Collections.swap(color, low++, mid++);
			} else if(color.get(mid).getValue() == pivot) {
				mid++;
			} else {
				Collections.swap(color, mid, high--);
			}
		}
		return color;
		
		
		
	}
	
	public static int[] dNF(int[] nums) {
		
		int i=0;
		int low=0;
		int high = nums.length-1;
		
		while(i<high) {
			switch(nums[i]) {
			case 0: swap(nums,i,low);
			        i++;low++;break;
			
			case 1: i++;
			        break;
			    
			case 2: swap(nums, i, high);
			        high--;break;
			        
			}
		}
		
		return nums;
	}
	
	public static void swap(int[] nums,int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
		List<Integer> integerArray = new ArrayList<>();
		
		List<COLOR> colors = new ArrayList<>();
		colors.add(COLOR.RED);
		colors.add(COLOR.BLUE);
		colors.add(COLOR.BLUE);
		colors.add(COLOR.WHITE);
		colors.add(COLOR.RED);
		colors.add(COLOR.RED);
		colors.add(COLOR.WHITE);
		colors.add(COLOR.WHITE);
		colors.add(COLOR.BLUE);

		int[] intArray = {0,2,1,2,1,2,2,2,1,1,1};
		for (int i : intArray) {
			integerArray.add(i);
		}
		int pivot = 8;
		List<COLOR> sortedList = dutchNationalFlag.dutchNationalFlagSort(colors, pivot);
		System.out.println(pivot);
		
		System.out.println(printArray(sortedList));
		
		System.out.println(Arrays.toString(dNF(intArray)));
	}
	

	public static String printArray(List<COLOR> sortedList){

		StringBuilder sb = new StringBuilder("");
		for(int i = 0;i<=sortedList.size()-1;i++){
		sb.append(sortedList.get(i));
		if(i<sortedList.size() - 1){
		sb.append(", ");
		}
		}
		return sb.toString();

		}
	
	
}
