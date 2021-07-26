package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat.Type;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;

public class TTS {

	public static void main(String[] args) {
		TTS tts = new TTS();
		tts.testTTS(
				"Two households, both alike in dignity, In fair Verona, where we lay our scene, From ancient grudge create new rivalry That leads two star-crossed lovers to their deaths. See now, two servants from opposing sides Begin a brawl that will ignite this tale.");
		// tts.printFile("ttsOutput.wav");
	}

	public void testTTS(String s) {
		Voice voice = VoiceManager.getInstance().getVoice("kevin16");
		if (voice != null) {
			voice.allocate();

			AudioPlayer audioplayer = new SingleFileAudioPlayer("ttsOutput", Type.WAVE);
			voice.setAudioPlayer(audioplayer);

			try {
				voice.setRate(150);
				voice.setPitch(120);
				voice.setVolume(3);
				voice.speak(s);

			} catch (Exception e) {
				e.printStackTrace();
			}

			audioplayer.close();
		}
	}

	public void printFile(String path) {
		try {
			BufferedReader f = new BufferedReader(new FileReader(path));
			String l = f.readLine();
			while (l != null || l != "") {
				System.out.println(l);
				l = f.readLine();
				if (l == null) {
					break;
				}
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
