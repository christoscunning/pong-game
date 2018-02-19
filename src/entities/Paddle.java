package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import acm.program.GraphicsProgram;
import pong.Main;

public class Paddle {
	
	// constant stuff
	public static final double SPD = 5;
	public static final double STARTING_SPEED = 5;
	public static final double STARTING_SIZE = 10;
	public static final double WHRATIO = 6; // height = width * WHRATIO
	
	private double x,y;
	private double width;
	private double height;
	private GRect p;
	
	/** Constructor for Paddle Object
	 *  this constructor calls the Constructor GRect with all of the following parameters.
	 *  x,y are the center of the paddle
	 * 
	 * @param x starting x position of the paddle
	 * @param y starting y position of the paddle
	 * @param w starting width of the paddle
	 * @param h starting height of the paddle
	 */
	public Paddle (double x, double y) {
		width = STARTING_SIZE;
		height = STARTING_SIZE * WHRATIO;
		this.x = x;
		this.y = y;
		p = new GRect(width/2, height/2, width, height);
	}
	
	public void draw(GraphicsProgram g) {
		g.add(p,x,y);
	}
	
	// instead of move method , add keyListener methods to move paddle
	public void keyListener (KeyEvent e) {
		
	}
	
	
	
	public void init (GraphicsProgram g) {
		p.setFilled(true);
	}
}
