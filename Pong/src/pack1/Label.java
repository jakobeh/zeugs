package pack1;

import java.awt.Color;
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
		g.drawImage(Var.ib1, 0, 0, Var.screenwidth, Var.screenheight, null);

		// players
		// 1
		g.drawImage(Var.ip1, Var.p1x - Var.pradius / 2, Var.p1y - Var.pradius / 2, Var.pradius, Var.pradius, null);
		// 2
		g.drawImage(Var.ip2, Var.p2x - Var.pradius / 2, Var.p2y - Var.pradius / 2, Var.pradius, Var.pradius, null);
		
		//ball
		g.drawImage(Var.iball, Var.ballx - Var.ballradius / 2, Var.bally - Var.ballradius / 2, Var.ballradius, Var.ballradius, null);
		
		//barrier
		g.setColor(new Color(100, 100, 0, 128));
		g.fillRect(580, 0, 40, Var.screenheight);
		
		//Goal
		//1
		g.setColor(new Color(0, 50, 240, 128));
		g.fillRect(0, 0, 50, Var.screenheight);
		
		//2
		g.setColor(new Color(240, 50, 0, 128));
		g.fillRect(1150, 0, 50, Var.screenheight);
		
		repaint();
	}

	public Label() {
	}

}
