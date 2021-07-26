package pack1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NameRandomizer implements ActionListener {
	JButton bOK, bOK1;
	JTextField jt;
	JLabel jl;
	JFrame jf;

	public NameRandomizer() {
		setUpGui();
	}

	public String shuffle(String word) {

		Random r = new Random();
		boolean cap = false;
		int t;
		String ts;
		String[] a = word.split(" ");
		String[][] s = new String[a.length][];
		String erg = "";
		for (int i = 0; i < s.length; i++) {
			s[i] = a[i].split("");

			cap = Character.isUpperCase(s[i][0].charAt(0));
			for (int j = 0; j < s[i].length; j++) {
				if (cap) {
					s[i][j] = s[i][j].toLowerCase();
				}
				t = r.nextInt(s[i].length);
				ts = s[i][j];
				s[i][j] = s[i][t];
				s[i][t] = ts;
			}
			if (cap) {
				s[i][0] = s[i][0].toUpperCase();
			}
			for (int j = 0; j < s[i].length; j++) {
				erg += s[i][j];
			}
			if (i != s.length - 1) {
				erg += " ";
			}

		}
		return erg;
	}
	
	public String shuffleReadably(String word) {

		Random r = new Random();
		boolean cap = false;
		int t;
		String ts;
		String[] a = word.split(" ");
		String[][] s = new String[a.length][];
		String erg = "";
		for (int i = 0; i < s.length; i++) {
			s[i] = a[i].split("");

			cap = Character.isUpperCase(s[i][0].charAt(0));
			for (int j = 1; j < s[i].length - 1; j++) {
				if (cap) {
					s[i][j] = s[i][j].toLowerCase();
				}
				t = r.nextInt(s[i].length - 2) + 1;
				ts = s[i][j];
				s[i][j] = s[i][t];
				s[i][t] = ts;
			}
			if (cap) {
				s[i][0] = s[i][0].toUpperCase();
			}
			for (int j = 0; j < s[i].length; j++) {
				erg += s[i][j];
			}
			if (i != s.length - 1) {
				erg += " ";
			}

		}
		return erg;
	}

	public void setUpGui() {
		jf = new JFrame("Name Randomizer");
		jf.setSize(400, 300);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jl = new JLabel("Input Name");
		jl.setBounds(25, 25, 150, 50);
		jl.setFont(new Font("Calibri", Font.BOLD, 30));
		jl.setVisible(true);
		jf.add(jl);

		jt = new JTextField();
		jt.setBounds(25, 85, 350, 60);
		jt.setFont(new Font("Calibri", Font.BOLD, 30));
		jt.setVisible(true);
		jf.add(jt);

		bOK = new JButton("Random");
		bOK.setBounds(25, 155, 150, 60);
		bOK.setFont(new Font("Calibri", Font.BOLD, 30));
		bOK.addActionListener(this);
		jf.add(bOK);
		
		bOK1 = new JButton("Readable");
		bOK1.setBounds(200, 155, 150, 60);
		bOK1.setFont(new Font("Calibri", Font.BOLD, 30));
		bOK1.addActionListener(this);
		jf.add(bOK1);
	}

	public static void main(String[] args) {
		new NameRandomizer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bOK) {
			if (jt.getText().length() > 0) {
				jt.setText(shuffle(jt.getText()));
			}
		}
		if (e.getSource() == bOK1) {
			if (jt.getText().length() > 0) {
				jt.setText(shuffleReadably(jt.getText()));
			}
		}
	}
}
