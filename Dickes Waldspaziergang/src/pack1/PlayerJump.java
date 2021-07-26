package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerJump {
	Timer pj;
	private int jcount = 0, jsave = 0;

	public PlayerJump() {
		pj = new Timer();
		pj.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imSpiel) {
					if (Var.jumpHold) {
						if (jcount < Var.sprungheight) {
							Var.dickeVY = Var.dickeJumpV;
							jcount++;
						} else if (jcount == Var.sprungheight) {

						}

					} else if (Var.jumpHold == false && Var.onFloor == false) {
						jcount = Var.sprungheight;
					}
					if (Var.onFloor) {
						if (jsave == 5) {
							jcount = 0;
							jsave = 0;
						}
						else if (jsave < 5) {
							jsave++;
						}
					}
				}
			}
		}, 0, Var.rate);
	}

}
