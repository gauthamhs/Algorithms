

package algorithms.datastructures.arrays.extras;

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
    