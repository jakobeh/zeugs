package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;

public class TTS {

	public static void main(String[] args) {
		TTS tts = new TTS();
		tts.testTTS(
				"Two households, both alike in dignity, In fair Verona, where we lay our scene, From ancient grudge create new rivalry ");
		// tts.printFile("ttsOutput.wav");
		tts.testAudioProcessing();
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

	static AudioFormat Format = new AudioFormat(1000f, 16, 2, true, true);

	ArrayList<ByteBuffer> b;

	Timer t;

	public void play(String path) {
		try {
			File f = new File(path);
			InputStream ais = new FileInputStream(f);

			int length = (int) f.length();

			float sample_len = 1000f / Format.getFrameRate();
			int sample_size = Format.getFrameSize();

			int delta = Math.round(sample_size * (20f / sample_len));

			for (int i = 0; i < length; i += delta) {
				if (i + delta < length) {
					byte[] temp = new byte[delta];

					ais.read(temp, 0, delta);

					b.add((ByteBuffer) ByteBuffer.wrap(temp));
				}
			}

			ais.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean canProvide() {
		return b.size() != 0;
	}

	public ByteBuffer provide20MsAudio() {
		ByteBuffer snippet = null;
		try {
			snippet = b.get(b.size() - 1);
			b.remove(b.size() - 1);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println(b.size());
		return snippet;
	}

	public void testAudioProcessing() {
		b = new ArrayList<ByteBuffer>();

		play("ttsOutput.wav");

		try {
			FileOutputStream os = new FileOutputStream(new File("processOutput.wav"));
			
			while (b.size() > 0) {
				os.write(provide20MsAudio().array());
			}
			
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
