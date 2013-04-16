package framework;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class StatusBar extends JTextField {
	
	public final static StatusBar instance = new StatusBar();
	
	private StatusBar() {		
		this.setLayout(new GridLayout(1,0));
		this.setVisible(true);
		this.setSize(MainFrame.width, 20);
		JTextField StatusBarField = new JTextField();
		
		this.add(StatusBarField);
	}
}

	