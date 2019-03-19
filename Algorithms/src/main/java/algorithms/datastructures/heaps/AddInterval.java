package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

public class AddInterval {
	
	// For this method, we try to add a new Interval to the list of already sorted Intervals.
	// Here is the algorithm:
	
	// 1) Add all the intervals where the endTime of previous intervals endTime is less than the new interval.
	// 2) If intervals overlap with new interval. Keep checking until the endTime of the interval is less than start time of
	// subsequent intervals
	// 3) Add the remaining intervals
	
	public static List<Interval> addInterval(List<Interval> intervals, Interval newInterval){
		List<Interval> result = new ArrayList<>();
		int i=0;
		
		//Add the non-overlapping intervals prior to the new interval.
		while(i<intervals.size() && newInterval.start>intervals.get(i).end) {
			result.add(intervals.get(i));
			++i;
		}
		
		// Add intervals overlapping with the new interval
		while(i<intervals.size() && newInterval.end>=intervals.get(i).start) {
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
			++i;
		}
		result.add(newInterval);
		
		// Add the remaining non-overlapping intervals
		
		result.addAll(intervals.subList(i, intervals.size()));
		
		return result;
	}
	
	public static void main(String[] args) {
						
		Interval interval1 = new Interval(1, 2);
		Interval interval2 = new Interval(3, 5);
		Interval interval3 = new Interval(6, 7);
		Interval interval4 = new Interval(8, 10);
		Interval interval5 = new Interval(12, 16);
		Interval newInterval = new Interval(4, 8);
						
		List<Interval> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);
		
		List<Interval> mergedIntervals = addInterval(intervals, newInterval);
		System.out.println(mergedIntervals);
	}
	

}
