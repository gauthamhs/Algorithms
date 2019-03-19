package test.algorithms.general;

import org.junit.Before;
import org.junit.Test;

import algorithms.general.Rectangle;
import algorithms.general.RectangleOverlap;

public class TestGeneral {
	
	private RectangleOverlap rectangleOverlap;
	
	
	@Before
	public void setup(){
	rectangleOverlap = new RectangleOverlap();
	
	}

	@Test
	public void testRectangleOverlapSuccess() {
		
		Rectangle r1 = new Rectangle(1, 2, 4, 3);
		Rectangle r2 = new Rectangle(3,1, 2, 2);
		Rectangle intersectingRectangle = rectangleOverlap.intersectingRectangle(r1, r2);
		
		boolean isRectangleOverlap = rectangleOverlap.isRectangleOverlap(r1, r2);
		System.out.println("Are the two rectangles Overlapping?: " + isRectangleOverlap);
		System.out.println("Intersecting Rectangle{ x-coordinate: " + intersectingRectangle.x + ", y-coordinate: " + intersectingRectangle.y
				 + ", height: " + intersectingRectangle.height + ", width: " + intersectingRectangle.width);
		
	}

}
