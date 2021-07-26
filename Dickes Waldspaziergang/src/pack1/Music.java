package pack1;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	private static int temp = 0;
	public static synchronized void music() {

		final String trackWald = "audio/TheForestRaiderHigh5.wav", trackDungeon = "audio/TheDungeonRaider4Life2.wav",
				trackCredits = "audio/Zang6.wav";

		new Thread(new Runnable() {

			@Override
			public void run() {
				
				while (true) {
					if (Var.inCredits) {
						try {
							temp = 0;
							Clip c = AudioSystem.getClip();
							AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(trackCredits));
							c.open(inputstream);
							c.loop(0);
							
							Thread.sleep(c.getMicrosecondLength() / 1000);
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Musik konnte nicht geladen werden ):");
						}
					}
					else if (Var.imWald) {
						try {
							temp = 0;
							Clip c = AudioSystem.getClip();
							AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(trackWald));
							c.open(inputstream);
							c.loop(0);
							 
							Thread.sleep(c.getMicrosecondLength() / 1000);
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Musik konnte nicht geladen werden ):");
						}
					}
					
				}
			}

		}).start();
	}

}