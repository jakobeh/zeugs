package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerMovement {
	Timer movement;
	static int temp = -Var.playerjumpheight;

	public PlayerMovement() {
		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				if (Var.duck == false) {
					if (Var.moveright) {
						if (Var.playerx < 500) {
							Var.playerx += Var.playerspeed;
						} else if (Var.playerx >= 500) {
							Var.playerrealx += Var.playerspeed;
						}
					}
					if (Var.moveleft) {
						if (Var.playerx > 100) {
							Var.playerx -= Var.playerspeed;
						}else if (Var.playerx <= 100) {
							Var.playerrealx -= Var.playerspeed;
						}

					}

					// springen
					if (Var.jump) {

						if (temp <= 0) {
							Var.playery -= temp * temp;
							temp += 1;
						} else if (temp > 0 && temp <= Var.playerjumpheight) {
							Var.playery += temp * temp;
							temp += 1;
						} else if (temp == Var.playerjumpheight + 1) {
							temp = -Var.playerjumpheight;
						}
					}
				}
				// fallen
				if (Var.jump == false || Var.duck) {
					if (Var.playery < 400) {
						if (temp <= 0) {
							Var.playery -= temp * temp;
							temp++;
						}
						if (temp > 0) {
							Var.playery += temp * temp;
							temp++;
						}
					} else if (Var.playery >= 400) {
						temp = -Var.playerjumpheight;
					}
				}
			}

		}, 0, 15);
	}

}
