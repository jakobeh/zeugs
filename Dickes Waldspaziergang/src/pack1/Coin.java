package pack1;

import java.awt.Rectangle;

public class Coin {
	double x = 1300;
	double realX = 1300;
	int y = 0;
	Rectangle Hitbox;
	static int height = 100;
	static int width = 100;

		public Coin() {
			x = (Math.random() * 4000 + 1200);
			y = (int) (Math.random() * (Var.screenheight - Var.Bodenlevel - Coin.height));
			realX = Var.dickeRealX + x - Var.dickeX;
			
			Hitbox = new Rectangle();
			Hitbox.setSize(width, height);
			Hitbox.setLocation((int) x, y);
		}
		
		public void spawn() {
			x = (Math.random() * 4000 + 1200);
			y = (int) (Math.random() * (Var.screenheight - Var.Bodenlevel - Coin.height));
			realX = Var.dickeRealX + x - Var.dickeX;
		}
}
