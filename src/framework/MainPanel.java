package framework;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	public final static MainPanel instance = new MainPanel();
	
	private MainPanel() {
		this.setVisible(true);
	}

}
