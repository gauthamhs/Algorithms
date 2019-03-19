package algorithms.datastructures.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Interval{
	int start;
	int end;
	
	Interval(){
		
	}
	
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return this.start + " " + this.end;
	}
}

public class MeetingTimes {
	
	//For this problem, we need to identify the minimum no. of meeting rooms required for conference calls. 
	// Key Takeaways: 
	
	// 1) We sort startTimes in ascending order since we are interested in the meetings earlier in the day to evening meetings.
	// 2) Next, we try to identify if two meetings overlap. We do this by checking the start time of the next meeting with the earliest
	// end time of the previous meetings. If its not available, then no other rooms are available. So, we Book a new room.
	// 3) If the meetings dont overlap, we use the same meeting room for our conference. However, we replace the current end time with
	// the new endTime since the previous meeting ended.
	// 4) We can use MinHeap to record the earliest end time by using a priorityQueue.
	
    public static int minMeetingRooms(Interval[] intervals) {
    	
        if(intervals==null || intervals.length==0){
            return 0;
        }
    	

    	//Arrays.sort(intervals, (o1,o2) -> o1.start - o2.start);
    	Comparator<Interval> startTimeComparator = Comparator.comparing((Interval interval) -> interval.start);
    	Arrays.sort(intervals, startTimeComparator);
    	
    	int count = 1;
    	
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	minHeap.add(intervals[0].end);
    	for(int i =1;i<intervals.length;i++) {
    		int earliestEndTime = minHeap.peek();
    		if(intervals[i].start>=earliestEndTime) {
    			minHeap.poll();
    		} else {
    			count++;
    		}
    		minHeap.add(intervals[i].end);
    	}
    	
    	
    	return count;
        
    }
    
    public static boolean canAttendMeetings(Interval[] intervals) {
    	
    	Comparator<Interval> comparatorByStartTime = Comparator.comparing((Interval interval) -> interval.start);
    	Arrays.sort(intervals, comparatorByStartTime);
    	
    	for(int i=0;i<intervals.length-1;i++) {
    		if(intervals[i].end>intervals[i+1].start) {
    			return false;
    		}
    	}
    	
    	return true;
    }
	
	public static void main(String[] args) {
		Interval interval1= new Interval(0, 30);
		Interval interval2= new Interval(5, 10);
		Interval interval3= new Interval(15, 20);
		
		Interval[] intervals1 = {interval1, interval2, interval3};
		int minMeetingsRequired1 = minMeetingRooms(intervals1);
		System.out.println(minMeetingsRequired1);
		
		Interval interval4= new Interval(7, 10);
		Interval interval5= new Interval(2, 4);
		Interval[] intervals2 = {interval4, interval5};
		boolean canAttendMeetings = canAttendMeetings(intervals2);
		System.out.println(canAttendMeetings);
			
	}

}
