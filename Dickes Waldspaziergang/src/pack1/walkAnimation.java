package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class walkAnimation {
	Timer walk;
	private int counter = 0, counter1 = 0, counter2 = 0;

	public walkAnimation() {
		walk = new Timer();
		walk.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if ((Var.moveright && Var.moveleft) || Var.onFloor == false) {
					Var.Schritt = false;
				}
				else if (Var.moveright || Var.moveleft) {
					if (counter== 0) {
						Var.Schritt = false;
						counter++;
					} else if(counter == 1) {
						Var.Schritt = true;
						counter--;
					}
				}
				else if (Var.moveright == false && Var.moveleft == false) {
					Var.Schritt = false;
				}
				
				
				//InvincibleAnimation
				if (Var.invincible) {
					if (counter1 < 2) {
						counter1++;
						Var.dickeVisible = false;
					}
					else if (counter1 == 2) {
						counter1++;
						Var.dickeVisible = true;
					}
					else if (counter1 == 3) {
						counter1 = 0;
						Var.dickeVisible = true;
					}
				}
				else if (Var.invincible == false) {
					Var.dickeVisible = true;
				}
				
				//CoinAnimation
				if (counter2 == 0) {
					counter2++;
					Var.coinBild = 1;
				}
				else if (counter2 == 1) {
					counter2++;
					Var.coinBild = 2;
				}
				else if (counter2 == 2) {
					counter2++;
					Var.coinBild = 3;
				}
				else if (counter2 == 3) {
					counter2 = 0;
					Var.coinBild = 4;
				}
			}

		}, 0, Var.rate * 10);
	}

}
