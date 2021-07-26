package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class HitboxHandler {
	Timer box;
	private int hcount = 0;

	public HitboxHandler() {
		box = new Timer();
		box.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imSpiel) {
					if (Var.duck == false) {
						Var.dickeHitbox.setLocation(Var.dickeX + 50, Var.dickeY);
						Var.dickeHitbox.setSize(Var.dickewidth - 100, Var.dickeheight);
					} else if (Var.duck) {
						Var.dickeHitbox.setLocation(Var.dickeX + 50, Var.dickeY + Var.dickeheight / 2);
						Var.dickeHitbox.setSize(Var.dickewidth - 100, Var.dickeheight / 2);
					}

					Var.coin1.Hitbox.setLocation((int) Var.coin1.x, Var.coin1.y);
					Var.coin2.Hitbox.setLocation((int) Var.coin2.x, Var.coin2.y);

					Pilz2.Hitbox1.setLocation((int) Pilz2.x + 20, Pilz2.y + 10);
					Pilz2.Hitbox2.setLocation((int) Pilz2.x + 30, Pilz2.y - 20);

					switch (Wurm.status) {
					case 1:
						Wurm.Hitbox1.setSize(Wurm.width, 0);
						Wurm.Hitbox1.setLocation((int) Wurm.x + 85, Wurm.y + 250);
						Wurm.Hitbox2.setSize(Wurm.width - 30, 0);
						Wurm.Hitbox2.setLocation((int) Wurm.x + 100, Wurm.y + 250);
					case 2:
						Wurm.Hitbox1.setSize(Wurm.width, Wurm.height2 - 20);
						Wurm.Hitbox1.setLocation((int) Wurm.x + 85, Wurm.y + 145);
						Wurm.Hitbox2.setSize(Wurm.width - 30, Wurm.height2 + 10);
						Wurm.Hitbox2.setLocation((int) Wurm.x + 100, Wurm.y + 115);
					case 3:
						Wurm.Hitbox1.setSize(Wurm.width, Wurm.height3 - 20);
						Wurm.Hitbox1.setLocation((int) Wurm.x + 85, Wurm.y + 90);
						Wurm.Hitbox2.setSize(Wurm.width - 30, Wurm.height3 + 10);
						Wurm.Hitbox2.setLocation((int) Wurm.x + 100, Wurm.y + 60);
					case 4:
						Wurm.Hitbox1.setSize(Wurm.width, Wurm.height4 - 20);
						Wurm.Hitbox1.setLocation((int) Wurm.x + 85, Wurm.y + 20);
						Wurm.Hitbox2.setSize(Wurm.width - 30, Wurm.height4 + 10);
						Wurm.Hitbox2.setLocation((int) Wurm.x + 100, Wurm.y - 10);
					case 5:
						Wurm.Hitbox1.setSize(Wurm.width, Wurm.height4 - 20);
						Wurm.Hitbox1.setLocation((int) Wurm.x + 85, Wurm.y + 20);
						Wurm.Hitbox2.setSize(Wurm.width - 30, Wurm.height4 + 10);
						Wurm.Hitbox2.setLocation((int) Wurm.x + 100, Wurm.y - 10);
					}

					if (Var.dickeHitbox.intersects(Var.BodenHitbox)) {
						Var.onFloor = true;
						if (Var.dickeY + Var.dickeheight > Var.screenheight - Var.Bodenlevel) {
							Var.dickeY = Var.screenheight - Var.Bodenlevel - Var.dickeheight + 1;
						}
					} else if (Var.dickeHitbox.intersects(Var.BodenHitbox) == false) {
						Var.onFloor = false;
					}

					Pilz1.Hitbox.setLocation((int) Pilz1.x + 20, Pilz1.y + 10);

					if (Var.dickeHitbox.intersects(Pilz1.Hitbox)) {
						if (Var.invincible == false) {
							Var.leben -= Var.Pilz1Dmg;
						}
						if (hcount == 0) {
							Var.invincible = true;
						}
					}

					if (Var.dickeHitbox.intersects(Pilz2.Hitbox1)) {
						if (Var.invincible == false) {
							Var.leben -= Var.Pilz2Dmg;
						}
						if (hcount == 0) {
							Var.invincible = true;
						}
					}

					if (Var.dickeHitbox.intersects(Pilz2.Hitbox2)) {
						if (Var.dickeHitbox.intersects(Pilz2.Hitbox1) == false) {
							Pilz2.spawn();
							Var.coins++;
							Var.dickeVY = -7;
						}

					}
					
					if (Var.dickeHitbox.intersects(Wurm.Hitbox1)) {
						if (Var.invincible == false) {
							Var.leben -= Wurm.dmg;
						}
						if (hcount == 0) {
							Var.invincible = true;
						}
					}

					if (Var.dickeHitbox.intersects(Wurm.Hitbox2)) {
						if (Var.dickeHitbox.intersects(Wurm.Hitbox1) == false) {
							Wurm.spawn();
							Var.coins++;
							Var.dickeVY = -7;
						}

					}

					if (Var.dickeHitbox.intersects(Var.coin1.Hitbox)) {
						Var.coins++;
						Var.coin1.spawn();
					}
					if (Var.dickeHitbox.intersects(Var.coin2.Hitbox)) {
						Var.coins++;
						Var.coin2.spawn();
					}

					if (Var.invincible) {
						if (hcount < Var.invicibilityLength) {
							hcount++;
						} else if (hcount == Var.invicibilityLength) {
							hcount = 0;
							Var.invincible = false;
						}
					}
				}
			}
		}, 0, Var.rate);
	}

}
