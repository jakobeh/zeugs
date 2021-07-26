package pack1;

public class HatShroom extends Gegner{

	public HatShroom(double X, double Y, int s, int p) {
		super(50, 50, X, Y, 255, 50, 0, s, p);
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
