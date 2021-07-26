package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class BackgroundMovement {
	Timer bmovement;

	public BackgroundMovement() {
		bmovement = new Timer();
		bmovement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.duck == false) {
					if (Var.moveright) {
						if (Var.playerx >= 500) {
							if (Var.backgroundx1 >= -800) {
								Var.backgroundx1 -= (Var.playerspeed / 3);
							} else {
								Var.backgroundx1 = 800;
							}
							if (Var.backgroundx2 >= -800) {
								Var.backgroundx2 -= (Var.playerspeed / 3);
							} else {
								Var.backgroundx2 = 800;
							}
							
							// Wald vorne
							
							if (Var.background2x1 >= -800) {
								Var.background2x1 -= (Var.playerspeed / 2);
							} else {
								Var.background2x1 = 800;
							}
							if (Var.background2x2 >= -800) {
								Var.background2x2 -= (Var.playerspeed / 2);
							} else {
								Var.background2x2 = 800;
							}
						}
					}

					else if (Var.moveleft) {
						if (Var.playerx <= 100) {
							if (Var.backgroundx1 <= 800) {
								Var.backgroundx1 += (Var.playerspeed / 3);
							} else {
								Var.backgroundx1 = -800;
							}
							if (Var.backgroundx2 <= 800) {
								Var.backgroundx2 += (Var.playerspeed / 3);
							} else {
								Var.backgroundx2 = -800;
							}
							
							// Wald vorne
							
							if (Var.background2x1 <= 800) {
								Var.background2x1 += (Var.playerspeed / 2);
							} else {
								Var.background2x1 = -800;
							}
							if (Var.background2x2 <= 800) {
								Var.background2x2 += (Var.playerspeed / 2);
							} else {
								Var.background2x2 = -800;
							}
						}
					}
				}

			}

		}, 0, 15);
	}

}
