package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Var.moveright = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Var.moveleft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.duck = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.jump = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (Var.imSpiel) {
				Var.imSpiel = false;
				Var.imMenu = true;
				
				Var.btnexit.setVisible(true);
				Var.btnresume.setVisible(true);
				Var.btnoptionen.setVisible(true);
				Var.btnshop.setVisible(true);
				
			} else if (Var.imMenu || Var.inOptionen || Var.imShop) {
				Var.imMenu = false;
				Var.inOptionen = false;
				Var.imShop = false;
				Var.imSpiel = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (Var.imStart || Var.imGameover) {
				Var.imStart = false;
				Var.imGameover = false;
				Var.imSpiel = true;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Var.moveright = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Var.moveleft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.duck = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.jump = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
