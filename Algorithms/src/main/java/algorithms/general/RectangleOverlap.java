package algorithms.general;

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
