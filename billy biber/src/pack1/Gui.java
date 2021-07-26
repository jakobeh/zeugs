package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui {

	public Gui() {

		Var.jf1 = new JFrame();
		Var.jf1.setSize(Var.screenwidth, Var.screenheight);
		Var.jf1.setResizable(false);
		Var.jf1.setLocationRelativeTo(null);
		Var.jf1.setTitle("Billy Biber");
		Var.jf1.setLayout(null);
		Var.jf1.setVisible(true);
		Var.jf1.addKeyListener((KeyListener) new KeyHandler());
		Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var.jf1.requestFocus();
/*
		Var.btnresume = new JButton();
		Var.btnresume.setText("Resume");
		Var.btnresume.setBounds(30, 50, 725, 50);
		Var.btnresume.setVisible(false);
		Var.btnresume.addActionListener(new ActionHandler());
		Var.btnresume.setBackground(Color.BLACK);
		Var.btnresume.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnresume.setForeground(Color.WHITE);
		Var.btnresume.setBorder(null);
		Var.btnresume.setFocusPainted(false);
		Var.btnresume.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnresume.setBackground(new Color(0, 230, 115));
				Var.btnresume.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent evt) {
				Var.btnresume.setBackground(Color.BLACK);
				Var.btnresume.setForeground(Color.WHITE);
			}
		});

		Var.jf1.add(Var.btnresume);

		Var.btnshop = new JButton();
		Var.btnshop.setText("Shop");
		Var.btnshop.setBounds(30, 150, 725, 50);
		Var.btnshop.setVisible(false);
		Var.btnshop.addActionListener(new ActionHandler());
		Var.btnshop.setBackground(Color.BLACK);
		Var.btnshop.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnshop.setForeground(Color.WHITE);
		Var.btnshop.setBorder(null);
		Var.btnshop.setFocusPainted(false);
		Var.btnshop.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnshop.setBackground(new Color(0, 230, 115));
				Var.btnshop.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent evt) {
				Var.btnshop.setBackground(Color.BLACK);
				Var.btnshop.setForeground(Color.WHITE);
			}
		});

		Var.jf1.add(Var.btnoptionen);

		Var.btnoptionen = new JButton();
		Var.btnoptionen.setText("Optionen");
		Var.btnoptionen.setBounds(30, 250, 725, 50);
		Var.btnoptionen.setVisible(false);
		Var.btnoptionen.addActionListener(new ActionHandler());
		Var.btnoptionen.setBackground(Color.BLACK);
		Var.btnoptionen.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnoptionen.setForeground(Color.WHITE);
		Var.btnoptionen.setBorder(null);
		Var.btnoptionen.setFocusPainted(false);
		Var.btnoptionen.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnoptionen.setBackground(new Color(0, 230, 115));
				Var.btnoptionen.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent evt) {
				Var.btnoptionen.setBackground(Color.BLACK);
				Var.btnoptionen.setForeground(Color.WHITE);
			}
		});

		Var.jf1.add(Var.btnoptionen);

		Var.btnexit = new JButton();
		Var.btnexit.setText("Exit");
		Var.btnexit.setBounds(30, 350, 725, 50);
		Var.btnexit.setVisible(false);
		Var.btnexit.addActionListener(new ActionHandler());
		Var.btnexit.setBackground(Color.BLACK);
		Var.btnexit.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnexit.setForeground(Color.WHITE);
		Var.btnexit.setBorder(null);
		Var.btnexit.setFocusPainted(false);
		Var.btnexit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnexit.setBackground(new Color(0, 230, 115));
				Var.btnexit.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent evt) {
				Var.btnexit.setBackground(Color.BLACK);
				Var.btnexit.setForeground(Color.WHITE);
			}
		});

		Var.jf1.add(Var.btnplay);

		Var.btnplay = new JButton();
		Var.btnplay.setText("PLAY");
		Var.btnplay.setBounds(100, 400, 600, 100);
		Var.btnplay.setVisible(false);
		Var.btnplay.addActionListener(new ActionHandler());
		Var.btnplay.setBackground(new Color(0, 0, 153));
		Var.btnplay.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnplay.setForeground(Color.WHITE);
		Var.btnplay.setBorder(null);
		Var.btnplay.setFocusPainted(false);
		Var.btnplay.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnplay.setBackground(new Color(0, 102, 204));
				Var.btnplay.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent evt) {
				Var.btnplay.setBackground(new Color(0, 0, 153));
				Var.btnplay.setForeground(Color.WHITE);
			}
		});

		Var.jf1.add(Var.btnplay);

		Var.btnplayagain = new JButton();
		Var.btnplayagain.setText("PLAY AGAIN");
		Var.btnplayagain.setBounds(30, 350, 725, 50);
		Var.btnplayagain.setVisible(false);
		Var.btnplayagain.addActionListener(new ActionHandler());
		Var.btnplayagain.setBackground(Color.BLACK);
		Var.btnplayagain.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnplayagain.setForeground(Color.WHITE);
		Var.btnplayagain.setBorder(null);
		Var.btnplayagain.setFocusPainted(false);
		Var.btnplayagain.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnplayagain.setBackground(new Color(0, 230, 115));
				Var.btnplayagain.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent evt) {
				Var.btnplayagain.setBackground(Color.BLACK);
				Var.btnplayagain.setForeground(Color.WHITE);
			}
		});

		Var.jf1.add(Var.btnplayagain);
*/
		Var.lbl1 = new Label();
		Var.lbl1.setBounds(0, 0, Var.screenwidth, Var.screenheight);
		Var.jf1.add(Var.lbl1);

	}

}
