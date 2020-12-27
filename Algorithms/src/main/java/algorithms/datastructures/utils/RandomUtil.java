package algorithms.datastructures.utils;

import java.util.Random;

public class RandomUtil {
	
	public static Integer getRandom(Integer min, Integer max) {
		
		return (int)(min + (Math.random()*(max-min+1)));
	}
	
	public static Integer getRandom() {
		Random random = new Random();
		Integer val = random.nextInt(1);
		return val;
	}
	
	public static void main(String[] args) {
		int min = 1;
		int max = 10;
		Integer random = getRandom(min,max);
		System.out.println(random);
		System.out.println(getRandom());
		
	}

}
