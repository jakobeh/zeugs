package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerYMovement {
	Timer ymove;

	public PlayerYMovement() {
		ymove = new Timer();
		ymove.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imSpiel) {
					Var.dickeY += Var.dickeVY;
				}
			}

		}, 0, 10);
	}

}
