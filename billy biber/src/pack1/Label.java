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
	private static final long serialVersionUID = 9110779334058040187L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (Var.imStart) {

			// Background
			// Blau
			g.setColor(new Color(0, 128, 255));
			g.fillRect(0, 0, Var.screenwidth, Var.screenheight);

			// Biber
			if (Var.startBiberAnimation == 1) {
				g.drawImage(Var.iBiber, 100, 0, 600, 600, null);
			} else if (Var.startBiberAnimation == 2) {
				g.drawImage(Var.iBiber, 700, 0, -600, 600, null);
			}

			// Titel
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 100));
			g.drawString("BILLY BIBER", 80, 300);

			repaint();
		} else if (Var.imGameover) {
			// Background
			// Grau
			g.drawImage(Var.idungeon1, 0, 0, Var.screenwidth, Var.screenheight, null);
			// Biber

			if (Var.startBiberAnimation == 1) {
				g.drawImage(Var.iBiber, 100, 0, 600, 600, null);
			} else if (Var.startBiberAnimation == 2) {
				g.drawImage(Var.iBiber, 700, 0, -600, 600, null);
			}
			// sad Emoji

			if (Var.startBiberAnimation == 1) {
				g.drawImage(Var.iBiber, 100, 0, 600, 600, null);
				g.drawImage(Var.iSadEmoji, 95, 50, 300, 300, null);
			} else if (Var.startBiberAnimation == 2) {
				g.drawImage(Var.iBiber, 700, 0, -600, 600, null);
				g.drawImage(Var.iSadEmoji, 445, 50, 300, 300, null);
			}

			// Schrift
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 100));
			g.drawString("GAME OVER", 100, 200);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Coins gesammelt: " + Var.altcoins, 100, 300);
			g.drawString("Coins nächste Runde: " + Var.coins, 100, 350);

			repaint();
		} else if (Var.imMenu) {
			// Background
			g.setColor(new Color(0, 180, 23));
			g.fillRect(0, 0, Var.screenwidth, Var.screenheight);
			// Biber
			if (Var.startBiberAnimation == 1) {
				g.drawImage(Var.iBiber, 100, 0, 600, 600, null);
			} else if (Var.startBiberAnimation == 2) {
				g.drawImage(Var.iBiber, 700, 0, -600, 600, null);
			}

			repaint();
		} else if (Var.imSpiel) {
			// grün
			g.setColor(new Color(38, 150, 15));
			g.fillRect(0, 0, Var.screenwidth, Var.screenheight);

			// Wald1
			g.drawImage(Var.iWald1, Var.backgroundx1, 0, 802, 600, null);
			g.drawImage(Var.iWald2, Var.backgroundx2, 0, 802, 600, null);

			// Wald2
			g.drawImage(Var.iWald3, Var.background2x1, 50, 802, 600, null);
			g.drawImage(Var.iWald4, Var.background2x2, 50, 802, 600, null);

			// Boden
			g.drawImage(Var.iBoden1, Var.foregroundx1, 400 + Var.playerheight, 820, 100, null);
			g.drawImage(Var.iBoden2, Var.foregroundx2, 400 + Var.playerheight, 820, 100, null);

			// Gegner
			// Stumpf
			for (int i = 0; i <= 4; i++) {
				g.drawImage(Var.iStumpf, Var.Stumpfx[i], Var.Stumpfy, Var.Stumpfwidth, Var.Stumpfheight, null);
			}

			// Biber
			// nicht geduckt
			if (Var.duck == false) {
				if (Var.moveleft) {
					g.drawImage(Var.iBiber, Var.playerx - (Var.playerwidth / 2), Var.playery, Var.playerwidth,
							Var.playerheight, null);
				} else {
					g.drawImage(Var.iBiber, Var.playerx + (Var.playerwidth / 2), Var.playery, -Var.playerwidth,
							Var.playerheight, null);
				}

				// geduckt
			} else if (Var.duck) {
				if (Var.moveleft) {
					g.drawImage(Var.iBiber, Var.playerx - 40, Var.playery + Var.playerheight / 2, Var.playerwidth,
							Var.playerheight / 2, null);
				} else {
					g.drawImage(Var.iBiber, Var.playerx + 40, Var.playery + Var.playerheight / 2, -Var.playerwidth,
							Var.playerheight / 2, null);
				}
			}

			// Schrift
			// Leben
			g.setColor(new Color(0, 153, 0));
			g.setFont(new Font("Arial", Font.BOLD, 45));
			g.drawString("Leben: " + Var.leben, 20, 50);
			g.setFont(new Font("Arial", Font.BOLD, 25));
			g.drawString("/ " + Var.maxleben, 220, 50);

			// Coins
			g.setColor(new Color(0, 153, 0));
			g.setFont(new Font("Arial", Font.BOLD, 45));
			g.drawString("Coins: " + Var.coins, 20, 100);

			// getroffen
			// Flackern
			if (Var.getroffenanimation > 0) {
				g.setColor(new Color(250, 0, 0, 150));
				g.fillRect(0, 0, Var.screenwidth, Var.screenheight);
			}

			repaint();

		}
	}

}
