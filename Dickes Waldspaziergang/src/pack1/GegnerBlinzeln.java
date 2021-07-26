package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerBlinzeln {
	Timer blinzeln;
	private int bcount = 0;

	public GegnerBlinzeln() {
		blinzeln = new Timer();
		blinzeln.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imSpiel) {
					if (bcount < Var.BlinzelAbstand) {
						Var.GegnerBlinzelt = false;
						bcount++;
					} else if (bcount == Var.BlinzelAbstand) {
						Var.GegnerBlinzelt = true;
						bcount = 0;
					}

				}
			}

		}, 0, 1000);
	}

}
