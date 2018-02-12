package pong;

import entities.*;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram {
	
	// window stuff
	public static final int SCREEN_W = 600;
	public static final int SCREEN_H = 400;
	private static final int PAUSE = 10; // or whatever interval you like
	
	// paddle stuff
	public static final float STARTING_SPEED = 5;
	public static final float STARTING_SIZE = 10;
	
	private boolean gameRunning = true;
	
	Paddle p1 = new Paddle(50,50);
	Paddle p2;
	Ball ball;
	
	public void run () {
		/*
		this.resize(SCREEN_W,SCREEN_H);
		pause(PAUSE);
		*/
		while(true) {
			p1.move();
			p1.draw(this);
			
			println("runnin");
			int input = readInt();
			if(input == 1) {
				gameRunning = false;
				break;
			}
		}
	}
	
	public void keyPressed () {
		
		if(getKeyCode() == 27) {
			
		}
		
	}
	
	public void init () {
		setSize(SCREEN_W,SCREEN_H);
	}
	
	
	/** Method to get random number between 0 and n (inclusive). To get position of vertices of randomly generated asteroid.
	 * 
	 * @param n upper limit of random range
	 * @return returns a random int between 0 and n.
	 */
	public static double getRandNumBetween (double nzero, double n) {
		double ranr = nzero + ( (Math.random() * n ) + 1);
		return ranr;
		
	}
}
