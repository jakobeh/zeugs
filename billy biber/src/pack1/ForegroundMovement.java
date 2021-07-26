package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class ForegroundMovement {

	Timer fmovement;

	public ForegroundMovement() {
		fmovement = new Timer();
		fmovement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.duck == false) {
					if (Var.moveright) {
						if (Var.playerx >= 500) {
							if (Var.foregroundx1 >= -800) {
								Var.foregroundx1 -= Var.playerspeed;
							} else {
								Var.foregroundx1 = 800;
							}
							if (Var.foregroundx2 >= -800) {
								Var.foregroundx2 -= Var.playerspeed;
							} else {
								Var.foregroundx2 = 800;
							}
						}
					}

					if (Var.moveleft && Var.moveright == false) {
						if (Var.playerx <= 100) {
							if (Var.foregroundx1 <= 800) {
								Var.foregroundx1 += Var.playerspeed;
							} else {
								Var.foregroundx1 = -800;
							}
							if (Var.foregroundx2 <= 800) {
								Var.foregroundx2 += Var.playerspeed;
							} else {
								Var.foregroundx2 = -800;
							}
						}
					}
				}

			}

		}, 0, 15);
	}

}
