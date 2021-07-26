package Data;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;

import Algo.StundenplanGenerator;
import time.Stundenplan;
import time.Tag;

public class Schule {

	private int MAX = 0;

	public Lehrer[] lehrer;
	public Fachschaft[] fachschaften;
	public int delta_t;
	public float[] start_time, end_time;

	public Schule(int delta_t, float[] start_time, float[] end_time) {
		this.delta_t = delta_t;
		this.start_time = start_time;
		this.end_time = end_time;
		
		liesAlles("test.txt");

		sortiereFachschaften(MAX);
	}

	public void liesAlles(String path) {

		ArrayList<Lehrer> lehrer = new ArrayList<Lehrer>();
		
		ArrayList<ArrayList<Lehrer>> f_lehrer = new ArrayList<ArrayList<Lehrer>>();
		
		int[] dauern = new int[Fachschaft.Type.values().length];
		int[] mindest_teilnehmer = new int[Fachschaft.Type.values().length];
		
		for (int i = 0; i < Fachschaft.Type.values().length; i++) {
			
			f_lehrer.add(new ArrayList<Lehrer>());
			
		}
		
		String line;
		

		InputStream stream = Schule.class.getResourceAsStream("/" + path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		try {
			while ((line = reader.readLine()) != null) {
				
				String[] word = line.split(",");
				
				Stundenplan plan = new Stundenplan(delta_t, start_time, end_time);
				
				int fächer_zahl = Integer.parseInt(word[5]);
				int counter = 0;
				
				for (int i = 0; i < 5; i++) {
					
					Tag tag = plan.tage[i]; 
					
					for (int j = 0; j < tag.abschnittzahl; j++) {
						
						tag.abschnitte[j] = word[6 + fächer_zahl + counter];
						
					}
					
				}
				
				if (word[1].equals("true")) {
					
					int index = Fachschaft.Type.valueOf(word[2]).ordinal();
					dauern[index] = Integer.parseInt(word[3]);
					mindest_teilnehmer[index] = Integer.parseInt(word[4]);
					
				}
				
				Lehrer l = new Lehrer(word[0], plan);
				
				lehrer.add(l);
				
				for (int i = 0; i < f_lehrer.size(); i++) {
					
					for (int j = 0; j < fächer_zahl; j++) {
						
						if (word[6 + j] == Fachschaft.Type.values()[i].toString()) {
							
							f_lehrer.get(i).add(l);
							
						}
						
					}
					
				}
				
			}
			
//			this.lehrer = new Lehrer[lehrer.size()];
//			for (int i = 0; i < lehrer.size(); i++) {
//				
//				this.lehrer[i] = lehrer.get(i);
//				
//			}
			
			lehrer.toArray(this.lehrer);
			
			for (int i = 0; i < f_lehrer.size(); i++) {
				
				Lehrer[] l = new Lehrer[f_lehrer.get(i).size()];
				f_lehrer.get(i).toArray(l);
				
				fachschaften[i] = new Fachschaft(l, dauern[i], mindest_teilnehmer[i], Fachschaft.Type.values()[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sortiereFachschaften(int howto) {
		if (howto == MAX) {
			sortMAX();
		}

	}

	public void sortMAX() {

	}

	public int findMAX(int[] arg) {
		int max = 0;
		for (int i = 0; i < arg.length; i++) {
			if (arg[i] > arg[max]) {
				max = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		float[] s_t = { 10, 10, 10, 10, 12 };
		float[] e_t = { 16.5f, 20, 16, 19, 18 };
		Schule schule = new Schule(15, s_t, e_t);
		StundenplanGenerator gen = new StundenplanGenerator(schule);
		Stundenplan plan = gen.generate(0);
		System.out.println(plan.print());

		BufferedImage img = plan.toImage();
		JFrame frame = new JFrame("Plan");
		frame.setSize(img.getWidth(), img.getHeight() + 34);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graphics g = frame.getGraphics();
		g.drawImage(img, 0, 34, img.getWidth(), img.getHeight(), null);
	}
}
