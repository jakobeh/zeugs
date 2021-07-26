package pack1;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class Gui {

	public Gui() {
		Var.jf1 = new JFrame();
		Var.jf1.setSize(Var.screenwidth, Var.screenheight);
		Var.jf1.setVisible(true);
		Var.jf1.setTitle("Dicke´s Quest: CADOF reloaded");
		Var.jf1.setResizable(false);
		Var.jf1.setLocationRelativeTo(null);
		Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Var.lbl1 = new Label();
		Var.jf1.add(Var.lbl1);
		Var.lbl1.setBounds(0,0,Var.screenwidth, Var.screenheight);
		Var.lbl1.setVisible(true);
		
		Var.jf1.addKeyListener(new KeyHandler());
		Var.jf1.requestFocus();
		
		Var.dickeHitbox = new Rectangle();
		Var.dickeHitbox.setSize(Var.dickewidth, Var.dickeheight);
		Var.dickeHitbox.setLocation(Var.dickeX, Var.dickeY);
		
		Var.BodenHitbox = new Rectangle();
		Var.BodenHitbox.setSize(Var.screenwidth, Var.Bodenlevel);
		Var.BodenHitbox.setLocation(0, Var.screenheight - Var.Bodenlevel);
	}

}
