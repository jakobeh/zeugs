package pack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JLabel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EA ea;
	int znr = 0;

	JFrame jf;
	Rectangle[] hitbox;
	boolean[] drawing;

	public GUI() {
		ea = new EA();

		jf = new JFrame("Endliche Vollautomate");
		jf.setSize(1600, 900);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(this);
		jf.addMouseListener(this);

		hitbox = new Rectangle[] { new Rectangle(1400, 50, 120, 70), new Rectangle(1400, 170, 120, 70),
				new Rectangle(1395, 295, 130, 80), new Rectangle(1400, 420, 70, 60) };
		drawing = new boolean[4];
	}

	protected void paintComponent(Graphics g) {
		g.setColor(new Color(128, 128, 128));
		g.fillRect(1300, 0, 300, 900);
		g.setColor(Color.BLACK);
		g.drawRect(1300, 0, 300, 900);

		g.setColor(new Color(200, 200, 200));
		g.fillRoundRect(1400, 50, 120, 70, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(1400, 50, 120, 70, 20, 20);
		g.drawLine(1360, 85, 1400, 85);
		g.fillPolygon(new int[] { 1390, 1390, 1400 }, new int[] { 82, 88, 85 }, 3);

		g.setColor(new Color(200, 200, 200));
		g.fillRoundRect(1400, 170, 120, 70, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(1400, 170, 120, 70, 20, 20);

		g.setColor(new Color(200, 200, 200));
		g.fillRoundRect(1395, 295, 130, 80, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(1395, 295, 130, 80, 20, 20);
		g.drawRoundRect(1400, 300, 120, 70, 20, 20);

		g.drawLine(1400, 450, 1470, 450);
		g.fillPolygon(new int[] { 1465, 1465, 1470 }, new int[] { 453, 447, 450 }, 3);

		ArrayList<Zustand> zustand = ea.getZustand();
		for (int i = 0; i < zustand.size(); i++) {
			Point p = zustand.get(i).getPos();
			g.setColor(new Color(200, 200, 200));
			g.fillRoundRect((int) p.getX(), (int) p.getY(), 130, 80, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRoundRect((int) p.getX(), (int) p.getY(), 130, 80, 20, 20);
		}

		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println();
		System.out.println("click: " + e.getX() + " " + e.getY());
		System.out.println(Arrays.toString(drawing));
		if (e.getX() > 1300) {
			System.out.println("in the grey");
			for (int i = 0; i < hitbox.length; i++) {
				if (hitbox[i].contains(e.getPoint())) {
					System.out.println("hitbox " + i);
					drawing[i] = (drawing[i]) ? false : true;
					
					for (int j = 0; j < drawing.length; j++) {
						if (i != j) {
							drawing[j] = false;
						}
					}
					System.out.println("now " + Arrays.toString(drawing));
				}
			}
		} else {
			System.out.println("NOT in the grey");
			for (int i = 0; i < drawing.length; i++) {
				if (drawing[i]) {
					switch (i) {
					case 0:
						System.out.println(" case 0");
						ea.addZustand(new Zustand("z" + znr++, true, false, e.getPoint()), true);
						break;
					case 1:
						System.out.println(" case 1");
						ea.addZustand(new Zustand("z" + znr++, false, false, e.getPoint()), false);
						break;
					case 2:
						System.out.println(" case 2");
						ea.addZustand(new Zustand("z" + znr++, false, true, e.getPoint()), false);
						break;
					case 3:
						System.out.println(" case 3");
						break;
					}
					System.out.println(ea.getZustand().toString());
					drawing[i] = false;
				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
