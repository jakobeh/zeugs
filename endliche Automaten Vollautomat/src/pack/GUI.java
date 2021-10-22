package pack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JLabel implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EA ea;
	int znr = 0;

	JFrame jf;
	Rectangle[] hitbox;
	int draggingArrowFrom = -1, draggingArrowTo = -1;

	JButton bConfirm = null, bConfirm1 = null, bCancel = null, bCheck = null;
	JTextField jt = null;
	JFrame jfPath = null;
//	boolean[] drawing;

	public GUI() {
		ea = new EA();

		jf = new JFrame("Endliche AuaTomate");
		jf.setSize(1600, 900);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setMenuBar(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(this);
		setBounds(0, 0, jf.getWidth(), jf.getHeight());
		jf.addMouseListener(this);

		bCheck = new JButton("Check word");
		jf.add(bCheck);
		bCheck.setBounds(1350, 600, 200, 50);
		bCheck.addActionListener(this);

//		hitbox = new Rectangle[] { new Rectangle(1400, 50, 120, 70), new Rectangle(1400, 170, 120, 70),
//				new Rectangle(1395, 295, 130, 80), new Rectangle(1400, 420, 70, 60) };
//		drawing = new boolean[4];
	}

	protected void paintComponent(Graphics g) {
		g.setColor(new Color(128, 128, 128));
		g.fillRect(1300, 0, 300, 500);
		g.setColor(Color.BLACK);
		g.drawRect(1300, 0, 300, 500);

		g.setColor(new Color(200, 200, 200));
		g.fillRoundRect(1400, 50, 120, 70, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(1400, 50, 120, 70, 20, 20);
		g.drawLine(1360, 85, 1400, 85);
		g.fillPolygon(new int[] { 1390, 1390, 1400 }, new int[] { 82, 88, 85 }, 3);
		g.drawString("start", 1420, 70);

		g.setColor(new Color(200, 200, 200));
		g.fillRoundRect(1400, 170, 120, 70, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(1400, 170, 120, 70, 20, 20);
		g.drawString("zustand", 1420, 190);

		g.setColor(new Color(200, 200, 200));
		g.fillRoundRect(1395, 295, 130, 80, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(1395, 295, 130, 80, 20, 20);
		g.drawRoundRect(1400, 300, 120, 70, 20, 20);
		g.drawString("ende", 1420, 320);

		g.drawLine(1400, 450, 1470, 450);
		g.fillPolygon(new int[] { 1465, 1465, 1470 }, new int[] { 453, 447, 450 }, 3);
		g.drawString("Übergang", 1420, 470);

		ArrayList<Zustand> zustand = ea.getZustand();
		char[][][] matrix = ea.getMatrix();
		System.out.println(matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("-" + matrix[i].length);
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != null) {
					Zustand z1 = zustand.get(i), z2 = zustand.get(j);
					int x1 = (int) z1.getHitbox().getCenterX(), y1 = (int) z1.getHitbox().getCenterY(),
							x2 = (int) z2.getHitbox().getCenterX(), y2 = (int) z2.getHitbox().getCenterY(),
							mx = (x1 + x2) / 2, my = (y1 + y2) / 2;
					g.drawLine(x1, y1, x2, y2);
					g.drawString(Arrays.toString(matrix[i][j]), mx, my);
//					double h = Math.sin(3 * Math.atan((x2 - x1) / (y2 - y1))),
//							b = Math.cos(3 * Math.atan((x2 - x1) / (y2 - y1))),
//							length = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)),
//							dx = 5 * Math.cos(Math.atan((x2 - x1) / (y2 - y1))) * ((x1 < x2) ? -1 : 1),
//							dy = 5 * Math.sin(Math.atan((x2 - x1) / (y2 - y1))) * ((x1 < x2) ? -1 : 1),
//							mx = (x1 + x2) / 2, my = (y1 + y2) / 2;
//					g.fillPolygon(new int[] { (int) (mx + dx), (int) (mx + b), (int) (mx - b) },
//							new int[] { (int) (mx + dy), (int) (my + h), (int) (my - h) }, 3);
				}
			}
		}

		for (int i = 0; i < zustand.size(); i++) {
			Zustand z = zustand.get(i);
			Point p = z.getPos();
			g.setColor(new Color(200, 200, 200));
			g.fillRoundRect((int) p.getX(), (int) p.getY(), 130, 80, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRoundRect((int) p.getX(), (int) p.getY(), 130, 80, 20, 20);
			if (z.isEnd()) {
				g.drawRoundRect((int) p.getX() + 5, (int) p.getY() + 5, 120, 70, 15, 15);
			}
			if (z.isStart()) {
				g.drawLine((int) p.getX() - 70, (int) p.getY() + 40, (int) p.getX(), (int) p.getY() + 40);
				g.fillPolygon(new int[] { (int) p.getX() - 5, (int) p.getX() - 5, (int) p.getX() },
						new int[] { (int) p.getY() + 37, (int) p.getY() + 43, (int) p.getY() + 40 }, 3);
			}
			g.drawString(z.getName(), (int) p.getX() + 20, (int) p.getY() + 20);
		}

		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println();
		System.out.println("click: " + e.getX() + " " + e.getY());
//		System.out.println(Arrays.toString(drawing));
//		if (e.getX() > 1300) {
//			System.out.println("in the grey");
//			for (int i = 0; i < hitbox.length; i++) {
//				if (hitbox[i].contains(e.getPoint())) {
//					System.out.println("hitbox " + i);
//					drawing[i] = (drawing[i]) ? false : true;
//					
//					for (int j = 0; j < drawing.length; j++) {
//						if (i != j) {
//							drawing[j] = false;
//						}
//					}
//					System.out.println("now " + Arrays.toString(drawing));
//				}
//			}
//		} else {
//			System.out.println("NOT in the grey");
//			for (int i = 0; i < drawing.length; i++) {
//				if (drawing[i]) {
//					switch (i) {
//					case 0:
//						System.out.println(" case 0");
//						ea.addZustand(new Zustand("z" + znr++, true, false, e.getPoint()), true);
//						break;
//					case 1:
//						System.out.println(" case 1");
//						ea.addZustand(new Zustand("z" + znr++, false, false, e.getPoint()), false);
//						break;
//					case 2:
//						System.out.println(" case 2");
//						ea.addZustand(new Zustand("z" + znr++, false, true, e.getPoint()), false);
//						break;
//					case 3:
//						System.out.println(" case 3");
//						break;
//					}
//					System.out.println(ea.getZustand().toString());
//					drawing[i] = false;
//				}
//			}
//		}
		Point p = e.getPoint();
		ArrayList<Zustand> zustand = ea.getZustand();
		p.move((int) p.getX(), (int) p.getY() - 30);
		if (e.getButton() == MouseEvent.BUTTON1) {
			System.out.println("lmb");
			if (p.getX() > 1220) {
				return;
			}
			for (int i = 0; i < zustand.size(); i++) {
				Zustand z = zustand.get(i);
				if (zustand.get(i).getHitbox().contains(p)) {
					if (e.isAltDown()) {
						z.switchEnd();
					}
					if (e.isControlDown()) {
						z.switchStart();
						for (int j = 0; j < zustand.size(); j++) {
							if (i != j) {
								zustand.get(j).setStart(false);
							}
						}
					}
					if (!e.isAltDown() && !e.isControlDown()) {
						if (draggingArrowFrom == -1) {
							draggingArrowFrom = i;
						} else {
							draggingArrowTo = i;
							jfPath = new JFrame("Configure Übergang");
							jfPath.setLocationRelativeTo(null);
							jfPath.setSize(400, 300);
							jfPath.setVisible(true);
							jfPath.requestFocus();
							jfPath.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
							jfPath.setLayout(null);

							bConfirm = new JButton("Confirm");
							jfPath.add(bConfirm);
							bConfirm.setBounds(10, 200, 175, 40);
							bConfirm.addActionListener(this);

							bCancel = new JButton("Cancel");
							jfPath.add(bCancel);
							bCancel.setBounds(190, 200, 175, 40);
							bCancel.addActionListener(this);

							jt = new JTextField("a, b");
							jfPath.add(jt);
							jt.setBounds(10, 20, 360, 150);
							jt.setVisible(true);
						}

					}
					return;
				}
			}
			Zustand z = new Zustand("z" + znr++, false, false, p);
			boolean start = false;
			if (e.isAltDown()) {
				z.switchEnd();
			}
			if (e.isControlDown()) {
				z.switchStart();
				for (int j = 0; j < zustand.size(); j++) {
					zustand.get(j).setStart(false);
				}
			}
			ea.addZustand(z, start);
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("rmb");

			for (int i = 0; i < zustand.size(); i++) {
				Zustand z = zustand.get(i);
				if (zustand.get(i).getHitbox().contains(p)) {
					ea.removeZustand(z);
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

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bConfirm) {
			String[] s = jt.getText().split(", ");
			char[] chars = new char[s.length];
			for (int i = 0; i < s.length; i++) {
				chars[i] = s[i].charAt(0);
			}

			ea.addPath(draggingArrowFrom, draggingArrowTo, chars);
			draggingArrowFrom = -1;
			draggingArrowTo = -1;
			jfPath.dispose();
		}

		if (e.getSource() == bConfirm1) {
			String s = jt.getText();
			boolean erg = ea.check(s);
			System.out.println(s + " ist " + erg);
			jt.setText(s + " ist " + erg);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			jfPath.dispose();
		}

		if (e.getSource() == bCancel) {
			draggingArrowFrom = -1;
			draggingArrowTo = -1;
			jfPath.dispose();
		}

		if (e.getSource() == bCheck) {
			jfPath = new JFrame("Wort überprüfen");
			jfPath.setLocationRelativeTo(null);
			jfPath.setSize(400, 300);
			jfPath.setVisible(true);
			jfPath.requestFocus();
			jfPath.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			jfPath.setLayout(null);

			bConfirm1 = new JButton("Confirm");
			jfPath.add(bConfirm1);
			bConfirm1.setBounds(10, 200, 175, 40);
			bConfirm1.addActionListener(this);

			bCancel = new JButton("Cancel");
			jfPath.add(bCancel);
			bCancel.setBounds(190, 200, 175, 40);
			bCancel.addActionListener(this);

			jt = new JTextField("wort");
			jfPath.add(jt);
			jt.setBounds(10, 20, 360, 150);
			jt.setVisible(true);
		}

	}

}
