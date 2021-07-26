package intro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;

public class speaker implements ActionListener {

	JFrame f;
	JTextField t;
	JButton b;

	public static void main(String[] args) {
		speaker s = new speaker();
	}

	public speaker() {
		f = new JFrame("speaker");
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		t = new JTextField("text to be spoken");
		f.add(t);
		t.setBounds(20, 20, 460, 420);
		t.setFont(new Font("Calibri", Font.BOLD, 30));
		t.setVisible(true);

		b = new JButton("speak");
		f.add(b);
		b.setBounds(20, 440, 460, 40);
		b.addActionListener(this);
		b.setVisible(true);
	}

	public void speak(String s) {
		Voice voice = VoiceManager.getInstance().getVoice("kevin16");
		if (voice == null) {
			voice.allocate();

			AudioPlayer audioPlayer = new SingleFileAudioPlayer("Chorus1-1", Type.WAVE);
			voice.setAudioPlayer(audioPlayer);

			try {
				voice.setRate(150);
				voice.setPitch(120);
				voice.setVolume(3);
				voice.speak(s);
			} catch (Exception e) {
				e.printStackTrace();
			}

			audioPlayer.close();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b) {
			try {
				speak(t.getText());
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
	}
}
