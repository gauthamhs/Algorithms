// Linear search is an algorithm used to find a value within a list.
// In this class, we are going to implement some linear search algorithms(least effective - most effective)
// Implementations include classic linear search, Better-Linear-Search, and Sentinel Linear Search

package algorithms.search;

public class LinearSearch {
	
	/*Implementation 1: In our first implementation, we just iterate through the entire list even after
	  we find the value that we are looking for, this is the least efficient algorithm in linear search 
	 Complexity: 2*N + 1 
	 */
	
	public String linearSearch(int[] integerArray, int value){
		
		String foundItem = "Item not found";
		for (int i = 0; i < integerArray.length; i++){
			if(integerArray[i]==value){
				foundItem = "Item found @ index " + i;
			} 
		}
		return foundItem;	
	}
	
	/*Implementation 2: Better linear search is a improved version of the classic linear search algorithm. 
	 Here, we return the item as soon as it we find it in the list instead of searching the entire list.
	 Complexity: There is no accurate way of telling the complexity as we are returning the element as soon
	 as we find it in the list and not iterating through the entire array
	 Worst Possible Case: O[n]
	 Best possible Case: O[1]
	 */
	
	public String betterLinearSearch(int[] integerArray, int value){
		
		for (int i = 0; i < integerArray.length; i++){
			if(integerArray[i]==value){
				return "Item found @ index " + i;
			} 
		}
		return "Item not found"; 
		}
	
	
	/*Implementation 3: Sentinel Linear Search is one of the most efficient linear searches. 
	 The idea with sentinel search is to keep the element to be searched in the end, and to skip the array index searching, 
	 this will reduce one comparison in each iteration. 
	 This would also improve the rate of growth by a constant factor.
	 
	 Complexity = N + 2;
	 */
	public String sentinelLinearSearch(int[] integerArray, int value){
		
		int lastElementIndex = integerArray.length-1;
		int temp = integerArray[lastElementIndex]; // We save the last element so that we can add it back later.
		integerArray[lastElementIndex] = value; // we put the value to be searched as the last element.
		int i=0;
		while(integerArray[i]!=value){
			i++;
		}
		
		integerArray[lastElementIndex] = temp; // Adding the last element back to the array.
		
/*		First,We are checking if the value exists in the list(except the last item) and then we are checking if 
		the value in the last element was indeed the value that we were searching for.*/
		
		if(i<lastElementIndex || integerArray[i]==value){ 
			return "Item found @ index " + i;
		}
		
		return "Item not found";
		}
	
}




