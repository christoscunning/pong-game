package entities;

import acm.graphics.GOval;

public class Ball {
	
	float rad;
	float x,y;
	
	/** Constructor the Ball Object
	 *  Calls the super constructor for GOval with the following parameters slight altered for a circle.
	 *  Sets x and y to be at the center of the circle instead of corner.
	 * 
	 * @param x starting x position of the ball, x is center of circle
	 * @param y starting y position of the ball, y is center of circle
	 * @param rad starting radius of the circle, height and width are both equal to 2 * radius
	 */
	public Ball (float x, float y, float rad) {
		this.x = x;
		this.y = y;
		this.rad = rad;
	}
	
	public void draw() {
		
	}
	
	public void move() {
		
	}
	
	public void setup() {
		
	}
}
