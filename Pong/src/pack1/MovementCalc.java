package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class MovementCalc {
	Timer calc;

	public MovementCalc() {
		calc = new Timer();
		calc.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Var.p1rx = (Var.ballx - Var.p1x) * Var.scale;
				Var.p1ry = (Var.bally - Var.p1y) * Var.scale;
				Var.p2rx = (Var.ballx - Var.p2x) * Var.scale;
				Var.p2ry = (Var.bally - Var.p2y) * Var.scale;

				Var.F1x = (Var.G * Var.ballmass * Var.pmass / (Math.pow(Var.p1rx, 2)));
				Var.F1y = (Var.G * Var.ballmass * Var.pmass / (Math.pow(Var.p1ry, 2)));
				Var.F2x = (Var.G * Var.ballmass * Var.pmass / (Math.pow(Var.p2rx, 2)));
				Var.F2y = (Var.G * Var.ballmass * Var.pmass / (Math.pow(Var.p2ry, 2)));

				if (Var.p1x <= Var.ballx && Var.p2x <= Var.ballx) {
					Var.FxRes = -Var.F1x - Var.F2x;
				} else if (Var.p1x <= Var.ballx && Var.p2x >= Var.ballx) {
					Var.FxRes = -Var.F1x + Var.F2x;
				} else if (Var.p1x >= Var.ballx && Var.p2x >= Var.ballx) {
					Var.FxRes = Var.F1x + Var.F2x;
				}
				if (Var.p1y == Var.bally && Var.p2y == Var.bally) {
					Var.FyRes = 0;
				} else if (Var.p1y <= Var.bally && Var.p2y <= Var.bally) {
					Var.FyRes = -Var.F1y - Var.F2y;
				} else if (Var.p1y <= Var.bally && Var.p2y >= Var.bally) {
					Var.FyRes = -Var.F1y + Var.F2y;
				} else if (Var.p1y >= Var.bally && Var.p2y <= Var.bally) {
					Var.FyRes = Var.F1y - Var.F2y;
				} else if (Var.p1y >= Var.bally && Var.p2y >= Var.bally) {
					Var.FyRes = Var.F1y + Var.F2y;
				}

				Var.ax = Var.FxRes / Var.ballmass;
				Var.ay = Var.FyRes / Var.ballmass;

				if (Var.vx <= Var.maxv - Var.vx && Var.vx >= -Var.maxv + Var.vx) {
					Var.vx = Var.vx + Var.ax * Var.rate;
				} else {
					if (Var.vx < -Var.maxv) {
						Var.vx = -Var.maxv;
					} else if (Var.vx > Var.maxv) {
						Var.vx = Var.maxv;
					}
				}
				if (Var.vy <= Var.maxv - Var.vy && Var.vy >= -Var.maxv + Var.vy) {
					Var.vy = Var.vy + Var.ax * Var.rate;
				} else {
					if (Var.vy < -Var.maxv) {
						Var.vy = -Var.maxv;
					} else if (Var.vy > Var.maxv) {
						Var.vy = Var.maxv;
					}
				}

				if (Var.ballx < Var.screenwidth && Var.ballx > 0) {
					Var.ballx = (int) (Var.ballx + Var.vx * Var.rate);
				} else {
					if (Var.ballx < 0) {
						Var.ballx = 1;
					} else if (Var.ballx > Var.screenwidth) {
						Var.ballx = Var.screenwidth - 1;
					}
					Var.vx = -Var.vx;
				}
				if (Var.bally < Var.screenheight && Var.bally > 0) {
					Var.bally = (int) (Var.bally + Var.vy * Var.rate);
				} else {
					if (Var.bally < 0) {
						Var.bally = 1;
					} else if (Var.bally > Var.screenheight) {
						Var.bally = Var.screenheight - 1;
					}
					Var.vy = -Var.vy;
				}
			}

		}, 0, Var.rate);
	}

}
