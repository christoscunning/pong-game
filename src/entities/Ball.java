package entities;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import pong.Main;

public class Ball {
	
	private static final double PI = Math.PI;
	private static final double SPD = 5;
	private static final double RAD = 10;
	
	private double dir;
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
		this.x = x-RAD;
		this.y = y-RAD;
		this.dir = Main.getRandNumBetween(0, PI);
		b = new GOval(x,y, RAD*2, RAD*2);
	}
	
	public void draw(GraphicsProgram g) {
		g.add(b,x,y);
	}
	
	public void move() {
		x += SPD * Math.cos(dir);
		y += SPD * Math.cos(dir);
	}
	
	public void init (GraphicsProgram g) {
		b.setFilled(true);
	}
}
