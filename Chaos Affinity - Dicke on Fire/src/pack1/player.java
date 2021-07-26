package pack1;

public class player extends entity {
	boolean moveright = false, moveleft = false, duck = false, jump = false;
	String looking;
	double speed = 0, maxspeed = 7, acc = 1, acctemp = 0, maxacctemp = 10;
	int Schritt = 0;
	

	public player(double X, double Y, String l, int p) {
		super (100, 100, X, Y, 0, 200, 20, 1, p);
		looking = l;
	}

}
