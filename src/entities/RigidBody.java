package entities;

import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

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
		
		//System.out.println("l1: " + l1.print() + " r1: " + r1.print());
		// if all conditions are true, rectangles intersect
		if (l1.x < r2.x && r1.x > l2.x && l1.y < r2.y && r1.y > l2.y) {
			return true;
		}
		
		/*
		 * 
		// If one rectangle is on left side of other
	    if (l1.x > r2.x || l2.x > r1.x)
	        return false;
	 
	    // If one rectangle is above other
	    if (l1.y < r2.y || l2.y < r1.y)
	        return false;
	    */
	    return false;
	}
	
}
