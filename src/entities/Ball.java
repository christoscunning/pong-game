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
	Main m = new Main();
	
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
		if(y-RAD<0) {
			//bounce top
			y=0+RAD;
			bounce();
		}
		if(y+RAD > Main.SCREEN_H) {
			//bounce bottom
			y=Main.SCREEN_H-RAD;
			bounce();
		}
		// if hits behind paddles reset to middle
		if(x < 0) {
			//score of left (p1)
			resetBall();
		}
		if(x > Main.SCREEN_W) {
			//score on right (p2)
			resetBall();
		}
			
	}
	
	public void draw(PApplet p) {
		p.shape(b,x,y);
	}
	
	public void setup(PApplet p) {
		b = p.createShape(PApplet.ELLIPSE,RAD, RAD, RAD*2, RAD*2);
		b.setStroke(255);
		b.setFill(255);
	}
	
	public void resetBall (/* int which player scored on */) {
		// TODO score counter later
		// TODO add slight pause and countdown before game starts again
		x = Main.SCREEN_W/2;
		y = Main.SCREEN_H/2;
		dir = getRanStartingDirection();
	}
	
	public void bounce () {
		dir = -dir;//(float) (Math.PI - dir);
	}
	
	public float getX () {
		return x;
	}
	
	public float getY () {
		return y;
	}
	
	//This is not very random for some reason
	// Changed to static and now angles are too sharp ?? 
	private float getRanStartingDirection () {
		float angle = 0;
		int way = (int)m.getRandNumBetween(1, 3);
		if(way == 1) {
			angle = m.getRandNumBetween((float) (Math.PI - (Math.PI/6)), (float) (Math.PI + (Math.PI/6)));
		} else if(way == 2) {
			angle = m.getRandNumBetween((float)(-Math.PI/6),(float)(Math.PI/6));
		} else {
			System.out.println("error in getRanStartingDirection");
		}
		return angle;
	}
}
