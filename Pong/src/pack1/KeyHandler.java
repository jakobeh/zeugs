package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		
		//player1
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Var.p1moveup = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Var.p1movedown = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Var.p1moveleft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Var.p1moveright = true;
		}
		
		//player2
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.p2moveup = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.p2movedown = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Var.p2moveleft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Var.p2moveright = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		//player1
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Var.p1moveup = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Var.p1movedown = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Var.p1moveleft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Var.p1moveright = false;
		}
		
		//player2
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.p2moveup = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.p2movedown = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Var.p2moveleft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Var.p2moveright = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
