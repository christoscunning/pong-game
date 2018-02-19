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
	
	// Game stuff
	private boolean gameRunning;
	
	private Paddle p1; //= new Paddle(50,50);
	private Paddle p2;
	private Ball ball;
	
	public void init () {
		// set size of screen
		setSize(SCREEN_W,SCREEN_H);
		
		// add Listeners
		addMouseListeners();
		addKeyListeners();
		
		// Initialize entities
		p1 = new Paddle(50 , SCREEN_H/2-(Paddle.STARTING_SIZE*Paddle.WHRATIO)/2); // 50 = how far from edge they start
		p1.init(this);
		p2 = new Paddle(SCREEN_W-50, SCREEN_H/2-(Paddle.STARTING_SIZE*Paddle.WHRATIO)/2);
		p2.init(this);
		ball = new Ball(SCREEN_W/2,SCREEN_H/2); //SCREEN_W/2,SCREEN_H/2
		ball.init(this);
		
		gameRunning = true;
	}
	
	public void run () {
		this.resize(SCREEN_W,SCREEN_H);
		pause(PAUSE);
		
		while(gameRunning) {
			p1.draw(this);
			p2.draw(this);
			//ball.move();
			ball.draw(this);
		}
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
