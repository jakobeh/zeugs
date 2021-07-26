import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

class main implements ActionListener, KeyListener {
	JFrame jf, jfCustom;
	JButton bIO, bSimEx, bf, bMin, bMed, bMax, bCustom, bButtons, bWASD, bNum, bArr, bCursor, bSpace, bMov, bLR, bFB,
			bCirc, bOK, bReset, bHotKey;
	JTextField tf;
	Timer t;
	Robot r;

	int step = 0;
	int ON = 1, OFF = 0;
	int status = OFF;
	int SIMPLE = 0, EXTENDED = 1;
	int ansicht = SIMPLE;
	int MINI = 5000, MEDI = 2000, MAXI = 50, CUSTOM = 1000;
	int frequency = MEDI;
	int WASD = 0, ARROWS = 1, NUMBERS = 2, CURSOR = 3, SPACE = 4;
	int buttons = WASD;
	int LEFT_RIGHT = 0, FORWARD_BACKWARD = 1, CIRCLE = 2;
	int movement = CIRCLE;
	int Hotkey = KeyEvent.VK_DELETE;
	boolean HotKeySearchActive = false;

	public static void main(String[] args) {
		new main();
	}

	public main() {
		jf = new JFrame("noAFK - Bot");
		jf.setSize(200, 285);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.addKeyListener(this);

		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		bIO = new JButton("OFF");
		jf.add(bIO);
		bIO.setBounds(0, 0, 200, 200);
		bIO.setVisible(true);
		bIO.addActionListener(this);

		bSimEx = new JButton("SIMPLE");
		jf.add(bSimEx);
		bSimEx.setBounds(0, 200, 200, 50);
		bSimEx.setVisible(true);
		bSimEx.addActionListener(this);

		bf = new JButton("Frequency: MEDI");
		jf.add(bf);
		bf.setBounds(200, 0, 300, 50);
		bf.setVisible(false);
		bf.addActionListener(this);

		bMin = new JButton("MINI");
		jf.add(bMin);
		bMin.setBounds(200, 50, 70, 50);
		bMin.setVisible(false);
		bMin.addActionListener(this);

		bMed = new JButton("MEDI");
		jf.add(bMed);
		bMed.setBounds(270, 50, 70, 50);
		bMed.setVisible(false);
		bMed.addActionListener(this);

		bMax = new JButton("MAXI");
		jf.add(bMax);
		bMax.setBounds(340, 50, 70, 50);
		bMax.setVisible(false);
		bMax.addActionListener(this);

		bCustom = new JButton("CUSTOM");
		jf.add(bCustom);
		bCustom.setBounds(410, 50, 90, 50);
		bCustom.setVisible(false);
		bCustom.addActionListener(this);

		bButtons = new JButton("Buttons: WASD");
		jf.add(bButtons);
		bButtons.setBounds(200, 100, 300, 50);
		bButtons.setVisible(false);
		bButtons.addActionListener(this);

		bWASD = new JButton("WASD");
		jf.add(bWASD);
		bWASD.setBounds(200, 150, 100, 50);
		bWASD.setVisible(false);
		bWASD.addActionListener(this);

		bNum = new JButton("NUMBERS");
		jf.add(bNum);
		bNum.setBounds(300, 150, 100, 50);
		bNum.setVisible(false);
		bNum.addActionListener(this);

		bArr = new JButton("ARROWS");
		jf.add(bArr);
		bArr.setBounds(400, 150, 100, 50);
		bArr.setVisible(false);
		bArr.addActionListener(this);

		bCursor = new JButton("CURSOR");
		jf.add(bCursor);
		bCursor.setBounds(200, 200, 150, 50);
		bCursor.setVisible(false);
		bCursor.addActionListener(this);

		bSpace = new JButton("SPACE");
		jf.add(bSpace);
		bSpace.setBounds(350, 200, 150, 50);
		bSpace.setVisible(false);
		bSpace.addActionListener(this);

		bMov = new JButton("Movement: CIRCLE");
		jf.add(bMov);
		bMov.setBounds(500, 0, 300, 50);
		bMov.setVisible(false);
		bMov.addActionListener(this);

		bLR = new JButton("LEFT-RIGHT");
		jf.add(bLR);
		bLR.setBounds(500, 50, 100, 50);
		bLR.setVisible(false);
		bLR.addActionListener(this);

		bFB = new JButton("FOR.-BACK");
		jf.add(bFB);
		bFB.setBounds(600, 50, 100, 50);
		bFB.setVisible(false);
		bFB.addActionListener(this);

		bCirc = new JButton("CIRCLE");
		jf.add(bCirc);
		bCirc.setBounds(700, 50, 100, 50);
		bCirc.setVisible(false);
		bCirc.addActionListener(this);

		bReset = new JButton("RESET");
		jf.add(bReset);
		bReset.setBounds(500, 200, 300, 50);
		bReset.setVisible(false);
		bReset.addActionListener(this);

		bHotKey = new JButton("HOTKEY: DELETE");
		jf.add(bHotKey);
		bHotKey.setBounds(500, 100, 300, 100);
		bHotKey.setVisible(false);
		bHotKey.addActionListener(this);

	}

