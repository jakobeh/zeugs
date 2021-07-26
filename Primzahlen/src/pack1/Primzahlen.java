package pack1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Primzahlen implements ActionListener{
JButton bOK;
JTextField jt;
int a;

	public static void main(String[] args) throws IOException {
		new Primzahlen().setUpGui();
	}
	
	public void setUpGui() {
		JFrame eingabeFrame = new JFrame("Primzahlen-Rechner bis:");
		jt = new JTextField();
		eingabeFrame.setSize(200,250);
		eingabeFrame.setLocationRelativeTo(null);
		eingabeFrame.setLayout(null);
		eingabeFrame.add(jt);
		eingabeFrame.setVisible(true);
		//eingabeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jt.setBounds(0, 0, 200, 150);
		jt.setFont(new Font("CALIBRI", Font.BOLD, 20));
		jt.setVisible(true);
		
		bOK = new JButton("OK");
		eingabeFrame.add(bOK);
		bOK.setBounds(0, 150, 200, 50);
		bOK.setVisible(true);
		bOK.addActionListener(this);
		bOK.requestFocus();
		
	}

	public static void berechnePrimzahlen(int area) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("Primzahlen bis " + area));
		
		//System.out.println("2 ist eine Primzahl. Nummer: 1");
		writer.write("2 ist eine Primzahl. Nummer: 1");
		int current = 3;
		int ord = 1;
		double a;
		
		while (current < area) {
			boolean primzahl = true;
			for (int i = 2; i <= (current / 2); i++) {
				a = (double) current / (double) i;
				if (a == (int) a) {
					primzahl = false;
				}
			}
			if (primzahl) {
				ord++;
				//System.out.println(current + " ist eine Primzahl. Nummer: " + ord);
				writer.newLine();
				writer.append(current + " ist eine Primzahl. Nummer: " + ord);
				
			}
			current += 2;
		}
		writer.close();
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bOK) {
			try{
				a = Integer.parseInt(jt.getText());
				berechnePrimzahlen(a);
			} catch(Exception x) {
				x.printStackTrace();
			}
		}
		
	}
}
