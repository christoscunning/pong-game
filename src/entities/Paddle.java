package entities;

import java.awt.Graphics;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import acm.program.GraphicsProgram;
import pong.Main;

public class Paddle {
	
	public static final double SPD = 5;
	
	private double x,y;
	private double width, height; // Size: = how wide paddle is, height is twice this
	private double x_move;
	private GRect p;
	
	/** Constructor for Paddle Object
	 *  this constructor calls the super Constructor GRectangle with all of the following parameters.
	 * 
	 * @param x starting x position of the paddle
	 * @param y starting y position of the paddle
	 * @param w starting width of the paddle
	 * @param h starting height of the paddle
	 */
	public Paddle (double w, double h, double x, double y) {
		width = w;
		height = h;
		this.x = x;
		this.y = y;
		p = new GRect(x, y, w, h);
	}
	
	/** Constructor for Paddle Object
	 *  this constructor calls the super Constructor GRectangle with all of the following parameters. If x,y are not specified, paddle starts at 0,0
	 * 
	 * @param x starting x is 0
	 * @param y starting y is 0
	 * @param w starting width of the paddle
	 * @param h starting height of the paddle
	 */
	public Paddle (double w, double h) {
		this(w,h,0,0);
	}
	
	public void draw(GraphicsProgram g) {
		g.add(p,x,y);
	}
	
	// instead of move method , add keyListener methods to move paddle
	
	public void init (GraphicsProgram g) {
		// inst this just constructor
	}
}