	void wait(int ms) {
		try {
			new Thread();
			Thread.sleep(ms);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bIO) {

			if (status == OFF) {
				status = ON;
				bIO.setText("ON");
				System.out.println("ON");

				t = new Timer();
				t.scheduleAtFixedRate(new TimerTask() {

					@Override
					public void run() {
						if (movement == LEFT_RIGHT) {
							if (buttons == WASD) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_A);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_A);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_D);
									step++;
								} else if (step <= 3) {
									r.keyRelease(KeyEvent.VK_D);
									step = 0;
								}
							}

							else if (buttons == NUMBERS) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_NUMPAD4);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_NUMPAD4);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_NUMPAD6);
									step++;
								} else if (step <= 3) {
									r.keyRelease(KeyEvent.VK_NUMPAD6);
									step = 0;
								}
							}

							else if (buttons == ARROWS) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_LEFT);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_LEFT);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_RIGHT);
									step++;
								} else if (step <= 3) {
									r.keyRelease(KeyEvent.VK_RIGHT);
									step = 0;
								}
							}

						}

						else if (movement == FORWARD_BACKWARD) {
							if (buttons == WASD) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_W);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_W);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_S);
									step++;
								} else if (step <= 3) {
									r.keyRelease(KeyEvent.VK_S);
									step = 0;
								}
							}

							else if (buttons == NUMBERS) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_NUMPAD8);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_NUMPAD8);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_NUMPAD5);
									step++;
								} else if (step <= 3) {
									r.keyRelease(KeyEvent.VK_NUMPAD5);
									step = 0;
								}
							}

							else if (buttons == ARROWS) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_UP);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_UP);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_DOWN);
									step++;
								} else if (step <= 3) {
									r.keyRelease(KeyEvent.VK_DOWN);
									step = 0;
								}
							}
						}

						else if (movement == CIRCLE) {
							if (buttons == WASD) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_W);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_W);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_A);
									step++;
								} else if (step == 3) {
									r.keyRelease(KeyEvent.VK_A);
									step++;
								} else if (step == 4) {
									r.keyPress(KeyEvent.VK_S);
									step++;
								} else if (step == 5) {
									r.keyRelease(KeyEvent.VK_S);
									step++;
								} else if (step == 6) {
									r.keyPress(KeyEvent.VK_D);
									step++;
								} else if (step <= 7) {
									r.keyRelease(KeyEvent.VK_D);
									step = 0;
								}
							}

							if (buttons == NUMBERS) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_NUMPAD8);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_NUMPAD8);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_NUMPAD4);
									step++;
								} else if (step == 3) {
									r.keyRelease(KeyEvent.VK_NUMPAD4);
									step++;
								} else if (step == 4) {
									r.keyPress(KeyEvent.VK_NUMPAD5);
									step++;
								} else if (step == 5) {
									r.keyRelease(KeyEvent.VK_NUMPAD5);
									step++;
								} else if (step == 6) {
									r.keyPress(KeyEvent.VK_NUMPAD6);
									step++;
								} else if (step <= 7) {
									r.keyRelease(KeyEvent.VK_NUMPAD6);
									step = 0;
								}
							}

							if (buttons == ARROWS) {
								if (step == 0) {
									r.keyPress(KeyEvent.VK_UP);
									step++;
								} else if (step == 1) {
									r.keyRelease(KeyEvent.VK_UP);
									step++;
								} else if (step == 2) {
									r.keyPress(KeyEvent.VK_RIGHT);
									step++;
								} else if (step == 3) {
									r.keyRelease(KeyEvent.VK_RIGHT);
									step++;
								} else if (step == 4) {
									r.keyPress(KeyEvent.VK_DOWN);
									step++;
								} else if (step == 5) {
									r.keyRelease(KeyEvent.VK_DOWN);
									step++;
								} else if (step == 6) {
									r.keyPress(KeyEvent.VK_LEFT);
									step++;
								} else if (step <= 7) {
									r.keyRelease(KeyEvent.VK_LEFT);
									step = 0;
								}
							}
						}

						if (buttons == CURSOR) {
							if (step == 0) {
								r.mouseMove(200, 200);
								step++;
							} else if (step <= 1) {
								r.mouseMove(400, 400);
								step = 0;
							}
						}

						if (buttons == SPACE) {
							if (step == 0) {
								r.keyPress(KeyEvent.VK_SPACE);
								step++;
							} else if (step <= 1) {
								r.keyRelease(KeyEvent.VK_SPACE);
								step = 0;
							}
						}
					}

				}, 0, frequency);

			} else if (status == ON) {
				status = OFF;
				t.cancel();
				bIO.setText("OFF");
				System.out.println("OFF");

			}
		}

		if (e.getSource() == bSimEx) {
			if (ansicht == SIMPLE) {
				ansicht = EXTENDED;
				bSimEx.setText("EXTENDED");

				jf.setSize(800, 285);
				bf.setVisible(true);
				bMin.setVisible(true);
				bMed.setVisible(true);
				bMax.setVisible(true);
				bCustom.setVisible(true);
				bButtons.setVisible(true);
				bWASD.setVisible(true);
				bNum.setVisible(true);
				bArr.setVisible(true);
				bCursor.setVisible(true);
				bSpace.setVisible(true);
				bReset.setVisible(true);
				bHotKey.setVisible(true);
				bMov.setVisible(true);
				bLR.setVisible(true);
				bFB.setVisible(true);
				bCirc.setVisible(true);
			} else if (ansicht == EXTENDED) {
				ansicht = SIMPLE;
				bSimEx.setText("SIMPLE");

				jf.setSize(200, 285);
				bf.setVisible(false);
				bMin.setVisible(false);
				bMed.setVisible(false);
				bMax.setVisible(false);
				bCustom.setVisible(false);
				bButtons.setVisible(false);
				bWASD.setVisible(false);
				bNum.setVisible(false);
				bArr.setVisible(false);
				bCursor.setVisible(false);
				bSpace.setVisible(false);
				bReset.setVisible(false);
				bHotKey.setVisible(false);
				bMov.setVisible(false);
				bLR.setVisible(false);
				bFB.setVisible(false);
				bCirc.setVisible(false);
			}
		}

		if (e.getSource() == bf) {
			if (frequency == MINI) {
				frequency = MEDI;
				bf.setText("Frequency: MEDI");
			} else if (frequency == MEDI) {
				frequency = MAXI;
				bf.setText("Frequency: MAXI");
			} else if (frequency == MAXI || frequency == CUSTOM) {
				frequency = MINI;
				bf.setText("Frequency: MINI");
			}
		}

		if (e.getSource() == bMin) {
			frequency = MINI;
			bf.setText("Frequency: MINI");
		}
		if (e.getSource() == bMax) {
			frequency = MAXI;
			bf.setText("Frequency: MAXI");
		}
		if (e.getSource() == bMed) {
			frequency = MEDI;
			bf.setText("Frequency: MEDI");
		}
		if (e.getSource() == bCustom) {

			jfCustom = new JFrame("Set Custom Value");
			jfCustom.setLayout(null);
			jfCustom.setSize(150, 200);
			jfCustom.setLocationRelativeTo(null);
			jfCustom.setVisible(true);
			tf = new JTextField();
			jfCustom.add(tf);
			tf.setBounds(0, 0, 150, 100);
			tf.setVisible(true);
			tf.setFont(new Font("CALIBRI", Font.BOLD, 20));

			bOK = new JButton("OK");
			jfCustom.add(bOK);
			bOK.setBounds(0, 100, 150, 50);
			bOK.setVisible(true);
			bOK.addActionListener(this);

			jfCustom.requestFocus();
			tf.requestFocus();

			frequency = CUSTOM;
			bf.setText("Frequency: CUSTOM (" + CUSTOM + ")");
		}

		if (e.getSource() == bOK) {
			try {
				CUSTOM = Integer.parseInt(tf.getText());
			} catch (Exception x) {
				x.printStackTrace();
			}
			jfCustom.dispose();

			bOK = null;
			tf = null;
			jfCustom = null;

			frequency = CUSTOM;
			bf.setText("Frequency: CUSTOM (" + CUSTOM + ")");
		}

		if (e.getSource() == bButtons) {
			if (buttons == WASD) {
				buttons = NUMBERS;
				bButtons.setText("BUTTONS: NUMBERS");
			} else if (buttons == NUMBERS) {
				buttons = ARROWS;
				bButtons.setText("BUTTONS: ARROWS");
			} else if (buttons == ARROWS) {
				buttons = CURSOR;
				bButtons.setText("BUTTONS: CURSOR");
			} else if (buttons == CURSOR) {
				buttons = SPACE;
				bButtons.setText("BUTTONS: SPACE");
			} else if (buttons == SPACE) {
				buttons = WASD;
				bButtons.setText("BUTTONS: WASD");
			}
		}

		if (e.getSource() == bWASD) {
			buttons = WASD;
			bButtons.setText("Buttons: WASD");
		}

		if (e.getSource() == bArr) {
			buttons = ARROWS;
			bButtons.setText("Buttons: ARROWS");
		}

		if (e.getSource() == bNum) {
			buttons = NUMBERS;
			bButtons.setText("Buttons: NUMBERS");
		}

		if (e.getSource() == bSpace) {
			buttons = SPACE;
			bButtons.setText("Buttons: SPACE");
		}

		if (e.getSource() == bCursor) {
			buttons = CURSOR;
			bButtons.setText("Buttons: CURSOR");
		}

		if (e.getSource() == bReset) {
			frequency = MEDI;
			bf.setText("Frequency: MEDI");
			buttons = WASD;
			bButtons.setText("Buttons: WASD");
			movement = CIRCLE;
			bMov.setText("Movement: CIRCLE");
			status = OFF;
			bIO.setText("OFF");
			Hotkey = KeyEvent.VK_DELETE;
			bHotKey.setText("HOTKEY: DELETE");
			t.cancel();
		}

		if (e.getSource() == bHotKey) {
			bHotKey.setText("Choose Key");
			HotKeySearchActive = true;
		}

		if (e.getSource() == bMov) {
			if (movement == LEFT_RIGHT) {
				movement = FORWARD_BACKWARD;
				bMov.setText("Movement: FORWARD-BACKWARD");
			} else if (movement == FORWARD_BACKWARD) {
				movement = CIRCLE;
				bMov.setText("Movement: CIRCLE");
			} else if (movement == CIRCLE) {
				movement = LEFT_RIGHT;
				bMov.setText("Movement: LEFT-RIGHT");
			}
		}

		if (e.getSource() == bLR) {
			movement = LEFT_RIGHT;
			bMov.setText("Movement: LEFT-RIGHT");
		}

		if (e.getSource() == bFB) {
			movement = FORWARD_BACKWARD;
			bMov.setText("Movement: FORWARD-BACKWARD");
		}

		if (e.getSource() == bCirc) {
			movement = CIRCLE;
			bMov.setText("Movement: CIRCLE");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (HotKeySearchActive == false) {
			if (e.getKeyCode() == Hotkey) {
				status = OFF;
				t.cancel();
				bIO.setText("OFF");
			}
		} else if (HotKeySearchActive) {
			Hotkey = e.getKeyCode();
			bHotKey.setText("HotKey: " + Hotkey);
			System.out.println(Hotkey);
			HotKeySearchActive = false;
		}
		System.out.println("x");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}