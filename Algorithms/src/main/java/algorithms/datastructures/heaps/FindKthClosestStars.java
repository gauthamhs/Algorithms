package algorithms.datastructures.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Star {
	private double x;
	private double y;
	private double z;

	Star(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	double distance() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	/*
	 * @Override public int compareTo(Star star2) { return
	 * Double.compare(this.distance(), star2.distance()); }
	 * 
	 * @Override public String toString() { return Double.toString(this.distance());
	 * }
	 */

}

public class FindKthClosestStars {

	// We try to identify the Kth Closest stars by its distance from the earth. For
	// each star,
	// we identify the distance and add them to the max heap based on the distance.
	// Since we
	// need the closest stars. we use max heap to remove stars farthest from the
	// sun.
	//

	public static List<Star> findKthClosestStars(List<Star> stars, int k) {

		int i = 0;
		
		  Comparator<Star> comp = (a,b) -> { 
			  return (int) (b.distance() - a.distance());
					  };
		 

		PriorityQueue<Star> maxHeap = new PriorityQueue<>(comp);

		while (i < stars.size()) {
			maxHeap.add(stars.get(i));
			if(maxHeap.size()>k) {
				maxHeap.remove();
			}
			++i;
		}

		return Stream.generate(maxHeap::remove).limit(maxHeap.size()).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Star star1 = new Star(1.1, 2.2, 3.3);
		Star star2 = new Star(1, 2, 3);
		Star star3 = new Star(0, 2, 3.3);
		Star star4 = new Star(2.1, 0.6, 1.2);
		Star star5 = new Star(3, 2.2, 4.3);

		List<Star> starList = new ArrayList<>();
		starList.add(star1);
		starList.add(star2);
		starList.add(star3);
		starList.add(star4);
		starList.add(star5);

		System.out.println(starList);

		List<Star> KthClosestStars = findKthClosestStars(starList, 3);
		System.out.println(KthClosestStars);

	}

}
