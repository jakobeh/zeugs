package pack1;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class getroffen {
	Timer hit;
	private int temp = 0;

	public getroffen() {
		hit = new Timer();
		hit.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.getroffen || temp == 1) {
					temp = 1;
					if (Var.getroffenanimation < 3) {
						Var.getroffenanimation++;
					} else if (Var.getroffenanimation == 3) {
						Var.getroffenanimation = 0;
						temp = 0;
					}

					try {

						Clip clipouch = AudioSystem.getClip();
						AudioInputStream inputstreamouch = AudioSystem.getAudioInputStream(new File("audio/ouch.wav"));
						clipouch.open(inputstreamouch);
						clipouch.loop(0);

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Sound konnte nicht gespielt werden ):");
					}

					Var.getroffen = false;
				}

			}

		}, 0, 15);
	}

}
