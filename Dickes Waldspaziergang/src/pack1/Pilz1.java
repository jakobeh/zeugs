package pack1;

import java.awt.Rectangle;

public class Pilz1 {
static double x = 1300, realX = 1300;
static int y = Var.screenheight - (Var.Bodenlevel + Var.Pilz1height);
static Rectangle Hitbox;

	public Pilz1() {
		x = (Math.random() * 4000 + 1200);
		realX = Var.dickeRealX + x - Var.dickeX;
		
		Hitbox = new Rectangle();
		Hitbox.setSize(Var.Pilz1width - 40, Var.Pilz1height -10);
		Hitbox.setLocation((int) x + 20, y + 10);
	}
	
	public static void spawn() {
		x = (Math.random() * 4000 + 1200);
		realX = Var.dickeRealX + x - Var.dickeX;
	}
}
