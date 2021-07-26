package pack1;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Var {

	static JFrame jf1;

	static Label lbl1;

	static Rectangle dickeHitbox, BodenHitbox;

	static int Bodenlevel = 220;

	static int screenwidth = 1200, screenheight = 900;

	static boolean moveright = false, moveleft = false, jumpHold = false, duck = false, lookright = true,
			lookleft = false;

	static int leben = 3, maxleben = 3, coins = 0;

	static boolean invincible = false;
	static int invicibilityLength = 130;

	static int Pilz1Dmg = 1, Pilz2Dmg = 1;

	static double gravity = 0.2;

	static int dickeX = 200, dickeY = 385, dickeRealX = 0;
	static int dickeheight = 300, dickewidth = 300;
	static double dickeJumpV = -7, dickeVY = 0;

	static boolean dickeVisible = true;

	static int sprungheight = 20;

	static double b1_1X = 0, b1_2X = 3600, b2_1X = 0, b2_2X = 3600, f_1X = 0, f_2X = 3600, b3_1X = 0, b3_2X = 3600;

	static double b1RelativeSpeed = 0.75, b2RelativeSpeed = 0.5, b3RelativeSpeed = 0.1;

	static int bheight = 900, bwidth = 3600;

	static int borderR = 500, borderL = 200;

	static int dickeSpeed = 0, dickeMaxSpeed = 7, dickeGeducktMaxSpeed = 3, dickeAcc = 1;

	static boolean HitboxesShown = false;

	static boolean onFloor = false;

	static BufferedImage iDickeR, iDickeL, iDickeRSchritt, iDickeLSchritt, iDickeRGeduckt, iDickeRSchrittGeduckt,
			iDickeLGeduckt, iDickeLSchrittGeduckt;
	static BufferedImage ib1_1, ib1_2, ib2_1, ib2_2, if_1, if_2, ib3_1, ib3_2, iSchild;
	static BufferedImage iPilz1_1, iPilz1_2, iPilz2_1, iPilz2_2, iWurm_1, iWurm_2, iWurm_3, iWurm_4, iWurm_5;
	static BufferedImage iFlammeItem, iFlügelItem, iSchildItem, iCoin1, iCoin2, iCoin3, iCoin4;
	static BufferedImage iTheEnd, iHJProductions;
	static BufferedImage iPlattform1, iPlattform2;
 

	static Coin coin1, coin2;

	static int coinBild = 1;

	// Schritt gibt an, ob iDicke oder iDicke-2 dran ist
	static boolean Schritt = false;

	static int Pilz1width = 120, Pilz1height = 120;

	static int Pilz1Anzahl = 5;

	static boolean GegnerBlinzelt = false;
	static int BlinzelAbstand = 5;

	static boolean imSpiel = false, imStart = true, inPause = false, imShop = false, inCredits = false;

	static boolean imWald = true, imDungeon = false, imBoss = false;

	static int CreditTransparenz = 255, CreditFortschritt = 0;

	static int despawnRange = -1200;

	static int rate = 15;

	public Var() {
		try {
			iDickeR = ImageIO.read(new File("rsc/ausgeschnittener-dicke.andersrum.png"));
			iDickeL = ImageIO.read(new File("rsc/ausgeschnittener-dicke.png"));
			iDickeRSchritt = ImageIO.read(new File("rsc/ausgeschnittener-dicke.andersrum-2.png"));
			iDickeLSchritt = ImageIO.read(new File("rsc/ausgeschnittener-dicke-2.png"));
			iDickeRGeduckt = ImageIO.read(new File("rsc/ausgeschnittener-dicke.andersrum-geduckt.png"));
			iDickeLGeduckt = ImageIO.read(new File("rsc/ausgeschnittener-dicke-geduckt.png"));
			iDickeRSchrittGeduckt = ImageIO.read(new File("rsc/ausgeschnittener-dicke.andersrum-2-geduckt.png"));
			iDickeLSchrittGeduckt = ImageIO.read(new File("rsc/ausgeschnittener-dicke-2-geduckt.png"));
			ib1_1 = ImageIO.read(new File("rsc/Background1.png"));
			ib1_2 = ImageIO.read(new File("rsc/Background1.png"));
			ib2_1 = ImageIO.read(new File("rsc/Background2.png"));
			ib2_2 = ImageIO.read(new File("rsc/Background2.png"));
			if_1 = ImageIO.read(new File("rsc/Foreground.png"));
			if_2 = ImageIO.read(new File("rsc/Foreground.png"));
			ib3_1 = ImageIO.read(new File("rsc/Background3.png"));
			ib3_2 = ImageIO.read(new File("rsc/Background3.png"));
			iPilz1_1 = ImageIO.read(new File("rsc/Pilz1.png"));
			iPilz1_2 = ImageIO.read(new File("rsc/Pilz1-blinzelnd.png"));
			iSchild = ImageIO.read(new File("rsc/Schild.png"));
			iSchildItem = ImageIO.read(new File("rsc/SchildItem.png"));
			iFlammeItem = ImageIO.read(new File("rsc/Item-Feuer.png"));
			iFlügelItem = ImageIO.read(new File("rsc/Item-Flügel.png"));
			iCoin1 = ImageIO.read(new File("rsc/Münze.vorne.png"));
			iCoin2 = ImageIO.read(new File("rsc/Münze.vorne.links.png"));
			iCoin3 = ImageIO.read(new File("rsc/Münze.seitlich.png"));
			iCoin4 = ImageIO.read(new File("rsc/Münze.vorne.rechts.png"));
			iPilz2_1 = ImageIO.read(new File("rsc/Pilz2.png"));
			iPilz2_2 = ImageIO.read(new File("rsc/Pilz2-blinzelnd.png"));
			iWurm_1 = ImageIO.read(new File("rsc/Gegner3.1.png"));
			iWurm_2 = ImageIO.read(new File("rsc/Gegner3.4.png"));
			iWurm_3 = ImageIO.read(new File("rsc/Gegner3.6.png"));
			iWurm_4 = ImageIO.read(new File("rsc/Gegner3.8.png"));
			iWurm_5 = ImageIO.read(new File("rsc/Gegner3.8blinzelnd.png"));
			iTheEnd = ImageIO.read(new File("rsc/TheEnd.png"));
			iPlattform1 = ImageIO.read(new File("rsc/Plattform.1.png"));
			iPlattform2 = ImageIO.read(new File("rsc/Plattform.2.png"));
			iHJProductions = ImageIO.read(new File("rsc/Hauberl&Jopp_Productions.png"));
		} catch (IOException e) {
			System.out.println("Bilder konnten nicht geladen werden ):");
			e.printStackTrace();
		}
		

	}

	static void wait(int t) {
		try {
			new Thread();
			Thread.sleep(t);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
