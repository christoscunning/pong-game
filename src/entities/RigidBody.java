package entities;

import acm.graphics.GObject;
import util.Point;

public class RigidBody {
	
	public RigidBody () {
		
	}
	
	// returns true if the objects overlap (rectangle bounding boxes)
	public static boolean isColliding(GObject a, GObject b) {
		Point l1 = new Point(), r1 = new Point(), l2 = new Point(), r2 = new Point();
		l1.x = a.getX();
		l1.y = a.getY();
		r1.x = a.getX()+a.getWidth();
		r1.y = a.getY()+a.getHeight();
		l2.x = b.getX();
		l2.y = b.getY();
		r2.x = b.getX()+b.getWidth();
		r2.y = b.getY()+b.getHeight();
		
		// Proof by contradiction: if any are false, rectangles do not intersect
		// ie: if all conditions are true, rectangles intersect
		if (l1.x < r2.x && r1.x > l2.x && l1.y < r2.y && r1.y > l2.y) {
			return true;
		}
	    return false;
	}
	
}
