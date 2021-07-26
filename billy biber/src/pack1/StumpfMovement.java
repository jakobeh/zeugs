package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class StumpfMovement {
	Timer move;

	public StumpfMovement() {

		
		// Grundposition
		Var.Stumpfx[0] = (int) (Math.random() * 10000);
		Var.Stumpfx[1] = (int) (Math.random() * 11000);
		Var.Stumpfx[2] = (int) (Math.random() * 12000);
		Var.Stumpfx[3] = (int) (Math.random() * 13000);
		Var.Stumpfx[4] = (int) (Math.random() * 14000);

		
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				for (int i = 0; i <= 4; i++) {

					if (Var.Stumpfx[i] > Var.Stumpfdespawnx) {
						if (Var.playerx >= 500 && Var.moveright && Var.duck == false) {
							Var.Stumpfx[i] -= Var.playerspeed;
						} else if (Var.playerx <= 100 && Var.moveleft && Var.duck == false) {
							Var.Stumpfx[i] += Var.playerspeed;
						}

					} else if (Var.Stumpfx[i] <= Var.Stumpfdespawnx) {

						Var.Stumpfx[i] =  (int) (Math.random() * 10000) + 800;

					}
				}

			}

		}, 0, 15);
	}

}
