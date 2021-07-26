package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class StartAnimationBiber {
	Timer animation;

	public StartAnimationBiber() {
		animation = new Timer();
		animation.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imStart || Var.imMenu || Var.imGameover) {
					if (Var.startBiberAnimation == 1) {
						Var.startBiberAnimation++;
					} else if (Var.startBiberAnimation == 2) {
						Var.startBiberAnimation--;
					}
				}

			}

		}, 0, 500);
	}

}
