package entities;

import java.awt.Graphics;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import acm.program.GraphicsProgram;
import pong.Main;

public class Paddle extends GRect {
	
	public static final double SPD = 5;
	
	private double x,y;
	private double width, height; // Size: = how wide paddle is, height is twice this
	private double dir; // in radians
	
	/** Constructor for Paddle Object
	 *  this constructor calls the super Constructor GRectangle with all of the following parameters.
	 * 
	 * @param x starting x position of the paddle
	 * @param y starting y position of the paddle
	 * @param w starting width of the paddle
	 * @param h starting height of the paddle
	 */
	public Paddle (double w, double h, double x, double y) {
		super(w,h);
		width = w;
		height = h;
		this.x = x;
		this.y = y;
		dir = Main.getRandNumBetween(0, Math.PI*2);
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
		super(w,h);
		width = w;
		height = h;
		this.x = 0;
		this.y = 0;
	}
	
	public void draw(GraphicsProgram g) {
		g.add(this,x,y);
	}
	
	public void move() {
		x += SPD * Math.cos(dir);
		y += SPD * Math.sin(dir);
	}
	
	public void init (GraphicsProgram g) {
		
	}
	
	public void setup() {
		
	}
	
}
