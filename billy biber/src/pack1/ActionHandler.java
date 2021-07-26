package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

	public ActionHandler() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Var.btnplay) {
			Var.imStart = false;
			Var.imSpiel = true;
			Var.inOptionen = false;
			Var.imMenu = false;
			Var.imShop = false;
			Var.imGameover = false;
			
			Var.btnplay.setVisible(false);
			Var.btnoptionen.setVisible(false);
			Var.btnshop.setVisible(false);
			Var.btnresume.setVisible(false);
			Var.btnplayagain.setVisible(false);
			Var.btnexit.setVisible(false);
		}
		if (e.getSource() == Var.btnoptionen) {
			Var.imStart = false;
			Var.imSpiel = false;
			Var.inOptionen = true;
			Var.imMenu = false;
			Var.imShop = false;
			Var.imGameover = false;
			
			Var.btnplay.setVisible(false);
			Var.btnoptionen.setVisible(false);
			Var.btnshop.setVisible(false);
			Var.btnresume.setVisible(true);
			Var.btnplayagain.setVisible(false);
			Var.btnexit.setVisible(false);
		}
		if (e.getSource() == Var.btnplayagain) {
			Var.imStart = false;
			Var.imSpiel = true;
			Var.inOptionen = false;
			Var.imMenu = false;
			Var.imShop = false;
			Var.imGameover = false;
			
			Var.btnplay.setVisible(false);
			Var.btnoptionen.setVisible(false);
			Var.btnshop.setVisible(false);
			Var.btnresume.setVisible(false);
			Var.btnplayagain.setVisible(false);
			Var.btnexit.setVisible(false);
		}
		if (e.getSource() == Var.btnresume) {
			Var.imStart = false;
			Var.imSpiel = true;
			Var.inOptionen = false;
			Var.imMenu = false;
			Var.imShop = false;
			Var.imGameover = false;
			
			Var.btnplay.setVisible(false);
			Var.btnoptionen.setVisible(false);
			Var.btnshop.setVisible(false);
			Var.btnresume.setVisible(false);
			Var.btnplayagain.setVisible(false);
			Var.btnexit.setVisible(false);
		}
		if (e.getSource() == Var.btnshop) {
			Var.imStart = false;
			Var.imSpiel = false;
			Var.inOptionen = false;
			Var.imMenu = false;
			Var.imShop = true;
			Var.imGameover = false;
			
			Var.btnplay.setVisible(false);
			Var.btnoptionen.setVisible(false);
			Var.btnshop.setVisible(false);
			Var.btnresume.setVisible(true);
			Var.btnplayagain.setVisible(false);
			Var.btnexit.setVisible(false);
		}
		if (e.getSource() == Var.btnexit) {
			System.exit(0);
		}

	}

}
