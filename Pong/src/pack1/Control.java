package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Control {
	Timer control;

	public Control() {
		control = new Timer();
		control.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				//System.out.println(Var.vx);
				//System.out.println(Var.vy);

			}

		}, 0, Var.rate);
	}

}
