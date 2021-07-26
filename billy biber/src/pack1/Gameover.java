package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Gameover {
Timer gameover;
private int temp = 8000;
	public Gameover() {
		gameover = new Timer();
		gameover.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.gameover) {
					Var.leben = Var.maxleben;
					Var.altcoins = Var.coins;
					if (Var.coins >= 50) {
						Var.coins -= 50;
					} else if (Var.coins < 50){
						Var.coins = 0;
					}
					for (int i = 0; i <= 4; i++) {
						Var.Stumpfx[i] = (int) (Math.random() * temp);
						temp += 1000;
					}
					temp = 8000;
					Var.gameover = false;
					Var.imSpiel = false;
					Var.inOptionen = false;
					Var.imStart = false;
					Var.imShop = false;
					Var.imGameover = true;
					
				}
				
			}
			
		}, 0, 15);
	}

}
