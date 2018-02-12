package entities;

import processing.core.PApplet;
import processing.core.PShape;

public class Paddle {
	
	private float x,y;
	private float spd;
	private float size; // Size: = how wide paddle is, height is six this
	private PShape pd;
	
	/** Constructor for Paddle Object
	 *  this constructor calls the super Constructor GRectangle with all of the following parameters.
	 * 
	 * @param x starting x position of the paddle
	 * @param y starting y position of the paddle
	 * @param spd initial spd of paddle
	 * @param size initial size of paddle
	 */
	public Paddle (float x, float y, float spd, float size) {
		this.x = x;
		this.y = y;
		this.spd = spd;
		this.size = size;
	}
	
	public void move() {
		
	}
	
	public void draw(PApplet p) {
		p.shape(pd,x,y);
	}
	
	public void setup(PApplet p) {
		pd = p.createShape();
		pd.beginShape();
		//color
		pd.fill(255);
		pd.stroke(255);
		//vertices (rectangle)
		pd.vertex(0, 0);
		pd.vertex(size, 0);
		pd.vertex(size, size*6);
		pd.vertex(0, size*6);
		pd.vertex(0, 0);
		pd.endShape();
	}
	
}
