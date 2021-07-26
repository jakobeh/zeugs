package pack1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
static BufferedImage spikeShroom1, spikeShroom2;
static BufferedImage hatShroom1, hatShroom2;
static BufferedImage coin1, coin2, coin3, coin4;
	
	public Image() {
		try {
			spikeShroom1 = ImageIO.read(new File("rsc/graphics/spikeshroom1.png"));
			spikeShroom2 = ImageIO.read(new File("rsc/graphics/spikeshroom2.png"));
			hatShroom1 = ImageIO.read(new File("rsc/graphics/Hatshroom1.png"));
			hatShroom2 = ImageIO.read(new File("rsc/graphics/Hatshroom2.png"));
			coin1 = ImageIO.read(new File("rsc/graphics/Dicke-Münze.vorne.png"));
			coin2 = ImageIO.read(new File("rsc/graphics/Dicke-Münze.vorne.rechts.png"));
			coin3 = ImageIO.read(new File("rsc/graphics/Dicke-Münze.seitlich.png"));
			coin4 = ImageIO.read(new File("rsc/graphics/Dicke-Münze.vorne.links.png"));
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bilder konnten nicht geladen werden ):");
		}
	}

}
