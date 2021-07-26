package pack1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Var {

	static JFrame jf1;
	static Label lbl1;

	static JButton btnplay, btnresume, btnoptionen, btnshop, btnplayagain, btnexit;

	static int screenwidth = 800, screenheight = 600;
	static int playerwidth = 90, playerheight = 90;

	static boolean moveright = false, moveleft = false, duck = false, jump = false;

	static int backgroundx1 = 0, backgroundx2 = 800, background2x1 = 200, background2x2 = -600;
	static int foregroundx1 = 0, foregroundx2 = 800;

	static int playerx = 100, playery = 400;
	static int playerrealx = 0;
	static int playerspeed = 6, playerjumpheight = 8;

	static int Stumpfx[] = new int[5];
	static int Stumpfy = 430;
	// static int Stumpfspeed[] = new int[5];
	static int Stumpfdespawnx = -500;
	static int Stumpfheight = 60, Stumpfwidth = 80;
	static int Stumpfcoins = 1, Stumpfdmg = 1;

	static int leben = 5, maxleben = 5, coins = 0, altcoins;

	static boolean getroffen = false, gameover = false;

	static int getroffenanimation = 0;
	
	static int hitCooldown = 60;
	static boolean imHitCooldown = true, getroffenOhneHitCooldown = false;

	static boolean imSpiel = false, imStart = true, imMenu = false, inOptionen = false, imShop = false,
			imGameover = false;

	static int dungeonx, dungeonbx1, dungeonbx2, dungeonlength;

	static BufferedImage iBiber, iWald1, iWald2, iWald3, iWald4, idungeon1, idungeon2, iBoden1, iBoden2, iStumpf,
			iSadEmoji;

	static int startBiberAnimation = 1;

	public Var() {
		try {
			// Biber
			iBiber = ImageIO.read(new File("rsc/biber.png"));
			// Background
			// Wald
			iWald1 = ImageIO.read(new File("rsc/Waldb1.png"));
			iWald2 = ImageIO.read(new File("rsc/Waldb1.png"));
			iWald3 = ImageIO.read(new File("rsc/Waldb1.png"));
			iWald4 = ImageIO.read(new File("rsc/Waldb1.png"));
			// Dungeon
			idungeon1 = ImageIO.read(new File("rsc/dungeonbg.png"));
			idungeon2 = ImageIO.read(new File("rsc/dungeonbg.png"));
			// Foreground
			// Boden
			iBoden1 = ImageIO.read(new File("rsc/Boden1.png"));
			iBoden2 = ImageIO.read(new File("rsc/Boden1.png"));
			// Gegner
			// Stumpf
			iStumpf = ImageIO.read(new File("rsc/Stumpf1.png"));
			// Gameover
			// sad Emoji
			iSadEmoji = ImageIO.read(new File("rsc/sad_emoji.png"));

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bilder konnten nicht geladen weren ): ");
		}

		// dungeonlength = Math.random()

	}
	
	public static void wait (int ms) {
		try {
			Thread.sleep(ms);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
