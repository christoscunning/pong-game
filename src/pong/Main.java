package pong;


import entities.*;
import processing.core.PApplet;
import java.util.Random;

public class Main extends PApplet {
	public static final int SCREEN_W = 800;
	public static final int SCREEN_H = 600;
	
	public static final float STARTING_SPEED = 5;
	public static final float STARTING_SIZE = 10;
	
	Paddle p1;
	Paddle p2;
	Ball ball;
	
	private Random rand = new Random();
	
	// For controls, is p1/p2 going up/down
	private boolean isp1up;
	private boolean isp1down;
	private boolean isp2up;
	private boolean isp2down;
	
	/* Run once for every frame */
	public void draw () {
		clear();
		
		// Player controls
		if(isp1up) p1.moveUp();
		if(isp1down) p1.moveDown();
		if(isp2up) p2.moveUp();
		if(isp2down) p2.moveDown();
		// Draw both player paddles
		p1.draw(this);
		p2.draw(this);
		
		//Ball move and draw
		ball.move();
		ball.draw(this);
	}
	
	public void checkCollisions () {
		
	}
	
	/* Checking for keyboard input from user */
	public void keyPressed() {
		if (key == 'w' || key == 'W') {
			isp1up = true;
		}
		if (key == 's' || key == 'S') {
			isp1down = true;
		}
		if (key == CODED) {
			if (keyCode == UP) {
				isp2up = true;
			}
			if (keyCode == DOWN) {
				isp2down = true;
			}
		}
		if (key == 'r' || key == 'R') {
			reset();
		}
	}
	
	public void keyReleased() {
		if (key == 'w' || key == 'W') {
			isp1up = false;
		}
		if (key == 's' || key == 'S') {
			isp1down = false;
		}
		if (key == CODED) {
			if (keyCode == UP) {
				isp2up = false;
			}
			if (keyCode == DOWN) {
				isp2down = false;
			}
		}
	}
	
	/* Run once after drawing stuff is available */
	public void setup () {
		// set background color to black
		background(0);
		
		/* Test
		for(int i = 0; i<50; i++ ) {
			System.out.println((int)getRandNumBetween(1, 3));
		}
		*/
		
		// Setup player 1
		p1 = new Paddle(30,SCREEN_H/2,STARTING_SPEED,STARTING_SIZE);
		p1.setup(this);
		// Setup player 2
		p2 = new Paddle(SCREEN_W-30,SCREEN_H/2,STARTING_SPEED,STARTING_SIZE);
		p2.setup(this);
		// Setup ball
		ball = new Ball(SCREEN_W/2,SCREEN_H/2);
		ball.setup(this);
		
		isp1up = false;
		isp1down = false;
		isp2up = false;
		isp2down = false;
	}
	
	/* Run once at very start */
	public void settings() {
		size(SCREEN_W,SCREEN_H);
	}
	
	private void reset () {
		ball.resetBall();
	}
	
	/** Method to get random number between 0 and n (inclusive). To get position of vertices of randomly generated asteroid.
	 * 
	 * @param nzero lower limit of random range
	 * @param n upper limit of random range
	 * @return returns a random int between nzero and n.
	 */
	public float getRandNumBetween (float nzero, float n) {
		float ranr = nzero + (rand.nextFloat()*(n-1));
		return ranr;
	}
	
	public static void main(String[] args) {
		PApplet.main("pong.Main");
	}
	
}
