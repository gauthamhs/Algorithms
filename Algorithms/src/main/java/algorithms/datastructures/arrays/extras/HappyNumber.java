

package algorithms.datastructures.arrays.extras;


//A happy number is a number defined by the following process: Starting with any positive integer, 
//replace the number by the sum of the squares of its digits, and repeat the process until the number 
//equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
//Those numbers for which this process ends in 1 are happy numbers.
//Return True if n is a happy number, and False if not.

//Input: 19
//Output: true
//Explanation: 
//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 82 = 100
//1^2 + 0^2 + 0^2 = 1

public class HappyNumber {
    
    public static boolean isHappy(int n) {
        
        int sum = 0;
        
        if(n==1){
            return true;
        }
        
        if(n<1 || n==4){
            return false;
        }
        
        while(n!=0){
            sum += (n%10) * (n%10);
            n /= 10;
        }
        
        return isHappy(sum);
        
    }
    
    public static void main(String[] args) {
		boolean isHappy = isHappy(7);
		System.out.println(isHappy);
	}
}
    