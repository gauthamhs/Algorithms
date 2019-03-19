package algorithms.sort.extras;

public class SearchForFirstOccurrenceOfK {
	
	public static int firstOccurrenceofKey(int[] array, int key) {
		int low = 0;
		int high = array.length-1;
		int result = -1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(array[mid]==key) {
				result = mid;
				high = mid-1;
			} else if(array[mid]>key) {
				high = mid-1;
			} else if(array[mid]<key) {
				low = mid + 1;
			}
		}
		
		return result;
	}
	
	public static int lastOccurrenceofKey(int[] array, int key) {
		int low = 0;
		int high = array.length-1;
		int result = -1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(array[mid]==key) {
				result = mid;
				low = mid+1;
			} else if(array[mid]>key) {
				high = mid-1;
			} else if(array[mid]<key) {
				low = mid + 1;
			}
		}
		
		return result;
	}
	
	public static int bothOccurrenceofKey(int[] array, int key) {
		int low = 0;
		int high = array.length-1;
		int result = -1;
		int a = -1;
		int b = -1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(array[mid]==key) {
				a= mid;
				b=mid;
				while(array[mid]==array[mid-1]) {
					--a;
					mid--;
				}
				
				while(array[mid]==array[mid+1]) {
					++b;
					mid++;
				}
				break;
				
				
			} else if(array[mid]>key) {
				high = mid-1;
			} else if(array[mid]<key) {
				low = mid + 1;
			}
		}
		System.out.println(a);
		System.out.println(b);
		return a+b-1;
	}
	
	public static int firstOccurrenceGreaterThanKey(int[] array, int key) {
		int low = 0;
		int high = array.length-1;
		int result = -1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(array[mid]==key) {
				low = mid+1;
			} else if(array[mid]>key) {
				result = mid;
				high = mid-1;
			} else if(array[mid]<key) {
				low = mid + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] array = {-14,-10,2,108,108,243,285,285,285,401};
		int firstOccurrence = firstOccurrenceofKey(array, 285);
		int lastOccurrence = lastOccurrenceofKey(array, 285);
		int bothOccurrence = bothOccurrenceofKey(array, 285);
		
		System.out.println(firstOccurrence);
		System.out.println(lastOccurrence);
		System.out.println(bothOccurrence);
		int firstOccurrenceGreaterThanKey = firstOccurrenceGreaterThanKey(array, -13);
		System.out.println(firstOccurrenceGreaterThanKey);
	}

}
