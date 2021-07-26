package aimtrainer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class trainer implements ActionListener {
	JFrame jf, jfSet, jfCust, jfTime;
	JButton bStart, bSet, bApplySet, bApplyCode, bConfirm, bAddPres, bPres, bRemovePres, bResetPres, bNextPres,
			bPrevPres, bExitSys, bExitCust, bRandom;
	JLabel lb, lbSet1, lbSet2, lbCustR, lbCustW, lbCustS, lbCustE, lbCustC, lbName, lbTime;
	JTextField tfCustRight, tfCustWrong, tfStart, tfEnd, tfCode, tfNick, tfName;
	Setting set;
	ArrayList<String> presets;
	ArrayList<ArrayList<String>> scores;
	int preset = 0;
	String Nick = "Nickname";
	boolean newPres = false;
	static String[] splitter;
	NumberFormat n;

	BufferedWriter saveWriter, scoreWriter;
	BufferedReader saveReader;

	Timer tm;
	double time = 0;

	public trainer() {
		splitter = new String[4];
		splitter[0] = "/-"; // im Setting Code
		splitter[1] = ";_"; // zwischen scores
		splitter[2] = ",="; // im score
		splitter[3] = "~#"; // zwischen scores pro code

		n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(1);
		n.setMinimumFractionDigits(1);

		try {
			saveReader = new BufferedReader(new FileReader("saves.txt"));
//			InputStream s = getClass().getResourceAsStream("/saves.txt");
//			if (s != null) {
//				saveReader = new BufferedReader(new InputStreamReader(s));
//			}
		} catch (Exception e) {

		}

		presets = new ArrayList<String>();
		scores = new ArrayList<ArrayList<String>>();

		String line = "";
		String[] words, presetScores, highscores;
		// liest Nick, presets
		try {
			line = saveReader.readLine();
		} catch (Exception x) {

		}

		if (line != null) {
			if (!line.equals("")) {
				words = line.split(splitter[1]);
				Nick = words[0];
				for (int i = 2; i < words.length - 1; i++) {
					presets.add(words[i]);
				}
				preset = Integer.parseInt(words[words.length - 1]);
			} else {
				presets.add("X/-O/-1/-10/-EASY");
				presets.add("E/-3/-1/-15/-MEDIUM");
				presets.add("S/-5/-1/-20/-HARD");
				presets.add("i/-j/-1/-25/-IMPOSSIBLE");
			}
		} else {
			presets.add("X/-O/-1/-10/-EASY");
			presets.add("E/-3/-1/-15/-MEDIUM");
			presets.add("S/-5/-1/-20/-HARD");
			presets.add("i/-j/-1/-25/-IMPOSSIBLE");
		}
		// liest scores
		try {
			line = saveReader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (line != null) {
			if (line.contains(splitter[3])) {
				presetScores = line.split(splitter[3]);
			} else {
				presetScores = new String[1];
				presetScores[0] = line;
			}
			for (int i = 0; i < presetScores.length; i++) {
				if (presetScores[i] != null) {
					scores.add(new ArrayList<String>());
					if (presetScores[i].contains(splitter[1])) {
						highscores = presetScores[i].split(splitter[1]);
					} else {
						highscores = new String[1];
						highscores[0] = presetScores[i];
					}
					for (int j = 0; j < highscores.length; j++) {
						scores.get(i).add(highscores[j]);
					}
				}
			}
		}

		set = new Setting(presets.get(preset));

		jf = new JFrame("Aimtrainer");
		jf.setSize(600, 400);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setLayout(null);

		// ???
		// jf.setBackground(Color.GRAY);
		// jf.setForeground(Color.GRAY);
		// ???

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bStart = new JButton("START");
		jf.add(bStart);
		bStart.setFont(new Font("Calibri", Font.BOLD, 40));
		bStart.setBounds(150, 160, 300, 100);
		bStart.setVisible(true);
		bStart.addActionListener(this);

		bSet = new JButton("SETTINGS");
		jf.add(bSet);
		bSet.setFont(new Font("Calibri", Font.BOLD, 20));
		bSet.setBounds(150, 270, 300, 70);
		bSet.setVisible(true);
		bSet.addActionListener(this);

		bExitSys = new JButton("Exit");
		jf.add(bExitSys);
		bExitSys.setFont(new Font("Calibri", Font.BOLD, 20));
		bExitSys.addActionListener(this);
		bExitSys.setBounds(20, 270, 80, 70);
		bExitSys.setVisible(true);

		lb = new JLabel("Hit the odd one out!");
		jf.add(lb);
		lb.setFont(new Font("Calibri", Font.BOLD, 50));
		lb.setBounds(70, 10, 500, 100);
		lb.setVisible(true);

		lb.setBackground(Color.BLACK);

		tfNick = new JTextField(Nick);
		jf.add(tfNick);
		tfNick.setFont(new Font("Calibri", Font.BOLD, 30));
		tfNick.setBounds(100, 100, 400, 50);
		tfNick.setVisible(true);
	}

	public void refreshLabel() {
		lbSet1.setText("Settings: Startwert Felder: " + set.start + " Endwert Felder: " + set.end);
		lbSet2.setText("Richtiges Feld: " + set.right + " falsche Felder: " + set.wrong);
		bPres.setText("Preset: '" + set.name + "'");
	}

	public int findBestScore(ArrayList<String> a) {
		int bestI = 0;
		double best = Double.parseDouble(a.get(0).split(splitter[2])[1]);
		for (int i = 0; i < a.size(); i++) {
			if (Double.parseDouble(a.get(i).split(splitter[2])[1]) < best) {
				bestI = i;
			}
		}
		return bestI;
	}

	public void sortScores() {
		ArrayList<ArrayList<String>> newScores = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < scores.size(); i++) {
			newScores.add(new ArrayList<String>());
			int size = scores.get(i).size();
			for (int j = 0; j < size; j++) {
				int x = findBestScore(scores.get(i));
				newScores.get(i).add(scores.get(i).get(x));
				scores.get(i).remove(x);
			}
		}
		scores = newScores;
	}

	public static void main(String args[]) {
		// new JFrame().setVisible(true);
		new trainer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bStart) {
			try {
				Nick = tfNick.getText();
			} catch (Exception x) {

			}
			new entity(set.start, set.wrong, set.right, set.end, this);

			jfTime = new JFrame("Timer");
			jfTime.setSize(300, 200);
			jfTime.setLocation(100, 100);
			jfTime.setVisible(true);

			lbTime = new JLabel("" + n.format(time));
			jfTime.add(lbTime);
			lbTime.setBounds(0, 0, 300, 200);
			lbTime.setFont(new Font("Calibri", Font.BOLD, 50));
			lbTime.setVisible(true);

			tm = new Timer();
			tm.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					time += 0.1;
					lbTime.setText("" + n.format(time));
				}

			}, 0, 100);
		}

		if (e.getSource() == bSet) {
			jfSet = new JFrame("Settings");
			jfSet.setSize(910, 600);
			jfSet.setLocationRelativeTo(null);
			jfSet.setLayout(null);
			jfSet.setVisible(true);

			bPres = new JButton("Preset: '" + set.name + "'");
			jfSet.add(bPres);
			bPres.addActionListener(this);
			bPres.setBounds(150, 20, 600, 100);
			bPres.setFont(new Font("Calibri", Font.BOLD, 30));
			bPres.setVisible(true);

			bAddPres = new JButton("add new Preset");
			jfSet.add(bAddPres);
			bAddPres.addActionListener(this);
			bAddPres.setBounds(25, 140, 250, 100);
			bAddPres.setFont(new Font("Calibri", Font.BOLD, 30));
			bAddPres.setVisible(true);

			bRemovePres = new JButton("remove Preset");
			jfSet.add(bRemovePres);
			bRemovePres.addActionListener(this);
			bRemovePres.setBounds(325, 140, 250, 100);
			bRemovePres.setFont(new Font("Calibri", Font.BOLD, 30));
			bRemovePres.setVisible(true);

			bResetPres = new JButton("reset Presets");
			jfSet.add(bResetPres);
			bResetPres.addActionListener(this);
			bResetPres.setBounds(625, 140, 250, 100);
			bResetPres.setFont(new Font("Calibri", Font.BOLD, 30));
			bResetPres.setVisible(true);

			bNextPres = new JButton(">");
			jfSet.add(bNextPres);
			bNextPres.addActionListener(this);
			bNextPres.setBounds(775, 20, 100, 100);
			bNextPres.setFont(new Font("Calibri", Font.BOLD, 30));
			bNextPres.setVisible(true);

			bPrevPres = new JButton("<");
			jfSet.add(bPrevPres);
			bPrevPres.addActionListener(this);
			bPrevPres.setBounds(25, 20, 100, 100);
			bPrevPres.setFont(new Font("Calibri", Font.BOLD, 30));
			bPrevPres.setVisible(true);

			bConfirm = new JButton("Confirm and close");
			jfSet.add(bConfirm);
			bConfirm.addActionListener(this);
			bConfirm.setBounds(25, 400, 850, 140);
			bConfirm.setFont(new Font("Calibri", Font.BOLD, 50));
			bConfirm.setVisible(true);

			lbSet1 = new JLabel("Settings: Startwert Felder: " + set.start + " Endwert Felder: " + set.end);
			jfSet.add(lbSet1);
			lbSet1.setBounds(50, 200, 800, 150);
			lbSet1.setFont(new Font("Calibri", Font.BOLD, 30));
			lbSet1.setVisible(true);

			lbSet2 = new JLabel("Richtiges Feld: " + set.right + " falsche Felder: " + set.wrong);
			jfSet.add(lbSet2);
			lbSet2.setBounds(165, 250, 800, 150);
			lbSet2.setFont(new Font("Calibri", Font.BOLD, 30));
			lbSet2.setVisible(true);
		}

		if (e.getSource() == bExitSys) {

			try {
				saveWriter = new BufferedWriter(new FileWriter(new File("saves.txt")));
				saveWriter.write(tfNick.getText() + splitter[1]);
				saveWriter.append(presets.size() + splitter[1]);
				for (int i = 0; i < presets.size(); i++) {
					saveWriter.append(presets.get(i) + splitter[1]);
				}
				saveWriter.append("" + preset);

				if (scores.size() > 0) {
					sortScores();
					saveWriter.newLine();
					for (int i = 0; i < scores.size(); i++) {
						for (int j = 0; j < scores.get(i).size(); j++) {
							saveWriter.append(
									scores.get(i).get(j) + ((j == scores.get(i).size() - 1) ? "" : splitter[1]));
						}
						if (i != scores.size() - 1) {
							saveWriter.append(splitter[3]);
						}
					}

					scoreWriter = new BufferedWriter(new FileWriter(new File("scores.txt")));
					scoreWriter.write("Highscores:");
					scoreWriter.newLine();
					scoreWriter.newLine();
					for (int i = 0; i < scores.size(); i++) {
						ArrayList<String> args = scores.get(i);
						scoreWriter.append("Preset : " + args.get(0).split(splitter[2])[3].split(splitter[0])[4]
								+ " (Code: " + args.get(0).split(splitter[2])[3] + ")");
						scoreWriter.newLine();

						for (int j = 0; j < args.size(); j++) {
							String[] args0 = args.get(j).split(splitter[2]);
							scoreWriter.append("   " + (j + 1) + ". " + args0[0] + ": "
									+ n.format(Double.parseDouble(args0[1])) + " Sekunden, am: " + args0[2]);
							scoreWriter.newLine();
						}

						scoreWriter.newLine();
//					String[] args = scores.get(i).split(splitter[2]);
//					scoreWriter.append((i + 1) + ". " + args[0] + ": " + args[1] + ", am: " + args[2] + ", Preset: "
//							+ args[3].split(splitter[0])[4] + " (Code: " + args[3] + ")");
//					scoreWriter.newLine();
					}
					scoreWriter.close();

				}

				saveWriter.close();
				
			} catch (IOException e1) {

			}

			System.exit(0);
		}

		if (e.getSource() == bPres) {
			newPres = false;

			jfCust = new JFrame("Edit Preset '" + set.name + "'");
			jfCust.setSize(617, 445);
			jfCust.setLocationRelativeTo(null);
			jfCust.setLayout(null);
			jfCust.setVisible(true);

			bExitCust = new JButton("Exit");
			jfCust.add(bExitCust);
			bExitCust.setBounds(10, 320, 95, 70);
			bExitCust.addActionListener(this);
			bExitCust.setFont(new Font("Calibri", Font.BOLD, 30));
			bExitCust.setVisible(true);

			bApplySet = new JButton("Apply Settings");
			jfCust.add(bApplySet);
			bApplySet.setBounds(115, 320, 230, 70);
			bApplySet.addActionListener(this);
			bApplySet.setFont(new Font("Calibri", Font.BOLD, 30));
			bApplySet.setVisible(true);

			bApplyCode = new JButton("Apply Code");
			jfCust.add(bApplyCode);
			bApplyCode.setBounds(355, 320, 230, 70);
			bApplyCode.addActionListener(this);
			bApplyCode.setFont(new Font("Calibri", Font.BOLD, 30));
			bApplyCode.setVisible(true);

			tfCustRight = new JTextField(set.right);
			jfCust.add(tfCustRight);
			tfCustRight.setBounds(50, 50, 220, 60);
			tfCustRight.setFont(new Font("Calibri", Font.BOLD, 30));
			tfCustRight.setVisible(true);

			tfCustWrong = new JTextField(set.wrong);
			jfCust.add(tfCustWrong);
			tfCustWrong.setBounds(330, 50, 220, 60);
			tfCustWrong.setFont(new Font("Calibri", Font.BOLD, 30));
			tfCustWrong.setVisible(true);

			tfStart = new JTextField("" + set.start);
			jfCust.add(tfStart);
			tfStart.setBounds(50, 150, 220, 60);
			tfStart.setFont(new Font("Calibri", Font.BOLD, 30));
			tfStart.setVisible(true);

			tfEnd = new JTextField("" + set.end);
			jfCust.add(tfEnd);
			tfEnd.setBounds(330, 150, 220, 60);
			tfEnd.setFont(new Font("Calibri", Font.BOLD, 30));
			tfEnd.setVisible(true);

			tfCode = new JTextField("" + set.code);
			jfCust.add(tfCode);
			tfCode.setBounds(330, 250, 220, 60);
			tfCode.setFont(new Font("Calibri", Font.BOLD, 20));
			tfCode.setVisible(true);

			tfName = new JTextField("" + set.name);
			jfCust.add(tfName);
			tfName.setBounds(50, 250, 220, 60);
			tfName.setFont(new Font("Calibri", Font.BOLD, 30));
			tfName.setVisible(true);

			lbCustR = new JLabel("Right Symbol (1 Char)");
			jfCust.add(lbCustR);
			lbCustR.setBounds(50, 12, 220, 20);
			lbCustR.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustR.setVisible(true);

			lbCustW = new JLabel("Wrong Symbol (1 Char)");
			jfCust.add(lbCustW);
			lbCustW.setBounds(330, 12, 220, 20);
			lbCustW.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustW.setVisible(true);

			lbCustS = new JLabel("Start number of buttons");
			jfCust.add(lbCustS);
			lbCustS.setBounds(50, 122, 220, 20);
			lbCustS.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustS.setVisible(true);

			lbCustE = new JLabel("End number of buttons");
			jfCust.add(lbCustE);
			lbCustE.setBounds(330, 122, 220, 20);
			lbCustE.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustE.setVisible(true);

			lbCustC = new JLabel("OR: paste Setting Code");
			jfCust.add(lbCustC);
			lbCustC.setBounds(330, 222, 220, 20);
			lbCustC.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustC.setVisible(true);

			lbName = new JLabel("Preset Name");
			jfCust.add(lbName);
			lbName.setBounds(50, 222, 220, 20);
			lbName.setFont(new Font("Calibri", Font.BOLD, 20));
			lbName.setVisible(true);
		}

		if (e.getSource() == bAddPres) {
			newPres = true;

			jfCust = new JFrame("Add new Settings Preset");
			jfCust.setSize(617, 445);
			jfCust.setLocationRelativeTo(null);
			jfCust.setLayout(null);
			jfCust.setVisible(true);

			bExitCust = new JButton("Exit");
			jfCust.add(bExitCust);
			bExitCust.setBounds(10, 320, 95, 70);
			bExitCust.addActionListener(this);
			bExitCust.setFont(new Font("Calibri", Font.BOLD, 30));
			bExitCust.setVisible(true);

			bApplySet = new JButton("Apply Settings");
			jfCust.add(bApplySet);
			bApplySet.setBounds(115, 320, 230, 70);
			bApplySet.addActionListener(this);
			bApplySet.setFont(new Font("Calibri", Font.BOLD, 30));
			bApplySet.setVisible(true);

			bApplyCode = new JButton("Apply Code");
			jfCust.add(bApplyCode);
			bApplyCode.setBounds(355, 320, 230, 70);
			bApplyCode.addActionListener(this);
			bApplyCode.setFont(new Font("Calibri", Font.BOLD, 30));
			bApplyCode.setVisible(true);

			tfName = new JTextField("" + set.name);
			jfCust.add(tfName);
			tfName.setBounds(50, 250, 220, 60);
			tfName.setFont(new Font("Calibri", Font.BOLD, 30));
			tfName.setVisible(true);

			tfCustRight = new JTextField(set.right);
			jfCust.add(tfCustRight);
			tfCustRight.setBounds(50, 50, 220, 60);
			tfCustRight.setFont(new Font("Calibri", Font.BOLD, 30));
			tfCustRight.setVisible(true);

			tfCustWrong = new JTextField(set.wrong);
			jfCust.add(tfCustWrong);
			tfCustWrong.setBounds(330, 50, 220, 60);
			tfCustWrong.setFont(new Font("Calibri", Font.BOLD, 30));
			tfCustWrong.setVisible(true);

			tfStart = new JTextField("" + set.start);
			jfCust.add(tfStart);
			tfStart.setBounds(50, 150, 220, 60);
			tfStart.setFont(new Font("Calibri", Font.BOLD, 30));
			tfStart.setVisible(true);

			tfEnd = new JTextField("" + set.end);
			jfCust.add(tfEnd);
			tfEnd.setBounds(330, 150, 220, 60);
			tfEnd.setFont(new Font("Calibri", Font.BOLD, 30));
			tfEnd.setVisible(true);

			tfCode = new JTextField("" + set.code);
			jfCust.add(tfCode);
			tfCode.setBounds(330, 250, 220, 60);
			tfCode.setFont(new Font("Calibri", Font.BOLD, 20));
			tfCode.setVisible(true);

			lbCustR = new JLabel("Right Symbol (1 Char)");
			jfCust.add(lbCustR);
			lbCustR.setBounds(50, 12, 220, 20);
			lbCustR.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustR.setVisible(true);

			lbCustW = new JLabel("Wrong Symbol (1 Char)");
			jfCust.add(lbCustW);
			lbCustW.setBounds(330, 12, 220, 20);
			lbCustW.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustW.setVisible(true);

			lbCustS = new JLabel("Start number of buttons");
			jfCust.add(lbCustS);
			lbCustS.setBounds(50, 122, 220, 20);
			lbCustS.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustS.setVisible(true);

			lbCustE = new JLabel("End number of buttons");
			jfCust.add(lbCustE);
			lbCustE.setBounds(330, 122, 220, 20);
			lbCustE.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustE.setVisible(true);

			lbCustC = new JLabel("OR: paste Setting Code");
			jfCust.add(lbCustC);
			lbCustC.setBounds(330, 222, 220, 20);
			lbCustC.setFont(new Font("Calibri", Font.BOLD, 20));
			lbCustC.setVisible(true);

			lbName = new JLabel("Preset Name");
			jfCust.add(lbName);
			lbName.setBounds(50, 222, 220, 20);
			lbName.setFont(new Font("Calibri", Font.BOLD, 20));
			lbName.setVisible(true);
		}

		if (e.getSource() == bApplySet) {
			int st = set.start, en = set.end;
			String r = set.right, w = set.wrong, n = set.name;
			try {
				st = Integer.parseInt(tfStart.getText());
				en = Integer.parseInt(tfEnd.getText());
				n = tfName.getText();
				r = Character.toString(tfCustRight.getText().charAt(0));
				w = Character.toString(tfCustWrong.getText().charAt(0));
			} catch (Exception x) {
				x.printStackTrace();
			}
			set = new Setting(r, w, st, en, n);
			if (newPres) {
				preset = presets.size();
				presets.add(set.code);
			} else {
				presets.set(preset, set.code);
			}

			refreshLabel();
			tfCode.setText(set.code);
			tfCustRight.setText(set.right);
			tfCustWrong.setText(set.wrong);
			tfStart.setText("" + set.start);
			tfEnd.setText("" + set.end);
			tfName.setText(set.name);
		}

		if (e.getSource() == bApplyCode) {
			String code = set.code;
			try {
				code = tfCode.getText();
			} catch (Exception x) {

			}
			set = new Setting(code);
			if (newPres) {
				preset = presets.size();
				presets.add(set.code);
			} else {
				presets.set(preset, set.code);
			}

			refreshLabel();

			tfCustRight.setText(set.right);
			tfCustWrong.setText(set.wrong);
			tfStart.setText("" + set.start);
			tfEnd.setText("" + set.end);
			tfName.setText(set.name);
		}

		if (e.getSource() == bExitCust) {
			jfCust.dispose();
		}

		if (e.getSource() == bNextPres) {
			if (presets.size() - 1 == preset) {
				preset = 0;
				set = new Setting(presets.get(preset));
			} else {
				set = new Setting(presets.get(++preset));
			}
			refreshLabel();
		}

		if (e.getSource() == bPrevPres) {
			if (preset == 0) {
				preset = presets.size() - 1;
				set = new Setting(presets.get(preset));
			} else {
				set = new Setting(presets.get(--preset));
			}
			refreshLabel();
		}

		if (e.getSource() == bRemovePres) {
			if (presets.size() > 1) {

				ArrayList<String> newPresets = new ArrayList<String>();

				for (int i = 0; i < presets.size(); i++) {
					if (i != preset) {
						newPresets.add(presets.get(i));
					}
				}

				presets = newPresets;
				preset = preset + ((preset != 0) ? (-1) : (presets.size() - 1));
				set = new Setting(presets.get(preset));
				refreshLabel();
			}
		}

		if (e.getSource() == bResetPres) {
			ArrayList<String> newPresets = new ArrayList<String>();
			presets = newPresets;

			preset = 0;

			presets.add("X/-O/-1/-10/-EASY");
			presets.add("E/-3/-1/-15/-MEDIUM");
			presets.add("S/-5/-1/-20/-HARD");
			presets.add("i/-j/-1/-25/-IMPOSSIBLE");

			set = new Setting(presets.get(preset));

			refreshLabel();
		}

		if (e.getSource() == bConfirm) {
			jfSet.dispose();
		}
	}
}
