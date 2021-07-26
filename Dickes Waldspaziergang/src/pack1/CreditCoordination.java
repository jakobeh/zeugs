package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class CreditCoordination {
	Timer coord;
	private int temp = 0;

	public CreditCoordination() {
		coord = new Timer();
		coord.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.inCredits) {
					if (temp < 7611) {
						temp++;
						if (temp < 255) {
							Var.CreditTransparenz--;
						} else if (temp < 7155 && temp >= 255) {
							Var.CreditFortschritt--;
						} else if (temp < 7355 && temp >= 7155) {
							
						}
						else if (temp < 7610 && temp >= 7355) {
							Var.CreditTransparenz++;
						}
					}
					else if (temp == 7611) {
						Var.inCredits = false;
						Var.inPause = true;
					}
				}
				else if (Var.inCredits == false) {
					temp = 0;
					Var.CreditFortschritt = 0;
					Var.CreditTransparenz = 255;
				}
			}

		}, 0, Var.rate);
	}

}
