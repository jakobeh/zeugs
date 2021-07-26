package pack1;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Wurm {
static int heightI = 250, widthI = 250, height1 = 0, height2 = 125, height3 = 180, height4 = 250, width = 80;
static int dmg = 1;
static double x = 1300, realX = 0;
static int y = 0;
static Rectangle Hitbox1, Hitbox2;
static int status = 4;
private int wcount = 0;
Timer wurm;

	public Wurm() {
		y = Var.screenheight - (Var.Bodenlevel + heightI);
		x = (Math.random() * 4000 + 1200);
		realX = Var.dickeRealX + x - Var.dickeX;
		
		Hitbox1 = new Rectangle();
		Hitbox1.setSize(width, height4 - 20);
		Hitbox1.setLocation((int) x + 85, y + 20);
		Hitbox2 = new Rectangle();
		Hitbox2.setSize(width - 30, height4);
		Hitbox2.setLocation((int) x + 95, y - 20);
		
		wurm = new Timer();
		wurm.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (wcount == 0) {
					status = 1;
					wcount++;
				}
				else if (wcount < 5) {
					status++;
					wcount++;
				}
				else if (wcount == 5) {
					status--;
					wcount++;
				
				}
				else if (wcount == 6) {
					status++;
					wcount++;
					
				}
				else if (wcount < 10) {
					status--;
					wcount++;
					
				}
				else if (wcount < 12) {
					status = 1;
					wcount++;
					
				}
				else if (wcount == 12) {
					status = 1;
					wcount = 0;
				}
				
			}
			
		}, 0, Var.rate * 10);
	}

	public static void spawn() {
		x = (Math.random() * 4000 + 1200);
		realX = Var.dickeRealX + x - Var.dickeX;
		status = 1;
	}
}
