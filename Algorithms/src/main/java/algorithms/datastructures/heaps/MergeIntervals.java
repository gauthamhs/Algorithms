package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	// In this method we will output the disjoint intervals and merge the overlapping intervals.
	public static List<Interval> mergeIntervals(List<Interval> intervals){
		
		Comparator<Interval> startTimeComparator = Comparator.comparing((Interval interval)->interval.start);
		Collections.sort(intervals, startTimeComparator);
		
		if(intervals==null || intervals.isEmpty() || intervals.size()==1) {
			return intervals;
		}
		
		List<Interval> disjointIntervals = new ArrayList<>();
		
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		
		for(int i=1;i<intervals.size();i++) {
			if(intervals.get(i).start<=end) {
				start = Math.min(start, intervals.get(i).start);
				end = Math.max(end, intervals.get(i).end);
			} else {
				disjointIntervals.add(new Interval(start,end));
				start  = intervals.get(i).start;
				end  = intervals.get(i).end;
			}
		}
		
		disjointIntervals.add(new Interval(start, end));
		
		return disjointIntervals;
		
	}
	
	public static int eraseNonOverlappingIntervals(List<Interval> intervals) {
		
		if(intervals==null || intervals.isEmpty() || intervals.size()==1) {
			return 0;
		}
		
		int eraseNonOverlappingIntervals = 0;
		Comparator<Interval> comparatorForEndTime = Comparator.comparing((Interval i) -> i.end);
		intervals.sort(comparatorForEndTime);
		
		int endTime = intervals.get(0).end;
		for(int i=1;i<intervals.size();i++) {
			if(intervals.get(i).start<endTime) {
				++eraseNonOverlappingIntervals;
			} else {
				endTime = intervals.get(i).end;
			}
		}
		
		return eraseNonOverlappingIntervals;
	}
	
	public static void main(String[] args) {
		
		Interval interval1 = new Interval(1,3);
		Interval interval2 = new Interval(2,6);
		Interval interval3 = new Interval(8,10);
		Interval interval4 = new Interval(15,18);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		
		List<Interval> disjointIntervals = mergeIntervals(intervals);
		System.out.println(disjointIntervals);
				
		int nonOverLappingIntervals = eraseNonOverlappingIntervals(intervals);
		System.out.println(nonOverLappingIntervals);
		
	}

}
