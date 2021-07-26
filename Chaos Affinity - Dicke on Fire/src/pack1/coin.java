package pack1;

public class coin extends entity{
public int status;
private int temp = 0;
	
	public coin(double X, double Y, int s, int p) {
		super(50, 50, X, Y, 255, 255, 0, s, p);
		status = 1;
	}
	
	public void update() {
		// Drehung der Münze
		if (temp < 10) {
			temp++;
		}else if (temp == 10) {
			temp = 0;
			if (status < 4) {
				status++;
			} else if (status == 4) {
				status = 1;
			}
		}
	}
}
