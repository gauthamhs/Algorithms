package algorithms.datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Item{
	public int weight;
	public int value;
	
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}



public class KnapsackItem {
	
	// In the knapsack problem, we are given a list of items and we are trying to maximize profit by
	// putting the items for a given knapsack capacity.
	
	//Note: In bounded 0/1 knapsack, we assume that there is only one unique item. Therefore, when we include element,
	// we recursively include other elements. In unbounded knapsack, we include the item in the recursion.
	// In short, we use currentIndex - 1 for bounded and currentIndex for unbounded.
	
	//Method1: Naive Recursion
	// Space Complexity: O(n), 
	// Time Complexity: O(2^n);
	
	public static int maximumProfitFromKnapSackNaive(List<Item> items, int capacity) {
		
		if(items.size()==0 || capacity==0) {
			return 0;
		}
		return maximumProfitFromKnapSackHelper(items, capacity, items.size()-1);	
	}
	
	public static int maximumProfitFromKnapSackHelper(List<Item> items, int capacity, int n) {
		if(n<0 || capacity==0) {
			return 0;
		}
		
		int profitWithoutItem = maximumProfitFromKnapSackHelper(items, capacity, n-1);
		int profitWithItem = (items.get(n).weight>capacity) ? 0 : items.get(n).value + maximumProfitFromKnapSackHelper(items, capacity-items.get(n).weight, n-1);
		
		int totalProfit = Math.max(profitWithoutItem, profitWithItem);
		
		return totalProfit;
		
	}
	
	//Method 2: Memoization
	// Space Complexity: O(nC), 
	// Time Complexity: O(nC);
	
	public static int maximumProfitFromKnapSackMemoize(List<Item> items, int capacity) {
		
		if(items.size()==0 || capacity==0) {
			return 0;
		}
		
		Integer[][] memoize = new Integer[items.size()][capacity+1];
		return maximumProfitFromKnapSackMemoizeHelper(items, capacity, items.size()-1, memoize);
	}
	
	public static int maximumProfitFromKnapSackMemoizeHelper(List<Item> items, int capacity, int n, Integer[][] memoize) {
		if(n<0|| capacity==0) {
			return 0;
		}
		
		if(memoize[n][capacity]==null) {
			
			int profitWithoutItem = maximumProfitFromKnapSackMemoizeHelper(items, capacity, n-1, memoize);
			int profitWithItem = (items.get(n).weight>capacity) ? 
					0 : items.get(n).value + maximumProfitFromKnapSackMemoizeHelper(items, capacity - items.get(n).weight , n-1, memoize);
			
			memoize[n][capacity] = Math.max(profitWithoutItem, profitWithItem);
		}
		
		return memoize[n][capacity];
	}
	
	//Method 3: BottomDown: In this method, we solve the problem with prior solutions of the subproblems. 
	// No recursion is used here.
	// Space Complexity: O(nC), 
	// Time Complexity: O(nC);
	public static int maximumProfitFromKnapSackBottomUp(List<Item> items, int capacity) {
		
		if(items.size()==0 || capacity==0) {
			return 0;
		}
		
		int n = items.size()-1;
		int[][] profitMatrix = new int[items.size()][capacity+1];
		
		// For Capacity 0, we cannot have profits, So we need to initialize them to 0;
		for(int i=0;i<=n;i++) {
			profitMatrix[i][0] = 0;
		}
		
		// If there is only one item, the profit would be the profit of item if its less than or equal to capacity.
		for(int j=0;j<=capacity;j++) {
			if(items.get(0).weight<=j) {
				profitMatrix[0][j] =  items.get(0).value;
			}
		}
			
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=capacity;j++) {
				int profitWithoutItem = profitMatrix[i-1][j];
				int profitWithItem = (items.get(i).weight>j) ? 0: items.get(i).value + profitMatrix[i-1][j-items.get(i).weight];
				
				profitMatrix[i][j] = Math.max(profitWithoutItem, profitWithItem);
			}
		}
		return profitMatrix[n][capacity];
		}
	
	public static int knapsack(List<Item> items, int capacity) {
		if(items.size()==0) {
			return 0;
		}
		return knapsackHelper(items, capacity, 0);
	}
	
	public static Integer knapsackHelper(List<Item> items, int capacity, int currentIndex) {
		if(capacity<=0 || items.size()<=currentIndex) {
			return 0;
		}
		
		
		Integer excludeItem =  knapsackHelper(items,capacity,currentIndex+1);
		Integer includeItem = (items.get(currentIndex).weight>capacity) ? 0 : items.get(currentIndex).value + knapsackHelper(items,capacity-items.get(currentIndex).weight,currentIndex+1);
		return Math.max(excludeItem, includeItem);
	}

	
	public static void main(String[] args) {
		
		Item item1 = new Item(2, 4);
		Item item2 = new Item(3, 5);
		Item item3 = new Item(1, 3);
		Item item4 = new Item(4, 7);
		
		List<Item> items1 = new ArrayList<>();
		items1.add(item1);
		items1.add(item2);
		items1.add(item3);
		items1.add(item4);
		
		Item item5 = new Item(1, 1);
		Item item6 = new Item(2, 6);
		Item item7 = new Item(3, 10);
		Item item8 = new Item(5, 16);
		
		List<Item> items2 = new ArrayList<>();
		items2.add(item5);
		items2.add(item6);
		items2.add(item7);
		items2.add(item8);
		
		int profit = maximumProfitFromKnapSackNaive(items1, 5);
		int profit2 = maximumProfitFromKnapSackNaive(items2, 7);
		System.out.println("Maximum Profit Naive 1: " + profit);
		System.out.println("Maximum Profit Naive 2: " +profit2);
		
		int profitMemoize = maximumProfitFromKnapSackMemoize(items1, 5);
		int profit2Memoize = maximumProfitFromKnapSackMemoize(items2, 7);
		System.out.println("Maximum Profit Memoize 1: " + profitMemoize);
		System.out.println("Maximum Profit Memoize 2: " + profit2Memoize);
		
		int profitBottomUp = maximumProfitFromKnapSackBottomUp(items1, 5);
		int profit2BottomUp = maximumProfitFromKnapSackBottomUp(items2, 7);
		System.out.println("Maximum Profit BottomUp 1: " + profitBottomUp);
		System.out.println("Maximum Profit BottomUp 2: " + profit2BottomUp);
		
		int profit3 = knapsack(items1, 5);
		int profit4 = knapsack(items2, 7);
		System.out.println("Maximum Profit BottomUp 1: " + profit3);
		System.out.println("Maximum Profit BottomUp 2: " + profit4);
		
		
		
	}

}
