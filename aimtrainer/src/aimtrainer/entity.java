package aimtrainer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

public class entity implements ActionListener {
	JFrame jf;
	JButton[][] b;
	int right, iRight, jRight, curr, end;
	String w, r;
	trainer t;

	public entity(int curr, String w, String r, int end, trainer t) {
		this.end = end;
		this.curr = curr;
		this.w = w;
		this.r = r;
		this.t = t;

		jf = new JFrame("target " + curr);
		jf.setSize((int) (Math.random() * 1000 + curr * 50), (int) (Math.random() * 1000 + curr * 50));
		jf.setLocation((int) (Math.random() * (1200 - jf.getWidth())), (int) (Math.random() * (1000 - jf.getHeight())));
		jf.setLayout(null);
		jf.setVisible(true);

		right = (int) (Math.random() * curr * curr);
		b = new JButton[curr][curr];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = new JButton(((j * curr + i) == right) ? r : w);
				b[i][j].setBounds((int) ((int) (j * (jf.getWidth() / curr))), (int) (i * (jf.getHeight() / curr)),
						(jf.getWidth() / curr), (int) (jf.getHeight() / curr));
				b[i][j].setFont(new Font("Calibri", Font.BOLD, 20));
				b[i][j].setVisible(true);
				b[i][j].addActionListener(this);
				jf.add(b[i][j]);
				iRight = ((j * curr + i) == right) ? i : iRight;
				jRight = ((j * curr + i) == right) ? j : jRight;
			}
		}

		jf.setSize(curr * b[0][0].getWidth() + 20, curr * b[0][0].getHeight() + 45);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b[iRight][jRight]) {
			if (curr < end) {
				new entity(++curr, w, r, end, t);
			} else {
				boolean contains = false;
				int containsI = 0;

				for (int i = 0; i < t.scores.size(); i++) {
					if (t.scores.get(i).get(0).split(trainer.splitter[2])[3].equals(t.set.code)) {
						contains = true;
						containsI = i;
					}
				}

				if (contains) {
					t.scores.get(containsI).add(t.Nick + trainer.splitter[2] + t.time + trainer.splitter[2]
							+ new Date(System.currentTimeMillis()) + trainer.splitter[2] + t.set.code);
				} else {
					t.scores.add(new ArrayList<String>());
					t.scores.get(t.scores.size() - 1).add(t.Nick + trainer.splitter[2] + t.time + trainer.splitter[2]
							+ new Date(System.currentTimeMillis()) + trainer.splitter[2] + t.set.code);
				}
//				t.scores.add(t.Nick + trainer.splitter[2] + t.time + trainer.splitter[2]
//						+ new Date(System.currentTimeMillis()) + trainer.splitter[2] + t.set.code);
				t.jfTime.dispose();
				t.tm.cancel();
				t.time = 0;
			}

		} else {
			new entity(curr, w, r, end, t);
			t.time += 5;
		}
		jf.dispose();
	}
}
