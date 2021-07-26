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
				//System.out.println(Var.jump);
				//System.out.println(StumpfKollision.temp);
				
			}
			
		}, 0, 50);
	}

}
