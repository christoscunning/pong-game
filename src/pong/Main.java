package pong;


import entities.*;
import processing.core.PApplet;

public class Main extends PApplet {
	
	public static final float STARTING_SPEED = 5;
	public static final float STARTING_SIZE = 10;
	
	Paddle p1 = new Paddle(10,10,101,10);
	Paddle p2;
	Ball ball;
	
	public void run () {
		
	}
	
	/*
	public static void main(String[] args) {
		PApplet.main("pong.Main");
	}
	*/
}
