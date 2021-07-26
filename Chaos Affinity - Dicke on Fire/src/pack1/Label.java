package pack1;

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
		
		// Gegner
		// SpikeShroom
		
		// player
		// p1
		g.setColor(Main.p1.HitboxColor);
		g.fillRect((int) Main.p1.x, (int) Main.p1.y, Main.p1.width, Main.p1.height);
		// p2
		g.setColor(Main.p2.HitboxColor);
		g.fillRect((int) Main.p2.x, (int) Main.p2.y, Main.p2.width, Main.p2.height);

		repaint();
	}

	public Label() {
	}

}
