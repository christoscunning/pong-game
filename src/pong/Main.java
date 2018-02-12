package pong;


import entities.*;
import processing.core.PApplet;

public class Main extends PApplet {
	public static final int SCREEN_W = 800;
	public static final int SCREEN_H = 600;
	
	public static final float STARTING_SPEED = 5;
	public static final float STARTING_SIZE = 10;
	
	Paddle p1;
	Paddle p2;
	Ball ball;
	
	/* Run once for every frame */
	public void draw () {
		clear();
		
		//Player one move and draw
		p1.move();
		p1.draw(this);
		//Player two move and draw
		p2.move();
		p2.draw(this);
		
		//Ball move and draw
		ball.move();
		ball.draw(this);
	}
	
	/* Checking for keyboard input from user */
	public void keyPressed() {
		
	}
	
	public void keyReleased() {
		
	}
	
	/* Run once after drawing stuff is available */
	public void setup () {
		// set background color to black
		background(0);
		
		// Setup player 1
		p1 = new Paddle(30,SCREEN_H/2,STARTING_SPEED,STARTING_SIZE);
		p1.setup(this);
		// Setup player 2
		p2 = new Paddle(SCREEN_W-30,SCREEN_H/2,STARTING_SPEED,STARTING_SIZE);
		p2.setup(this);
		// Setup ball
		ball = new Ball(SCREEN_W/2,SCREEN_H/2);
		ball.setup(this);
	}
	
	/* Run once at very start */
	public void settings() {
		size(SCREEN_W,SCREEN_H);
	}
	
	/** Method to get random number between 0 and n (inclusive). To get position of vertices of randomly generated asteroid.
	 * 
	 * @param nzero lower limit of random range
	 * @param n upper limit of random range
	 * @return returns a random int between nzero and n.
	 */
	public static float getRandNumBetween (float nzero, float n) {
		float ranr = nzero + ( ((float)Math.random() * n ) + 1);
		return ranr;
	}
	
	public static void main(String[] args) {
		PApplet.main("pong.Main");
	}
	
}
