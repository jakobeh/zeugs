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
				System.out.println(Plattform1.x);
				System.out.println(Plattform2.x);
				
			}
			
		}, 0, Var.rate);
		
	}

}
