package algorithms.general;

class Rectangle{
	int x;
	int y;
	int width;
	int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

/*
 * To find the intersecting rectangle, we need to do the following:
 * 
 *1) See if the rectangle intersects. If it does, get the x,y,h,w of the new
 * rectangle by doing some math on r1 and r2. 
 * 2) If it doesn't, return a dummy rectangle
 * 
 * Note: To see if two rectangles intersect, There has to be both xoverlap and yoverlap
 * 
 */

public class RectangleOverlap {
	
	public boolean isValueInRange(int value, int min, int max) {
		return ((value>=min) && (value<=max));
	}
	
	public boolean isRectangleOverlap(Rectangle r1, Rectangle r2) {
		boolean isRectangleOverlap = false;
		
		boolean xOverlap = isValueInRange(r1.x, r2.x, r2.x + r2.width)
				           || isValueInRange(r2.x, r1.x, r1.x + r1.width);
		
		boolean yOverlap = isValueInRange(r1.y, r2.y, r2.y + r2.height) 
				           || isValueInRange(r2.y, r1.y, r1.y + r1.height);
		
		isRectangleOverlap = xOverlap && yOverlap;
		
		return isRectangleOverlap;	
		
	}
	
	public Rectangle intersectingRectangle(Rectangle r1, Rectangle r2) {
		if(!isRectangleOverlap(r1, r2)) {
			return new Rectangle(0,0,-1,-1);
		}
		return new Rectangle(Math.max(r1.x, r2.x), 
				              Math.max(r1.y,r2.y),
				              Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x),
				              Math.min(r1.y + r1.height, r2.y + r2.height) - Math.max(r1.y, r2.y));
	}
	
	


}
