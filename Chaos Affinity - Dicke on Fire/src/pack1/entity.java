package pack1;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class entity {
	int width, height;
	double x, y;
	Rectangle Hitbox;
	BufferedImage i1;
	Color HitboxColor;
	int segment;
	int player;

	public entity(int w, int h, double X, double Y, int R, int G, int B, int s, int p) {
		width = w;
		height = h;
		x = X;
		y = Y;
		Hitbox = new Rectangle();
		Hitbox.setLocation((int) x, (int) y);
		Hitbox.setSize(width, height);
		HitboxColor = new Color(R, G, B, general.HitboxTransparenz);
		segment = s;
	}

}
