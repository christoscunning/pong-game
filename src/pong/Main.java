package pong;

import entities.*;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.event.*;
import java.util.Random;

public class Main extends GraphicsProgram {
	
	// window stuff
	public static final int SCREEN_W = 900;
	public static final int SCREEN_H = 600;
	private static final int PAUSE = 10; // or whatever interval you like
	
	// Game stuff
	private boolean gameRunning;
	private static final double seed = 1; // for testing purposes
	private static RandomGenerator rand = RandomGenerator.getInstance();
	//fps
	private long tDelta;
	private long lastTime;
	
	private Paddle p1; //= new Paddle(50,50);
	private Paddle p2;
	private Ball ball;
	
	public void init () {
		lastTime = System.currentTimeMillis();
		// set size of screen
		setSize(SCREEN_W,SCREEN_H);
		
		// Main Stuff
		gameRunning = true;
		
		// add Listeners
		addMouseListeners();
		addKeyListeners();
		
		// Initialize entities
		p1 = new Paddle(25 , SCREEN_H/2-(Paddle.STARTING_SIZE*Paddle.WHRATIO)/2,1); // 25 = how far from edge they start
		p1.init(this);
		p2 = new Paddle(SCREEN_W-25, SCREEN_H/2-(Paddle.STARTING_SIZE*Paddle.WHRATIO)/2,2);
		p2.init(this);
		ball = new Ball(SCREEN_W/2,SCREEN_H/2); //SCREEN_W/2,SCREEN_H/2
		ball.init(this);
		
		// starting timing
		
		println("Game Initialized in " + (System.currentTimeMillis() - lastTime) + "ms\nlastTime: " + lastTime);
		lastTime = System.currentTimeMillis();
	}
	
	public void run () {
		this.resize(SCREEN_W,SCREEN_H);
		pause(PAUSE);
		
		while(gameRunning) {
			tDelta = System.currentTimeMillis() - lastTime;
			
			p1.move(tDelta);
			p1.draw(this);
			p2.move(tDelta);
			p2.draw(this);
			ball.move();
			ball.draw(this);
			
			// check for collisions
			if (RigidBody.isColliding(p1.getGObject(), ball.getGObject())) {
				// ball hit left paddle
				ball.bounce(p1);
			}
			if (RigidBody.isColliding(p2.getGObject(), ball.getGObject())) {
				// ball hit right paddle
				ball.bounce(p2);
			}
			
			//println(tDelta);
			lastTime = System.currentTimeMillis();
			pause(PAUSE);
		}
		

		println("program terminated");
		System.exit(0);
	}
	
	/* Listeners */
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W: p1.setMovingUp(true); break;
			case KeyEvent.VK_S: p1.setMovingDown(true); break;
			case KeyEvent.VK_UP: p2.setMovingUp(true); break;
			case KeyEvent.VK_DOWN: p2.setMovingDown(true); break;	
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			// Reset
			ball.reset();
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			// Terminate Program
			gameRunning = false;
		}
	}
	
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W: p1.setMovingUp(false); break;
			case KeyEvent.VK_S: p1.setMovingDown(false); break;
			case KeyEvent.VK_UP: p2.setMovingUp(false); break;
			case KeyEvent.VK_DOWN: p2.setMovingDown(false); break;	
		}
	
	}
	
	
	/** Method to get random number between nzero and n (inclusive).
	 * 
	 * @param nzero lower limit of random range
	 * @param n upper limit of random range
	 * @return returns a random int between 0 and n.
	 */
	public static double getRandNumBetween (double nzero, double n) {
		double ranr = rand.nextDouble(nzero, n);
		return ranr;
	}
}
