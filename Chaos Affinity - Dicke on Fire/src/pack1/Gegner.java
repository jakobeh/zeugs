package pack1;

import java.awt.Rectangle;

public abstract class Gegner extends entity{
int status;
protected int temp = 0;
//1: Schadenshitbox, 2: Trefferhitbox
Rectangle Hitbox1, Hitbox2;
	
	public Gegner(int w, int h, double X, double Y, int R, int G, int B, int s, int p) {
		super(w, h, X, Y, R, G, B, s, p);
		Hitbox1 = new Rectangle();
		Hitbox1.setSize(w , h - general.HitboxDif);
		Hitbox1.setLocation((int)X, (int)Y + general.HitboxDif);
		Hitbox2 = new Rectangle();
		Hitbox2.setSize(w - 2 * general.HitboxDif, h + general.HitboxDif);
		Hitbox2.setLocation((int)X + general.HitboxDif, (int)Y - general.HitboxDif);
	}

}
