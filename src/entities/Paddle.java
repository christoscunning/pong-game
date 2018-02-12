package entities;

import acm.graphics.GRectangle;

public class Paddle extends GRectangle {
	
	private float x,y;
	private float spd;
	private float size; // Size: = how wide paddle is, height is twice this
	
	/** Constructor for Paddle Object
	 *  this constructor calls the super Constructor GRectangle with all of the following parameters.
	 * 
	 * @param x starting x position of the paddle
	 * @param y starting y position of the paddle
	 * @param w starting width of the paddle
	 * @param h starting height of the paddle
	 */
	public Paddle (float x, float y, float spd, float size) {
		this.x = x;
		this.y = y;
		this.spd = spd;
		this.size = size;
	}
	
	public void draw() {
		
	}
	
	public void move() {
		
	}
	
	public void setup() {
		
	}
	
}
