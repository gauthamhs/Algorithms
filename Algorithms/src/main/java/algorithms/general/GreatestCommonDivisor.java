package algorithms.general;

/*In this method, we will find the Greatest Common divisor that is the greatest common factor 
of both the numbers;*/

public class GreatestCommonDivisor {
	
	public static int greatestCommonDivisorIteration(int a, int b) {
		int temp = 0;
		while(a!=0 && b!=0) {
			temp = b;
			b = a%b;
			a = temp;
		}
		return a+b;
	}
	
	public static int greatestCommonDivisorRecursion(int a, int b) {
		if(a==0 || b==0) {
			return a+b;
		}
		return greatestCommonDivisorRecursion(b, a%b);
	}
	
	public static int greatestCommonDivisorList(int[] list) {
		int result = list[0];
		for(int i =1;i<list.length;i++) {
			result =  greatestCommonDivisorIteration(list[i], result%list[i]);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int a = 24;
		int b = 54;
		System.out.println(greatestCommonDivisorIteration(a, b));
		System.out.println(greatestCommonDivisorRecursion(a, b));
		int[] list = {2,4,6,10,12};
		System.out.println(greatestCommonDivisorList(list));
	}
	
	
	

}
