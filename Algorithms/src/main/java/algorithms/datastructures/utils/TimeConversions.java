package algorithms.datastructures.utils;

import java.util.concurrent.TimeUnit;

public class TimeConversions {
	
	public static void getTimes(Long timeInMillis) {
		
		
		Long seconds =  TimeUnit.MILLISECONDS.toSeconds(timeInMillis);
		Long minutes =  TimeUnit.MILLISECONDS.toMinutes(timeInMillis);
		Long hours =    TimeUnit.MILLISECONDS.toHours(timeInMillis);
		Long days =     TimeUnit.MILLISECONDS.toDays(timeInMillis);
		Long day = days%7;
		
		Long millisInSeconds = timeInMillis/1000;
		Long millisInMinutes = millisInSeconds/60;
		Long millisInHours = millisInMinutes/60;
		Long millisIndays = millisInHours/24;
		Integer millisInday = (int) (millisIndays%7);
		
		System.out.println(seconds);
		System.out.println(minutes);
		System.out.println(hours);
		System.out.println(days);
		System.out.println(day);
		
		System.out.println();
		
		System.out.println(millisInSeconds);
		System.out.println(millisInMinutes);
		System.out.println(millisInHours);
		System.out.println(millisIndays);
		System.out.println(millisInday);
		
		
	}
	
	
	public static void main(String[] args) {
	
		Long timestampInMillis = 1612339471L;
		getTimes(timestampInMillis);
		
		
		
	}

}
