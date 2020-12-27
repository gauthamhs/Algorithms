package algorithms.general;

public class RectangleBasicProblems {
	
	/* Key Facts about rectangle:
	 * 
	 *  
	 *  Area of a rectangle = width*height;
	 *  
	 *  If there is an intersecting rectangle, its area must be positive(it must have both width and height).
	 *  To calculate the width and height of overlapping rectangle, width = Math.min(larger coordinates) - Math.max(smaller coordinates)
	 *  same goes for height
	 *  
	 *  x1,y1 - lower coordinates
	 *  x2,y2 - upper coordinates
	 *  for a given rectangle
	 *  
	 *  Example: [0,0,1,1]
                 [1,0,2,1] returns false
                 
                 
	 *  rec1 = [0,0,2,2], rec2 = [1,1,3,3] returns true;
	 *  
	 *  Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
	 *  
	 *  Time Complexity: O(1) All these calculations are done in constant time
	 *  */
	
	public static boolean doRectanglesOverlap(int[] rect1, int[] rect2) {
		boolean isOverlap = false;
		
		int x1=rect1[0]; int x3=rect2[0];
		int y1=rect1[1]; int y3=rect2[1];
		int x2=rect1[2]; int x4=rect2[2];
		int y2=rect1[3]; int y4=rect2[3];
		
		// to detect overlapping rectangle, we have to get width and height>0
		int width = Math.min(x4,x2) - Math.max(x3, x1);
		int height= Math.min(y4,y2) - Math.max(y3, y1);
		
		return width>0 && height>0;
		
	}
	
	public static boolean isRectALine(int[] rect) {
		return (rect[0]==rect[2] || rect[1]==rect[3]);
	}
	
	public static int rectangleAreaNonOverlapping(int[] rect1, int[] rect2) {
		int x1=rect1[0]; int x3=rect2[0];
		int y1=rect1[1]; int y3=rect2[1];
		int x2=rect1[2]; int x4=rect2[2];
		int y2=rect1[3]; int y4=rect2[3];
		
		int areaA = (x2-x1)*(y2-y1);
		int areaB = (x4-x3)*(y4-y3);
		
		//System.out.println(areaA);
		//System.out.println(areaB);
		
        int left = Math.max(x3, x1);
        int right = Math.min(x4, x2);
        int bottom = Math.max(y3, y1);
        int top = Math.min(y4, y2);
        
        int areaOverlap = 0;
		
        if(right>left && top>bottom) {
        	areaOverlap=((right-left)*(top-bottom));
        }
        
        return areaA+areaB-areaOverlap;
        
	}
	
	
	
	public static void main(String[] args) {
		/*
		 * int[] rect1 = {0,0,2,2}; int[] rect2 = {1,1,3,3}; int[] rect3 = {0,0,1,1};
		 * int[] rect4 = {1,0,2,1}; System.out.println(doRectanglesOverlap(rect1,
		 * rect2)); System.out.println(doRectanglesOverlap(rect3, rect4));
		 * 
		 * int[] rect5 = {-3,0,3,4}; int[] rect6 = {0,-1,9,2};
		 * 
		 * System.out.println(doRectanglesOverlap(rect5, rect6));
		 * System.out.println(rectangleAreaNonOverlapping(rect5, rect6));
		 */
		
		int[] rect7= {-1500000001,0,-1500000000,1};
		int[] rect8= {1500000000,0,1500000001,1};
		System.out.println(rectangleAreaNonOverlapping(rect7, rect8));
		
	}

}
