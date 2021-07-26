package pack1;

public class SpikeShroom extends Gegner{

	public SpikeShroom(double X, double Y, int s, int p) {
		super(50, 50, X, Y, 255, 0, 0, s, p);
		Hitbox2 = null;
		// zeigt an, welches Bild gezeichnet wird
		status = 1;
	}
	
	public void update() {
		// Blinzeln
		if(temp < 240) {
			if (temp == 200) {
				status = 2;
			}
			temp++;
		} else if(temp == 240) {
			temp = 0;
			status = 1;
		}
	}
}
