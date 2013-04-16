package framework;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	public final static MainPanel instance = new MainPanel();
	
	private MainPanel() {
		
		this.setLayout(new GridLayout(5,5));
		this.setVisible(true);
		
	}

}
