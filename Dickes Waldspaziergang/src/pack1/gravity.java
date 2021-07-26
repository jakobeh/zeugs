package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class gravity {
	Timer grav;

	public gravity() {
		grav = new Timer();
		grav.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imSpiel) {
					if (Var.onFloor == false) {
						// v = a*t + v0
						// y = v * t + y0
						Var.dickeVY += Var.gravity;
					} else if (Var.onFloor) {

						Var.dickeVY = 0;
					}
				}
			}
		}, 0, 10);

	}

}
