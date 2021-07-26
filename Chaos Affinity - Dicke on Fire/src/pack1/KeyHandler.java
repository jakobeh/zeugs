package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		//player1
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Main.p1.jump = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Main.p1.moveleft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Main.p1.moveright = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Main.p1.duck = true;
		}
		//player2
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Main.p2.jump = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.p2.moveleft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.p2.duck = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Main.p2.moveright = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//player1
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Main.p1.jump = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Main.p1.moveleft = false;
			Main.p1.speed = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Main.p1.moveright = false;
			Main.p1.speed = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Main.p1.duck = false;
		}
		//player2
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Main.p2.jump = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.p2.moveleft = false;
			Main.p2.speed = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Main.p2.moveright = false;
			Main.p2.speed = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.p2.duck = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public KeyHandler() {
	}
}
