package pong;

import entities.*;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import java.awt.event.*;

public class Main extends GraphicsProgram {
	
	// window stuff
	public static final int SCREEN_W = 600;
	public static final int SCREEN_H = 400;
	private static final int PAUSE = 10; // or whatever interval you like
	
	// paddle stuff
	public static final float STARTING_SPEED = 5;
	public static final float STARTING_SIZE = 10;
	
	Paddle p1; //= new Paddle(50,50);
	Paddle p2;
	Ball ball;
	
	public void init () {
		setSize(SCREEN_W,SCREEN_H);
		addMouseListeners();
		addKeyListeners();
	}
	
	public void run () {
		/*
		this.resize(SCREEN_W,SCREEN_H);
		pause(PAUSE);
		*/
		
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
