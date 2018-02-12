package entities;

import pong.Main;
import processing.core.PApplet;
import processing.core.PShape;

public class Ball {
	
	private static final float SPD = 5;
	private static final float RAD = 10;
	
	float x,y;
	float dir; // in radians
	private PShape b;
	
	/** Constructor the Ball Object
	 *  Calls the super constructor for GOval with the following parameters slight altered for a circle.
	 *  Sets x and y to be at the center of the circle instead of corner.
	 * 
	 * @param x starting x position of the ball, x is center of circle
	 * @param y starting y position of the ball, y is center of circle
	 * @param rad starting radius of the circle, height and width are both equal to 2 * radius
	 */
	public Ball (float x, float y) {
		this.x = x;
		this.y = y;
		// random direction, first between left and right, second some angle between +- 60 degrees (pi/3 rads) of horz
		this.dir = getRanStartingDirection();
	}

	public void move() {
		x += SPD * PApplet.cos(dir);
		y += SPD * PApplet.sin(dir);
		
		// check if hitting top or bottom of screen and bounce
		
	}
	
	public void draw(PApplet p) {
		p.shape(b,x,y);
	}
	
	public void setup(PApplet p) {
		b = p.createShape(PApplet.ELLIPSE,0, 0, RAD*2, RAD*2);
		b.setStroke(255);
		b.setFill(255);
	}
	
	private float getRanStartingDirection () {
		float angle;
		int way = (int)Main.getRandNumBetween(0, 2);
		if(way == 1) {
			angle = Main.getRandNumBetween((float) (Math.PI - (Math.PI/3)), (float) (Math.PI + (Math.PI/3)));
		} else {
			angle = Main.getRandNumBetween((float)(-Math.PI/3),(float)(Math.PI/3));
		}
		return angle;
	}
}
