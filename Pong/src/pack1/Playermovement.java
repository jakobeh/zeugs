package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Playermovement {
	Timer move;

	public Playermovement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				//player1
				if (Var.p1moveup && Var.p1y >= Var.pspeed) {
					Var.p1y -= Var.pspeed;
				}
				if (Var.p1moveleft && Var.p1x >= Var.pspeed) {
					Var.p1x -= Var.pspeed;
				}
				if (Var.p1movedown && Var.p1y <= Var.screenheight - Var.pspeed) {
					Var.p1y += Var.pspeed;
				}
				if (Var.p1moveright && Var.p1x <=  Var.screenwidth / 2 - (Var.pspeed + 20)) {
					Var.p1x += Var.pspeed;
				}
				//player2
				if (Var.p2moveup && Var.p2y >= Var.pspeed) {
					Var.p2y -= Var.pspeed;
				}
				if (Var.p2moveleft && Var.p2x >= Var.screenwidth / 2 - (Var.pspeed - 20)) {
					Var.p2x -= Var.pspeed;
				}
				if (Var.p2movedown && Var.p2y <= Var.screenheight - Var.pspeed) {
					Var.p2y += Var.pspeed;
				}
				if (Var.p2moveright && Var.p2x <= Var.screenwidth - Var.pspeed) {
					Var.p2x += Var.pspeed;
				}
			}

		}, 0, Var.rate);
	}

}
