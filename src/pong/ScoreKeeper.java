package pong;

public class ScoreKeeper {
	private int p1score;
	private int p2score;
	
	public ScoreKeeper (int p1, int p2) {
		p1score = p1;
		p2score = p2;
	}
	
	public ScoreKeeper () {
		this(0,0);
	}
	
	public void p1scored () {
		p1score++;
		System.out.println("Player 1 scored!");
	}
	
	public void p2scored () {
		p2score++;
		System.out.println("Player 2 scored!");
	}
	
	public void p1scored (int pause) {
		p1score++;
		//Main.pause(pause);
	}
	
	public void p2scored (int pause) {
		p2score++;
		// Main.pause(pause);
	}
}
