package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public KeyHandler() {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (Var.imSpiel) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				Var.moveright = true;
				Var.lookright = true;
				Var.lookleft = false;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				Var.moveleft = true;
				Var.lookright = false;
				Var.lookleft = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				Var.jumpHold = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Var.duck = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_H) {
				if (Var.HitboxesShown) {
					Var.HitboxesShown = false;
				} else if (Var.HitboxesShown == false) {
					Var.HitboxesShown = true;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Var.imSpiel = false;
				Var.inPause = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				Var.imSpiel = false;
				Var.imWald = false;
				Var.imDungeon = false;
				Var.imBoss = false;
				Var.inCredits = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_L) {
				Var.leben++;
			}
			if (e.getKeyCode() == KeyEvent.VK_C) {
				Var.coins *= 2;
			}
		} else if (Var.inPause)

		{
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Var.inPause = false;
				Var.imSpiel = true;
			}
		} else if (Var.imStart) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
				Var.imStart = false;
				Var.imSpiel = true;
			}
		} else if (Var.inCredits) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Var.inCredits = false;
				Var.inPause = true;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// if (Var.imSpiel) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Var.moveright = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Var.moveleft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Var.jumpHold = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Var.duck = false;
		}

		// }
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
