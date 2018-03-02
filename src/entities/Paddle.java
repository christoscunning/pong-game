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
	private int playernum;
	private GRect p;
	
	private boolean movingUp;
	private boolean movingDown;
	
	/** Constructor for Paddle Object
	 *  this constructor calls the Constructor GRect with all of the following parameters.
	 *  x,y are the center of the paddle
	 * 
	 * @param x starting x position of the paddle
	 * @param y starting y position of the paddle
	 * @param w starting width of the paddle
	 * @param h starting height of the paddle
	 */
	public Paddle (double x, double y, int playernum) {
		width = STARTING_SIZE;
		height = STARTING_SIZE * WHRATIO;
		this.x = x;
		this.y = y;
		p = new GRect(x, y, width, height);
		movingUp = false;
		movingDown = false;
		this.playernum = playernum;
	}
	
	public void draw(GraphicsProgram g) {
		g.add(p,x-(width/2),y-(height/2));
	}
	
	/** Method that moves the paddle based on User Input. Key presses are registered in main class and flip booleans in Paddle class.
	 *  when movingUp/movingDown == true, paddle will move up or down by SPD.
	 * 
	 * @param tDelta time in miliseconds between current frame and last frame.
	 */
	public void move (long tDelta) {
		if (movingUp) {
			y -= SPD; // * tDelta;
			// check if at top
			if (y-(height/2) < 0) {
				y = height/2;
			}
		}
		if (movingDown) {
			y += SPD ; //* tDelta;
			// check if at bottom
			if (y+(height/2) > Main.SCREEN_H) {
				y = Main.SCREEN_H - height/2;
			}
		}
	}
	
	public void setMovingUp (boolean flag) {
		movingUp = flag;
	}
	
	public void setMovingDown (boolean flag) {
		movingDown = flag;
	}
	
	public void init (GraphicsProgram g) {
		p.setFilled(true);
	}
	
	public GObject getGObject () {
		return p;
	}
	
	public double getWidth() {
		return width;
	}
	
	public int getPlayerNumber() {
		return playernum;
	}
}
