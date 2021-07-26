package pack1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Segment {
	boolean active = false;
	int blueprint;
	String biom;
	String path;
	BufferedImage Lvl;
	int number = 1;
	int world;

	public Segment(int n, int w) {
		number = n;
		world = w;
	}

	public void processBlueprint() {
		path = "rsc/lvls/s" + blueprint + ".png";
		try {
			Lvl = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Level konnte nicht geladen werden ):");
		}

		for (int i = 0; i < general.blueprintSeite; i++) {
			for (int j = 0; j < general.blueprintSeite; j++) {
				Color c = new Color(Lvl.getRGB(i, j));
				switch (c.toString()) {
				case "java.awt.Color[r=255,g=255,b=255]" :
					
					break;
				case "java.awt.Color[r=255,g=0,b=0]" :
					new SpikeShroom(i * general.faktorRaster, j * general.faktorRaster, number, world);
					

					break;
				default :
					
					break;
				}
			}
		}
	}
}
