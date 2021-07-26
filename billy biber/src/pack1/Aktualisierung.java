package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Aktualisierung {
	Timer aktual;
	static int temp = 0;

	public Aktualisierung() {
		aktual = new Timer();
		aktual.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imMenu) {
					if (temp == 0) {
						Var.btnresume.requestFocus();
						Var.btnoptionen.requestFocus();
						Var.btnshop.requestFocus();
						Var.btnexit.requestFocus();
						temp++;
					} else if (temp == 1) {
						Var.jf1.requestFocus();
					}
				}
			}
		}, 0, 50);
	}

}
