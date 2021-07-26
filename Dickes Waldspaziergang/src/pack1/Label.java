package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Label extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// background
		g.setColor(new Color(102, 255, 255));
		g.fillRect(0, 0, Var.screenwidth, Var.screenwidth);

		// b3
		// b3_1
		g.drawImage(Var.ib3_1, (int) Var.b3_1X, -150, Var.bwidth, Var.bheight, null);
		// b3_2
		g.drawImage(Var.ib3_2, (int) Var.b3_2X, -150, Var.bwidth, Var.bheight, null);

		// b2
		// b2_1
		g.drawImage(Var.ib2_1, (int) Var.b2_1X, 0, Var.bwidth, Var.bheight, null);
		// b2_2
		g.drawImage(Var.ib2_2, (int) Var.b2_2X, 0, Var.bwidth, Var.bheight, null);

		// b1
		// b1_1
		g.drawImage(Var.ib1_1, (int) Var.b1_1X, -100, Var.bwidth, Var.bheight, null);
		// b1_2
		g.drawImage(Var.ib1_2, (int) Var.b1_2X, -100, Var.bwidth, Var.bheight, null);
		// Vordergrund
		// f_1
		g.drawImage(Var.if_1, (int) Var.f_1X, -35, Var.bwidth, Var.bheight, null);
		// f_2
		g.drawImage(Var.if_2, (int) Var.f_2X, -35, Var.bwidth, Var.bheight, null);

		// Gegner
		// Pilz1
		if (Var.GegnerBlinzelt == false) {
			g.drawImage(Var.iPilz1_1, (int) Pilz1.x, Pilz1.y, Var.Pilz1width, Var.Pilz1height, null);
		} else if (Var.GegnerBlinzelt) {
			g.drawImage(Var.iPilz1_2, (int) Pilz1.x, Pilz1.y, Var.Pilz1width, Var.Pilz1height, null);
		}
		// Pilz2
		if (Var.GegnerBlinzelt == false) {
			g.drawImage(Var.iPilz2_1, (int) Pilz2.x, Pilz2.y, Pilz2.width, Pilz2.height, null);
		} else if (Var.GegnerBlinzelt) {
			g.drawImage(Var.iPilz2_2, (int) Pilz2.x, Pilz2.y, Pilz2.width, Pilz2.height, null);
		}

		// Wurm
		switch (Wurm.status) {
		case 1:
			g.drawImage(Var.iWurm_1, (int) Wurm.x, Wurm.y, Wurm.widthI, Wurm.heightI, null);
			break;
		case 2:
			g.drawImage(Var.iWurm_2, (int) Wurm.x, Wurm.y, Wurm.widthI, Wurm.heightI, null);
			break;
		case 3:
			g.drawImage(Var.iWurm_3, (int) Wurm.x, Wurm.y, Wurm.widthI, Wurm.heightI, null);
			break;
		case 4:
			g.drawImage(Var.iWurm_4, (int) Wurm.x, Wurm.y, Wurm.widthI, Wurm.heightI, null);
			break;
		case 5:
			g.drawImage(Var.iWurm_5, (int) Wurm.x, Wurm.y, Wurm.widthI, Wurm.heightI, null);
			break;
		}

		

		// Coins
		// Coin1
		if (Var.coinBild == 1) {
			g.drawImage(Var.iCoin1, (int) Var.coin1.x, Var.coin1.y, Coin.width, Coin.height, null);
		} else if (Var.coinBild == 2) {
			g.drawImage(Var.iCoin2, (int) Var.coin1.x, Var.coin1.y, Coin.width, Coin.height, null);
		} else if (Var.coinBild == 3) {
			g.drawImage(Var.iCoin3, (int) Var.coin1.x, Var.coin1.y, Coin.width, Coin.height, null);
		} else if (Var.coinBild == 4) {
			g.drawImage(Var.iCoin4, (int) Var.coin1.x, Var.coin1.y, Coin.width, Coin.height, null);
		}

		// Coin2
		if (Var.coinBild == 1) {
			g.drawImage(Var.iCoin1, (int) Var.coin2.x, Var.coin2.y, Coin.width, Coin.height, null);
		} else if (Var.coinBild == 2) {
			g.drawImage(Var.iCoin2, (int) Var.coin2.x, Var.coin2.y, Coin.width, Coin.height, null);
		} else if (Var.coinBild == 3) {
			g.drawImage(Var.iCoin3, (int) Var.coin2.x, Var.coin2.y, Coin.width, Coin.height, null);
		} else if (Var.coinBild == 4) {
			g.drawImage(Var.iCoin4, (int) Var.coin2.x, Var.coin2.y, Coin.width, Coin.height, null);
		}

		// dicke
		// nach rechts
		if (Var.dickeVisible) {
			if (Var.lookright || (Var.lookright && Var.lookleft) || (Var.lookright == false && Var.lookleft == false)
					|| Var.moveright) {

				if (Var.duck == false) {
					if (Var.Schritt) {
						g.drawImage(Var.iDickeRSchritt, Var.dickeX, Var.dickeY, Var.dickewidth, Var.dickeheight, null);
					} else if (Var.Schritt == false) {
						g.drawImage(Var.iDickeR, Var.dickeX, Var.dickeY, Var.dickewidth, Var.dickeheight, null);
					}
				} else if (Var.duck) {
					if (Var.Schritt) {
						g.drawImage(Var.iDickeRSchrittGeduckt, Var.dickeX, Var.dickeY, Var.dickewidth, Var.dickeheight,
								null);
					} else if (Var.Schritt == false) {
						g.drawImage(Var.iDickeRGeduckt, Var.dickeX, Var.dickeY, Var.dickewidth, Var.dickeheight, null);
					}
				}
			}
			// nach links
			else if (Var.lookleft || Var.moveleft) {
				if (Var.duck == false) {
					if (Var.Schritt) {
						g.drawImage(Var.iDickeLSchritt, Var.dickeX, Var.dickeY, Var.dickewidth, Var.dickeheight, null);
					} else if (Var.Schritt == false) {
						g.drawImage(Var.iDickeL, Var.dickeX, Var.dickeY, Var.dickewidth, Var.dickeheight, null);
					}
				} else if (Var.duck) {
					if (Var.Schritt) {
						g.drawImage(Var.iDickeLSchrittGeduckt, Var.dickeX, Var.dickeY, Var.dickewidth, Var.dickeheight,
								null);
					} else if (Var.Schritt == false) {
						g.drawImage(Var.iDickeLGeduckt, Var.dickeX, Var.dickeY, Var.dickewidth, Var.dickeheight, null);
					}
				}
			}
		} else if (Var.invincible) {

		}
		
		// Plattformen
		// 1
		g.drawImage(Var.iPlattform1, (int) Plattform1.x, (int) Plattform1.y, Plattform1.width, Plattform1.height, null);
		// 2
		g.drawImage(Var.iPlattform2, (int) Plattform2.x, (int) Plattform2.y, Plattform2.width, Plattform2.height, null);

		// Hitboxen
		if (Var.HitboxesShown) {
			// Dicke
			g.setColor(new Color(84, 100, 238, 120));
			if (Var.duck == false) {
				g.fillRect(Var.dickeX + 50, Var.dickeY, Var.dickewidth - 100, Var.dickeheight);
			} else if (Var.duck) {
				g.fillRect(Var.dickeX + 50, (int) (Var.dickeY + Var.dickeheight / 2), Var.dickewidth - 100,
						(int) (Var.dickeheight * 0.5));
			}
			// Boden
			g.setColor(new Color(128, 255, 0, 120));
			g.fillRect(0, Var.screenheight - Var.Bodenlevel, Var.screenwidth, Var.Bodenlevel);
			// Gegner
			// Pilz1
			g.setColor(new Color(125, 20, 0, 120));
			g.fillRect((int) Pilz1.x + 20, (int) Pilz1.y + 10, Var.Pilz1width - 40, Var.Pilz1height - 10);
			// Pilz2
			// Schadenshitbox(Hitbox1)
			g.setColor(new Color(125, 20, 0, 120));
			g.fillRect((int) Pilz2.x + 20, (int) Pilz2.y + 10, Pilz2.width - 40, Pilz2.height - 10);
			// Sprunghitbox(Hitbox2)
			g.setColor(new Color(0, 150, 0, 120));
			g.fillRect((int) Pilz2.x + 30, (int) Pilz2.y - 20, Pilz2.width - 60, Pilz2.height);
			// Wurm
			// Schadenshitbox(Hitbox1)
			g.setColor(new Color(125, 20, 0, 120));
			switch (Wurm.status) {
			case 1:
				break;
			case 2:
				g.fillRect((int) Wurm.x + 85, (int) Wurm.y + 145, Wurm.width, Wurm.height2 - 20);
				break;
			case 3:
				g.fillRect((int) Wurm.x + 85, (int) Wurm.y + 90, Wurm.width, Wurm.height3 - 20);
				break;
			case 4:
				g.fillRect((int) Wurm.x + 85, (int) Wurm.y + 20, Wurm.width, Wurm.height4 - 20);
				break;
			case 5:
				g.fillRect((int) Wurm.x + 85, (int) Wurm.y + 20, Wurm.width, Wurm.height4 - 20);
				break;
			}
			// Sprunghitbox(Hitbox2)
			g.setColor(new Color(0, 150, 0, 120));
			switch (Wurm.status) {
			case 1:
				break;
			case 2:
				g.fillRect((int) Wurm.x + 100, (int) Wurm.y + 115, Wurm.width - 30, Wurm.height2 + 10);
				break;
			case 3:
				g.fillRect((int) Wurm.x + 100, (int) Wurm.y + 60, Wurm.width - 30, Wurm.height3 + 10);
				break;
			case 4:
				g.fillRect((int) Wurm.x + 100, (int) Wurm.y - 10, Wurm.width - 30, Wurm.height4 + 10);
				break;
			case 5:
				g.fillRect((int) Wurm.x + 100, (int) Wurm.y - 10, Wurm.width - 30, Wurm.height4 + 10);
				break;
			}
			// Coins
			g.setColor(new Color(150, 150, 0, 120));
			g.fillRect((int) Var.coin1.x, (int) Var.coin1.y, Coin.width, Coin.height);
			g.fillRect((int) Var.coin2.x, (int) Var.coin2.y, Coin.width, Coin.height);
		}

		g.drawImage(Var.iSchild, 0, 0, 250, 250, null);
		g.setColor(new Color(255, 0, 0));
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Leben: " + Var.leben, 50, 100);
		g.drawString("Coins: " + Var.coins, 50, 150);

		if (Var.inPause)

		{
			g.setColor(new Color(128, 128, 128, 200));
			g.fillRect(0, 0, Var.screenwidth, Var.screenheight);
		}

		if (Var.inCredits) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Var.screenwidth, Var.screenheight);
			g.drawImage(Var.iTheEnd, 0, Var.CreditFortschritt + 200, 1150, 450, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Actors", 500, Var.CreditFortschritt + 900);
			g.setFont(new Font("Arial", Font.ITALIC, 50));
			g.drawString("Dicke", 100, Var.CreditFortschritt + 1000);
			g.drawString("the one and only Dicke", 500, Var.CreditFortschritt + 1000);
			g.drawString("Feuer-Dicke", 100, Var.CreditFortschritt + 1100);
			g.drawString("the incredible Dicke", 500, Var.CreditFortschritt + 1100);
			g.drawString("Flügel-Dicke", 100, Var.CreditFortschritt + 1200);
			g.drawString("the unmistakable Dicke", 500, Var.CreditFortschritt + 1200);
			g.drawString("Schild-Dicke", 100, Var.CreditFortschritt + 1300);
			g.drawString("the unbelievably cool Dicke", 500, Var.CreditFortschritt + 1300);
			g.drawString("Fliegenpilz", 100, Var.CreditFortschritt + 1400);
			g.drawString("Dwayne `the Rock` Johnson", 500, Var.CreditFortschritt + 1400);
			g.drawString("Pilz", 100, Var.CreditFortschritt + 1500);
			g.drawString("Robert Downey Jr.", 500, Var.CreditFortschritt + 1500);
			g.drawString("Münze", 100, Var.CreditFortschritt + 1600);
			g.drawString("Florian Silbereisen", 500, Var.CreditFortschritt + 1600);
			g.drawString("Maulwurf", 100, Var.CreditFortschritt + 1700);
			g.drawString("Angelina Jolie", 500, Var.CreditFortschritt + 1700);
			g.drawString("Fossil", 100, Var.CreditFortschritt + 1800);
			g.drawString("Daniel Radcliffe", 500, Var.CreditFortschritt + 1800);

			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Regie", 400, Var.CreditFortschritt + 2000);
			g.setFont(new Font("Arial", Font.ITALIC, 50));
			g.drawString("Jakob Ehneß", 600, Var.CreditFortschritt + 2000);

			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Programming", 400, Var.CreditFortschritt + 2200);
			g.setFont(new Font("Arial", Font.ITALIC, 50));
			g.drawString("Executive Programmers", 100, Var.CreditFortschritt + 2300);
			g.drawString("Johannes Gfüllner", 700, Var.CreditFortschritt + 2300);
			g.drawString("Jakob Ehneß", 700, Var.CreditFortschritt + 2400);
			g.drawString("Programming Assistants", 100, Var.CreditFortschritt + 2500);
			g.drawString("Johannes Gfüllner", 700, Var.CreditFortschritt + 2500);
			g.drawString("Jakob Ehneß", 700, Var.CreditFortschritt + 2600);
			g.drawString("Eclipse IDE", 700, Var.CreditFortschritt + 2700);

			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Artwork & Design", 400, Var.CreditFortschritt + 2900);
			g.setFont(new Font("Arial", Font.ITALIC, 50));
			g.drawString("Head of Artwork and Design", 100, Var.CreditFortschritt + 3000);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 3000);
			g.drawString("Executive Designer", 100, Var.CreditFortschritt + 3100);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 3100);
			g.drawString("Artwork and Design Assistant", 100, Var.CreditFortschritt + 3200);
			g.drawString("Jakob Ehneß", 800, Var.CreditFortschritt + 3200);
			g.drawString("paint.net", 800, Var.CreditFortschritt + 3300);

			g.drawString("Dicke (1-8)", 100, Var.CreditFortschritt + 3500);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 3500);
			g.drawString("Hintergrund (1-4)", 100, Var.CreditFortschritt + 3600);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 3600);
			g.drawString("Items (1-3)", 100, Var.CreditFortschritt + 3700);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 3700);
			g.drawString("Fliegenpilz (1-2)", 100, Var.CreditFortschritt + 3800);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 3800);
			g.drawString("Pilz (1-2)", 100, Var.CreditFortschritt + 3900);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 3900);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 4000);
			g.drawString("Münze (1-4)", 100, Var.CreditFortschritt + 4100);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 4100);
			g.drawString("Münze (1-4)", 100, Var.CreditFortschritt + 4100);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 4100);
			g.drawString("Anzeigetafel", 100, Var.CreditFortschritt + 4200);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 4200);
			g.drawString("The End", 100, Var.CreditFortschritt + 4300);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 4300);
			g.drawString("Hauberl & Jopp Productions Logo", 100, Var.CreditFortschritt + 4400);
			g.drawString("Jakob Ehneß", 900, Var.CreditFortschritt + 4400);

			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Music", 500, Var.CreditFortschritt + 4600);
			g.setFont(new Font("Arial", Font.ITALIC, 50));

			g.drawString("Head of Music", 100, Var.CreditFortschritt + 4700);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 4700);
			g.drawString("Executive Composers", 100, Var.CreditFortschritt + 4800);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 4800);
			g.drawString("Leo Bode", 750, Var.CreditFortschritt + 4900);
			g.drawString("Assistant of Music", 100, Var.CreditFortschritt + 5000);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 5000);
			g.drawString("Leo Bode", 750, Var.CreditFortschritt + 5100);
			g.drawString("Caustic3", 750, Var.CreditFortschritt + 5200);
			g.drawString("The Forest Raider", 100, Var.CreditFortschritt + 5400);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 5400);
			g.drawString("Leo Bode", 750, Var.CreditFortschritt + 5500);
			g.drawString("The Dungeon Raider", 100, Var.CreditFortschritt + 5600);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 5600);
			g.drawString("Leo Bode", 750, Var.CreditFortschritt + 5700);

			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Soundeffects", 500, Var.CreditFortschritt + 5900);
			g.setFont(new Font("Arial", Font.ITALIC, 50));
			g.drawString("Director of Downloading", 100, Var.CreditFortschritt + 6000);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 6000);
			g.drawString("Head of Soundeffects", 100, Var.CreditFortschritt + 6100);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 6100);
			g.drawString("Executive Downloader", 100, Var.CreditFortschritt + 6200);
			g.drawString("Jakob Ehneß", 750, Var.CreditFortschritt + 6200);
			g.drawString("Soundeffects Assistant", 100, Var.CreditFortschritt + 6300);
			g.drawString("Johannes Gfüllner", 750, Var.CreditFortschritt + 6300);
			g.drawString("Freesound.org", 750, Var.CreditFortschritt + 6400);

			g.drawString(".-- . .-.   -.. .- ...   .-.. .. . ... -   -.- .- -. -.", 100, Var.CreditFortschritt + 6500);
			g.drawString("-- --- .-. ... . -.-. --- -.. .", 100, Var.CreditFortschritt + 6600);
			g.drawString("--- -.. . .-.   .... .- -", 100, Var.CreditFortschritt + 6700);
			g.drawString("-. .- -.-. .... --. . ... -.-. .... .- ..- -", 100, Var.CreditFortschritt + 6800);

			g.drawString("Mitarbeiter des Monats", 100, Var.CreditFortschritt + 6900);
			g.drawString("die Würfelqualle", 700, Var.CreditFortschritt + 6900);

			g.drawImage(Var.iHJProductions, 0, Var.CreditFortschritt + 7000, 1200, 650, null);

			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("some rights reserved", 400, Var.CreditFortschritt + 7650);

			g.drawString("Im Übrigen denke ich, dass Faschismus keine Meinung ist, sondern eine Katastrophe", 20,
					Var.CreditFortschritt + 7750);

			g.setColor(new Color(0, 0, 0, Var.CreditTransparenz));
			g.fillRect(0, 0, Var.screenwidth, Var.screenheight);
		}

		repaint();

	}

	public Label() {

	}
}
