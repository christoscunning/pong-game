package entities;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import pong.Main;

public class Ball {
	
	private static final double PI = Math.PI;
	private static final double SPD = 5;
	private static final double RAD = 10;
	
	private double dir; // 0 is straight left, positive is down from right x axis
	private double x,y;
	private GOval b;
	
	/** Constructor the Ball Object
	 *  Calls the constructor for GOval with the following parameters slight altered for a circle.
	 *  Sets x and y to be at the center of the circle instead of corner.
	 * 
	 * @param x starting x position of the ball, x is center of circle
	 * @param y starting y position of the ball, y is center of circle
	 */
	public Ball (double x, double y) {
		this.x = x;
		this.y = y;
		this.dir = randomBallDir(); // random dir between reasonable angles
		b = new GOval(x,y, RAD*2, RAD*2);
	}
	
	public void draw(GraphicsProgram g) {
		g.add(b,x-RAD,y-RAD);
	}
	
	public void move() {
		x += SPD * Math.cos(dir);
		y += SPD * Math.sin(dir);
		// check if hitting top
		if (y-RAD < 0) {
			dir *= -1;
			y = RAD;
		}
		// check if hitting bottom
		if (y+RAD > Main.SCREEN_H) {
			dir *= -1;
			y = Main.SCREEN_H-RAD;
		}
		// check if past left edge; point for p2
		if (x<0) {
			reset();
		}
		// check if past right edge; point for p1
		if (x>Main.SCREEN_W) {
			reset();
		}
	}
	
	public void reset () {
		x = Main.SCREEN_W/2; 
		y = Main.SCREEN_H/2;
		dir = randomBallDir();
	}
	
	private double randomBallDir () {
		double rdir = 0;
		int side = (int) Main.getRandNumBetween(0, 2);
		// dir between +- 45 degreese (pi/4) on each side
		if(side == 0) {
			// dir between +45, -45
			rdir = Main.getRandNumBetween(-PI/4, PI/4);
		} else if (side == 1) {
			// dir between 180 +- 45
			rdir = Main.getRandNumBetween((3/4)*PI, (5/4)*PI);
		} else {
			// error with choosing random side value
			System.out.println("error choosing side for random ball direction");
		}
		
		return rdir;
	}
	
	public void init (GraphicsProgram g) {
		b.setFilled(true);
	}
	
}
