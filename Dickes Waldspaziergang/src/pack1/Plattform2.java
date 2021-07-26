package pack1;

import java.awt.Rectangle;

public class Plattform2 {
	static double x, y, realX;
	static int height = 215, width = 425;
	Rectangle hitbox1, hitbox2;
	
	

	public Plattform2() {
		x = Math.random() * 8000 + 1200;
		y = Math.random() * (Var.screenheight - Var.Bodenlevel) - Var.Bodenlevel + 530;
		realX = x;
		
		hitbox1 = new Rectangle();
		hitbox1.setLocation((int) x, (int) y + 70);
		hitbox1.setSize(width, 150);
		hitbox2 = new Rectangle();
		hitbox2.setLocation((int) x + 25, (int) y + 130);
		hitbox2.setSize(width - 50, 250);
		
	}
	public static void spawn() {
		x = Math.random() * 8000 + 1200;
		y = Math.random() * (Var.screenheight - Var.Bodenlevel - 530) - Var.Bodenlevel + 530;
		realX = x;
	}

}