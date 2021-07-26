package pack1;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class StumpfKollision {
	Timer kollision;
	private int temp = 0;

	public StumpfKollision() {

		kollision = new Timer();
		kollision.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				for (int i = 0; i <= 4; i++) {
					if (Var.playerx - ((Var.playerwidth * 1.5) - 5) <= Var.Stumpfx[i]
							&& Var.playerx + ((Var.playerwidth / 2) - 5) >= Var.Stumpfx[i]
							&& Var.playery + Var.playerheight >= (Var.Stumpfy - 30)
							&& Var.playery <= (Var.Stumpfy - 30)) {
						if (Var.playery + Var.playerheight >= (Var.Stumpfy - (Var.Stumpfheight + 20))
								&& Var.playery <= (Var.Stumpfy - 30)
								&& Var.playerx - ((Var.playerwidth * 1.5) - 20) <= Var.Stumpfx[i]
								&& Var.playerx + ((Var.playerwidth / 2) - 20) >= Var.Stumpfx[i]) {

							Var.Stumpfx[i] = (int) (Math.random() * 10000) + 800;
							Var.coins += Var.Stumpfcoins;

							try {

								Clip clipcoin = AudioSystem.getClip();
								AudioInputStream inputstreamcoin = AudioSystem
										.getAudioInputStream(new File("audio/coincollected.wav"));
								clipcoin.open(inputstreamcoin);
								clipcoin.loop(0);

							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("Sound konnte nicht gespielt werden ):");
							}
							Var.jump = true;
							Var.wait(50);
							Var.jump = false;

						} else {
							Var.getroffenOhneHitCooldown = true;
							if (Var.imHitCooldown == false) {
								Var.getroffen = true;

								Var.leben -= Var.Stumpfdmg;

								if (Var.leben <= 0) {
									Var.gameover = true;
								}

								Var.Stumpfx[i] = (int) (Math.random() * 10000) + 800;
							}
						}
					}
				}
			}

		}, 0, 15);
	}

}
