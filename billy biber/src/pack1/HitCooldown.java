package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class HitCooldown {
Timer cooldown;

	public HitCooldown() {
		cooldown = new Timer();
		cooldown.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.getroffenOhneHitCooldown) {
					Var.getroffenOhneHitCooldown = false;
					Var.imHitCooldown = true;
					Var.wait(100);
					Var.imHitCooldown = false;
				}
				
			}
			
		}, 0, 15);
				
	}

}
