package pack1;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Main {
	static player p1;
	static player p2;
	static world w1;
	static world w2;

	public static void main(String[] args) {
		
		//Grafik laden
		new Image();
		
		// WorldGeneration
		w1 = new world(1);
		w1.generateBlueprints();
		w2 = new world(2);
		w2.shuffleWorld(w1);
		w1.generateSegments();
		w2.generateSegments();
		w1.printWorld();
		w2.printWorld();
		

		// GUI erstellen
		// Jframe erstellen und einrichten
		screen.jf = new JFrame();
		screen.jf.setSize(screen.width, screen.height);
		screen.jf.setTitle(screen.title);
		screen.jf.setLocationRelativeTo(null);
		screen.jf.setResizable(false);
		screen.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.jf.setVisible(true);
		// Label erstellen
		screen.lb = new Label();
		screen.jf.add(screen.lb);
		screen.lb.setBounds(0, 0, screen.width, screen.height);
		// KeyHandler hinzufügen
		screen.jf.addKeyListener(new KeyHandler());
		screen.jf.requestFocus();
		// player erstellen
		// p1
		p1 = new player(100, 700, "R", 1);
		// p2
		p2 = new player(1650, 700, "L", 2);

		// Timer
		// Timer erstellen
		general.game = new Timer();
		general.game.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// Playermovement
				//p1
				if (p1.moveright && p1.x < screen.width / 2 - 150) {
					if (p1.speed < p1.maxspeed) {
						if (p1.acctemp == p1.maxacctemp) {
							p1.speed += p1.acc;
							p1.acctemp = 0;
						} else if (p1.acctemp < p1.maxacctemp) {
							p1.acctemp++;
						}
					}
					p1.x += p1.speed;
				}
				if (p1.moveleft && p1.x > 50) {
					if (p1.speed < p1.maxspeed) {
						if (p1.acctemp == p1.maxacctemp) {
							p1.speed += p1.acc;
							p1.acctemp = 0;
						} else if (p1.acctemp < p1.maxacctemp) {
							p1.acctemp++;
						}
					}
					p1.x -= p1.speed;
				}
				//p2
				if (p2.moveright && p2.x < 1650) {
					if (p2.speed < p2.maxspeed) {
						if (p2.acctemp == p2.maxacctemp) {
							p2.speed += p2.acc;
							p2.acctemp = 0;
						} else if (p2.acctemp < p2.maxacctemp) {
							p2.acctemp++;
						}
					}
					p2.x += p2.speed;
				}
				if (p2.moveleft && p2.x > screen.width / 2 + 50) {
					if (p2.speed < p2.maxspeed) {
						if (p2.acctemp == p2.maxacctemp) {
							p2.speed += p2.acc;
							p2.acctemp = 0;
						} else if (p2.acctemp < p2.maxacctemp) {
							p2.acctemp++;
						}
					}
					p2.x -= p2.speed;
				}
			}

		}, 0, general.rate);
	}

}
