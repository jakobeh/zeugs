package pack1;

import java.awt.Rectangle;

public class Pilz2 {
	static double x = 1300, realX = 1300;
	static int y = 0;
	static Rectangle Hitbox1, Hitbox2;
	static int width = 120, height = 100;
	
		public Pilz2() {
			y = Var.screenheight - (Var.Bodenlevel + height);
			x = (Math.random() * 4000 + 1200);
			realX = Var.dickeRealX + x - Var.dickeX;
			
			Hitbox1 = new Rectangle();
			Hitbox1.setSize(width - 40, height -10);
			Hitbox1.setLocation((int) x + 20, y + 10);
			Hitbox2 = new Rectangle();
			Hitbox2.setSize(width - 60, height);
			Hitbox2.setLocation((int) x + 30, y - 20);
		}
		
		public static void spawn() {
			x = (Math.random() * 4000 + 1200);
			realX = Var.dickeRealX + x - Var.dickeX;
		}
}
