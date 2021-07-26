package pack1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Var {

	static JFrame jf1;
	static Label lbl1;
	static int screenwidth = 1200, screenheight = 900;
	
	static int scale = 1000000;
	
	static int pradius = 200, ballradius = 100;
	
	static int pmass = 99999999, ballmass = 59;
	static int p1rx, p1ry, p2rx, p2ry;
	static int pspeed = 6;
	
	static double F1x, F1y, F2x, F2y, FxRes, FyRes;
	static double ax, ay;
	static double vx, vy;
	static double maxv = 2;
	
	static double G = 67700;
	
	static int p1x = 300, p1y = 450, p2x = 900, p2y = 450, ballx = 600, bally = 450;
	
	static boolean p1moveup = false, p1movedown = false, p1moveleft = false, p1moveright = false, p2moveup = false, p2movedown = false, p2moveleft = false, p2moveright = false;
	
	static int p1score = 0, p2score = 0, scorewin = 10;
	
	static int rate = 10;
	
	static BufferedImage ib1, ip1, ip2, iball;
	
	public Var() {
		try {
			ib1 = ImageIO.read(new File("rsc/SpaceBackground.jpg"));
			ip1 = ImageIO.read(new File("rsc/black_hole1.png"));
			ip2 = ImageIO.read(new File("rsc/black_hole2.png"));
			iball = ImageIO.read(new File("rsc/Erde.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bilder konnten nicht geladen werden ):");
		}
	}

}
